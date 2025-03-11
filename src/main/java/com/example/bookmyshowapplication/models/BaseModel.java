package com.example.bookmyshowapplication.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

// used to define a class that can be inherited by entities but is not itself an entity.
// allows you to extract common attributes or behavior into a superclass, which are then inherited by subclasses that are entities.
// superclass itself is not mapped to a database table, but its attributes are included in the tables of its subclasses
@MappedSuperclass
public class BaseModel {
    // marks this class attribute as the primary key of the table
    @Id
    // indicates that the primary key should be automatically generated for each row by the database
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // specifies the details of the column in the database table
    @Column(name = "id", nullable = false) // nullable is 'false' by default
    private Long id;

    /*
    // @CreatedDate & @LastModifiedDate -> annotations are used with JPA auditing to automatically set the creation and modification timestamps when an entity is created or updated.
    @CreatedDate
    @Temporal(TemporalType.TIME)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIME)
    private Date lastModifiedAt;
     */
}
