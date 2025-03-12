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

    // Defining getter since there is some problem with Lombok
    public Seat getSeat() { return seat; }
    public int getPrice() { return price; }
    public Show getShow() { return show; }
    public ShowSeatStatus getShowSeatStatus() { return showSeatStatus; }
    public void setShowSeatStatus(ShowSeatStatus showSeatStatus) { this.showSeatStatus = showSeatStatus; }

}
