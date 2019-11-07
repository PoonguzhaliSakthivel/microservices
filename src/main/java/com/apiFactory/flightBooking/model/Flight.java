package com.apiFactory.flightBooking.model;


import java.time.LocalDateTime;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


@Data

public class Flight {

    private String flightNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date dateOfDeparture;
    private LocalDateTime estimatedDepartureTime;
    private int totalNumberOfTickets;
}
