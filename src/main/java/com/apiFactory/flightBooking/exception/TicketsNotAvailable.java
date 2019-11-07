package com.apiFactory.flightBooking.exception;

public class TicketsNotAvailable extends RuntimeException {
    public TicketsNotAvailable(String exception) {
        super(exception);
    }
}
