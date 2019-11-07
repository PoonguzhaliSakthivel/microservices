package com.apiFactory.flightBooking.controller;

import com.apiFactory.flightBooking.model.*;
import com.apiFactory.flightBooking.repository.FlightRepository;
import com.apiFactory.flightBooking.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.List;

@RestController
@EnableSwagger2
public class flightBookingController implements flightBookingApi {
    @Autowired
    FlightBookingService flightBookingService;


    @PostMapping("api/addFlight")
    public String addFlight(@RequestBody Flight flight) {
       String response= flightBookingService.addFlight(flight);
        return response;
    }

    @GetMapping("api/getFlightDetails")
    public List<Flight> getFlightDetails() {
       return  flightBookingService.findAllFlightsDetails();
    }

    @GetMapping("api/findFlights")
    public List<FlightDetailsResponse> findFlights(@RequestParam("arrivalCity") String source, @RequestParam("departureCity") String destination
                                                  // @RequestParam("departDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departDate)
    ){

       return flightBookingService.findFlight(source,destination);
    }
    @PostMapping("api/flightBooking")
    public FlightBookingEntity bookFlight(@RequestBody ReservationRequest reservationRequest)
    {
        return flightBookingService.bookFlight(reservationRequest);
    }


}
