package com.example.bookmyshowapplication.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// DTOs (Data Transfer Objects) are a design pattern used in Spring Boot applications to transfer data between different layers -> between the service layer and the controller layer.
@Getter
@Setter
@Data
public class CreateBooking {
    // Users will select the seats in UI & function in this method will only get the List of those seat ids
    List<Long> seatIds;

    public List<Long> getSeatIds() {
        return seatIds;
    }
}
