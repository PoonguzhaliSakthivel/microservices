package com.apiFactory.flightBooking.model;

import lombok.Data;

@Data
public class FlightDetailsResponse extends Flight {
    private int availableTickets;
}
