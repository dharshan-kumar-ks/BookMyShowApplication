package com.example.bookmyshowapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking extends BaseModel {
    // 1 Booking can have multiple Shows
    @OneToMany
    private List<ShowSeat> showSeat;
    private double totalAmount;

    // annotation specifies that this attribute should be stored in date format in SQL table
    @Temporal(TemporalType.TIME)
    private Date bookedAt;

    // Multiple Booking can have 1 Show
    @ManyToOne
    private Show show;
}
