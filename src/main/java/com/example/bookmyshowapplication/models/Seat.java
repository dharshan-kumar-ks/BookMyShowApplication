package com.example.bookmyshowapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "seat")
public class Seat extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    // sometimes, 'row' & 'column' might be reserved words -> so use a custom table name
    @Column(name = "hall_row")
    private int row;
    @Column(name = "hall_col")
    private int col;

    // defines how the enumeration values are stored in the database.
    // by default -> DB uses EnumType.ORDINAL, it will be stored as 0, 1, 2
    @Enumerated
    private SeatType seatType;
    // @Enumerated(EnumType.STRING) -> the seatType will be stored as 'GOLD', 'SILVER', 'PREMIUM' in the DB as strings

}
