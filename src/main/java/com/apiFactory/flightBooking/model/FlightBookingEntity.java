package com.apiFactory.flightBooking.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FlightBookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String flightNumber;
    @OneToOne
    private Passenger passenger;
    @OneToOne
    private FlightEntity flight;

}
