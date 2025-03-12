package com.example.bookmyshowapplication.repository;

import com.example.bookmyshowapplication.models.Show;
import com.example.bookmyshowapplication.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    // Get the seat info from its showId
    Optional<Show> findById(Long showId);
}
