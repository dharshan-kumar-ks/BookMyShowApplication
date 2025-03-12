package com.example.bookmyshowapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class ShowSeatController {

    // Extract showId from the URL path & put it in the variable
    // Function is for -> Fetch the seats for a particular show
    @GetMapping("/{showId}")
    public void SeatMap getSeatMap(@PathVariable(name = "showId") int showId) {
        return null;
    }

}
