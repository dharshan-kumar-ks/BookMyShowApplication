package com.example.bookmyshowapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "hall")
public class Hall extends BaseModel {
    // Multiple Halls can belong to 1 Venue
    @ManyToOne
    // It defines the column in the current table that acts as a foreign key referencing another table's primary key.
    @JoinColumn(name = "venue_id") // column name is "venue_id"
    private Venue venue;

    // 1 Hall can have multiple seats
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hall")
    private List<Seat> seats;
    // whenever the Halls data is fetched -> then seats data will also be fetched (due to EAGER fetching)

    //private ScreenType screenType; -> not needed now for this project

}

/*
id   | name       | venue_id (FK)
---- | ---------- | --------
 1   | Hall 1     | 1
 2   | Hall 2     | 1
 3   | Hall 3     | 2
 */