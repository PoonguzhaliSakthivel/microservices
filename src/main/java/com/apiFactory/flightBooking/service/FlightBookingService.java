package com.apiFactory.flightBooking.service;

import com.apiFactory.flightBooking.model.Flight;
import com.apiFactory.flightBooking.model.FlightBookingEntity;
import com.apiFactory.flightBooking.model.FlightDetailsResponse;
import com.apiFactory.flightBooking.model.ReservationRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FlightBookingService {
    public String addFlight(Flight flight);
    public List<Flight> findAllFlightsDetails();
    public List<FlightDetailsResponse> findFlight(String arraival, String destination);
    public FlightBookingEntity bookFlight(ReservationRequest reservationRequest);
}
