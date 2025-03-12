package com.example.bookmyshowapplication.repository;

import com.example.bookmyshowapplication.models.Show;
import com.example.bookmyshowapplication.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// JpaRepository<ShowSeat, Long>
// 1st parameter (ShowSeat) -> tells Spring Data JPA that this repository is responsible for performing CRUD operations on the ShowSeat entity
// 2nd parameter (Long) -> specifies the type of the primary key (ID) of the entity.
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    // This method is a custom query that retrieves a list of ShowSeat objects associated with a specific Show
    // find all entities (findAll) based on a condition (By) related to the Show entity
    List<ShowSeat> findAllByShow(Show show);
    // Spring Data JPA will automatically generate a query
    // SELECT s FROM ShowSeat s WHERE s.show = :show   |  :show -> actual Show object pass as input


    // findAllByShowAndStatus(Show show, SeatStatus status)
}
