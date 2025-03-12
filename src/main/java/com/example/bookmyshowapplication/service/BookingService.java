package com.example.bookmyshowapplication.service;

import com.example.bookmyshowapplication.exceptions.SeatsAlreadyBookedException;
import com.example.bookmyshowapplication.models.Booking;
import com.example.bookmyshowapplication.models.ShowSeat;
import com.example.bookmyshowapplication.models.ShowSeatStatus;
import com.example.bookmyshowapplication.repository.BookingRepository;
import com.example.bookmyshowapplication.repository.ShowSeatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {
    BookingRepository bookingRepository;
    ShowSeatRepository showSeatRepository;

    // Constructor - for object injection
    public BookingService(BookingRepository bookingRepository, ShowSeatRepository showSeatRepository) {
        this.bookingRepository = bookingRepository;
        this.showSeatRepository = showSeatRepository;
    }

    /*
    1. Fetch the show seats from the DB (based on seat id).
    2. Verify the status of the seats as available.
    3. Change the status of the seats to block and allow user some time to make payment.
    4. Finally, create the booking object.
     */

    // Make the Transaction to have Isolation level as "SERIALIZABLE" -> only 1 user can book the tickets at a time
    @Transactional(isolation = Isolation.SERIALIZABLE)
    // Get the List of seat ids selected by users as input
    public Booking bookTicket(List<Long> showSeatList) {
        // Fetch the ShowSeats from the DB using its id (which we got in input)
        // i.e. List of seat ids -> List of seat objects
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatList);

        // (1) if List of showSeats objects is empty -> the throw an error
        // (2) if List of showSeats objects is not equal to List of showSeat ids -> the throw an error
        // this can happen if some seat ids are invalid & those Seats were not fetched by DB
        if(showSeats.isEmpty() || showSeats.size() != showSeatList.size()) {
            throw new SeatsAlreadyBookedException();
        }

        int totalAmount = 0;
        // For all the Seats -> change the seat status as RESERVED
        for(ShowSeat showSeat : showSeats) {
            // (3) if any of the seat is not empty -> throw an error
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.FREE)) {
                throw new IllegalArgumentException("Something went wrong. Someone else booked the seats already");
            }

            showSeat.setShowSeatStatus(ShowSeatStatus.RESERVED);
            totalAmount += showSeat.getPrice(); // calculate the total amount by adding prices of all seats selected
        }



        // Build the booking object (using Builder)
        Booking booking = new Booking().builder()
                .show(showSeats.get(0).getShow()) // get the show object from any of the showSeats object (since all seats booked by the customer will belong to the same show in a session)
                .showSeat(showSeats)
                .bookedAt(Date.from(LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC)))
                .totalAmount(totalAmount)
                .build();
        // only if we save the 'showSeat' objects in repository -> then the showSeatStatus will be saved for those object in DB
        // else it will only be saved in the run-time & be lost when application stops running
        showSeatRepository.saveAll(showSeats);
        // save the Booking object in DB (using repository Layer)
        booking = bookingRepository.save(booking);
        return booking;
    }
}








