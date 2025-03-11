package com.example.bookmyshowapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "movie_show")
public class Show extends BaseModel {
    // Multiple Shows can have 1 Movie
    @ManyToOne
    public Movie movie;
    // Multiple Shows can have 1 Hall
    @ManyToOne
    public Hall hall;

    // Maps to a SQL TIME type, which represents a time without date.
    @Temporal(TemporalType.TIME)
    private Date startTime;
}
