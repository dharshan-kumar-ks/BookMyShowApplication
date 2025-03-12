package com.example.bookmyshowapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// The client will receive this status code in response when this exception is thrown
@ResponseStatus(HttpStatus.FORBIDDEN)
public class SeatsAlreadyBookedException extends RuntimeException {
    public SeatsAlreadyBookedException() {
        super("Seats have already been booked");
    }
}
