package com.apiFactory.flightBooking.controller;

import com.apiFactory.flightBooking.model.Flight;
import com.apiFactory.flightBooking.model.FlightBookingEntity;
import com.apiFactory.flightBooking.model.FlightDetailsResponse;
import com.apiFactory.flightBooking.model.ReservationRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

public interface flightBookingApi {

    @ApiOperation(value = "Please Add the flight details", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added list of currently available flights"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping("api/addFlight")
    public String addFlight(@RequestBody Flight flight);


    @ApiOperation(value = "View a list of available flights", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of currently available filghts"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("api/getFlightDetails")
    public List<Flight> getFlightDetails();

    @ApiOperation(value = "View a list of available flights for the given destination", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of currently available flights"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("api/findFlights")
    public List<FlightDetailsResponse> findFlights(@RequestParam("source") String source, @RequestParam("destination") String destination
                                                   );

    @ApiOperation(value = "Please Book the flight ticket", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of currently available flights"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping("api/flightBooking")
    public FlightBookingEntity bookFlight(@RequestBody ReservationRequest reservationRequest);
}
