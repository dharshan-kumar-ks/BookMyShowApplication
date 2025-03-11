package com.example.bookmyshowapplication.controller;

import com.example.bookmyshowapplication.dtos.*;
import com.example.bookmyshowapplication.models.*;
import com.example.bookmyshowapplication.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// Having 'class-level endpoint' -> we want this one class to handle all requests coming to "/booking"
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    // Constructor - for dependency Injection
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // means @PostMapping("/bookings") -> the URL path that this method handles
    @PostMapping()
    // @RequestBody -> injects the JSON body of the POST request into a CreateBooking object.
    public Booking createBooking(@RequestBody CreateBooking createBooking) {
        // Send the List of seat ids selected by the customer to the Service Layer -> for creating the booking
        return bookingService.bookTicket(createBooking.getSeatIds());
    }
}
