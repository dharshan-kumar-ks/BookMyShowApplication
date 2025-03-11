package com.example.bookmyshowapplication.models;

// JPA is used for mapping Java classes to database tables
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// indicates that the class is an entity/table -> tells JPA to map this class to a database table
@Entity
// name of the database table that the entity maps to.
// If not specified, JPA will use the class name as the table name.
@Table(name = "movie")
public class Movie extends BaseModel {
    // Needs the 'name' attribute to be unique
    @Column(unique = true)
    private String name;

    private int duration;
}





