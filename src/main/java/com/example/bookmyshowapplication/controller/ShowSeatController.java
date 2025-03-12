package com.example.bookmyshowapplication.controller;

import com.example.bookmyshowapplication.dtos.SeatMap;
import com.example.bookmyshowapplication.service.ShowSeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class ShowSeatController {
    private ShowSeatService showSeatService;

    // Constructor - for object injection
    public ShowSeatController(ShowSeatService showSeatService) {
        this.showSeatService = showSeatService;
    }

    // Extract showId from the URL path & put it in the variable
    // Function is for -> Fetch the seats for a particular show
    @GetMapping("/{showId}")
    public SeatMap getSeatMap(@PathVariable(name = "showId") Long showId) {
        // findShowSeatsbyShowId(showId) -> Given the show id as input; return the List of Seats for that show id
        // SeatMap(List of Shows) -> Given the List of Seats as input; return the List of Pair<seat_row, seat_column> as output
        return new SeatMap(showSeatService.findShowSeatsbyShowId(showId));
    }

}
