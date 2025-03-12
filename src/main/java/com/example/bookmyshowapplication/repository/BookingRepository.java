package com.example.bookmyshowapplication.repository;

import com.example.bookmyshowapplication.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking save(Booking entity);

    @Override
    Optional<Booking> findById(Long aLong);

    // We can use JPQL queries also to retrieve the data from our DB tables:
    //@Query("select * from Booking") -> JPQL (Java Persistence Query Language)
    //@Query(value = "SELECT * FROM booking", nativeQuery = true) -> native SQL
    //List<Booking> findAllByShow(Show show);
}
