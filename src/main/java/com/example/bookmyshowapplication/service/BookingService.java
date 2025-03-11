package com.example.bookmyshowapplication.service;

import com.example.bookmyshowapplication.models.Booking;
import com.example.bookmyshowapplication.models.ShowSeat;
import com.example.bookmyshowapplication.repository.BookingRepository;
import com.example.bookmyshowapplication.repository.ShowSeatRepository;

import java.util.List;

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

    // Get the List of seat ids selected by users as input
    public Booking bookTicket(List<Long> showSeatList) {
        // Fetch the ShowSeats from the DB using its id (which we got in input)
        // i.e. List of seat ids -> List of seat objects
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatList);

        if(showSeats.size() == 0) {
            System.out.println("Invalid Show Seats");
        }
        return null;
    }
}








