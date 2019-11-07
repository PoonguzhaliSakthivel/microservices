package com.apiFactory.flightBooking.model;

import lombok.Data;

@Data
public class ReservationRequest {
    private String flightId;
    private String passengerFirstName;
    private String passengerMiddleName;
    private String passengerLastName;
    private String passengerEmail;
    private String passengerPhone;
    private String nameOnTheCard;
    private String cardNumber;
}
