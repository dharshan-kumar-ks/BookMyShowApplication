package com.example.bookmyshowapplication.service;

import com.example.bookmyshowapplication.models.Show;
import com.example.bookmyshowapplication.models.ShowSeat;
import com.example.bookmyshowapplication.repository.ShowRepository;
import com.example.bookmyshowapplication.repository.ShowSeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowSeatService {
    // we need the:
    // showRepository -> to get the seat info from its showId
    // showSeatRepository -> Get all the seats for the specific show
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;

    // Constructor - for object injection
    public ShowSeatService(ShowRepository showRepository, ShowSeatRepository showSeatRepository) {
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }

    // Given the show id -> return the List of all seats for that Show
    public List<ShowSeat> findShowSeatsbyShowId(Long showId) {
        // Get the seat info from its showId
        Optional<Show> show = showRepository.findById(showId);

        // if showId is invalid then Show object will be null -> then throw an error
        if(show.isPresent()) {
            throw new IllegalArgumentException("Show not found");
        }

        // Get all the seats for the specific show
        List<ShowSeat> showSeat = showSeatRepository.findAllByShow(show.get());
        return showSeat;
    }
}
