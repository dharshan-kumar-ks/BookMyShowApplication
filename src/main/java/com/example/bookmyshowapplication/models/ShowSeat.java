package com.example.bookmyshowapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@Table(name = "show_seat") | DB uses the class name as DB name if tableName is not specified
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Seat seat;

    @ManyToOne
    private Show show;

    private int price;

    @Enumerated
    private ShowSeatStatus showSeatStatus;

}
