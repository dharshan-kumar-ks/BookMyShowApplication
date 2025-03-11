package com.example.bookmyshowapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "venue")
public class Venue extends BaseModel {
    private String name;
    private String city;

    // for Lists, we need to specify the mappings
    // 1 Venue can have multiple halls
    @OneToMany(mappedBy = "venue")
    private List<Hall> halls;
    // 'mappedBy' define the ownership of the relationship. Both entities are aware of each other, but the Hall entity owns the relationship because it contains the foreign key.
    // -> indicates that there is no foreign key in the Venue table pointing to the Hall table. Instead, the Hall table has a foreign key
}

/*
id   | name
---- | -----
 1   | Venue A
 2   | Venue B
 */



