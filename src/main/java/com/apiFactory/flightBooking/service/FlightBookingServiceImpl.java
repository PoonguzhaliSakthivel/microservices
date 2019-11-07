package com.apiFactory.flightBooking.service;

import com.apiFactory.flightBooking.exception.FlightNotFound;
import com.apiFactory.flightBooking.exception.TicketsNotAvailable;
import com.apiFactory.flightBooking.model.*;
import com.apiFactory.flightBooking.repository.FlightBookingRepository;
import com.apiFactory.flightBooking.repository.FlightRepository;
import com.apiFactory.flightBooking.repository.PassengerRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class FlightBookingServiceImpl implements FlightBookingService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FlightBookingRepository flightBookingRepository;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public String addFlight(Flight flight) {
        FlightEntity flightEntity = modelMapper.map(flight, FlightEntity.class);
        if(flightEntity.getAvailableTickets()==0)
        {
            flightEntity.setAvailableTickets(flightEntity.getTotalNumberOfTickets());
        }
        flightRepository.save(flightEntity);
        return "Saved Successfully";
    }

    @Override
    public List<Flight> findAllFlightsDetails() {
        List<FlightEntity> flights = flightRepository.findAll();
        List<Flight> f=flights.stream().map(flight->modelMapper.map(flight, Flight.class)).collect(Collectors.toList());
        return f;
    }

    @Override
    public List<FlightDetailsResponse> findFlight(String arraival, String destination) {
        List<FlightEntity> flights = flightRepository.findAllByArrivalCityAndDepartureCity(arraival, destination);
        List<FlightDetailsResponse> f=flights.stream().map(flight->modelMapper.map(flight, FlightDetailsResponse.class)).collect(Collectors.toList());

        return f;

    }

    @Override
    public FlightBookingEntity bookFlight(ReservationRequest reservationRequest) {
        // make payment here
        // if the payment is successful proceed..
        log.info("Flight Booking Started");
        String flightId=reservationRequest.getFlightId();
        Optional<FlightEntity> flightOptional= Optional.ofNullable(flightRepository.findByFlightNumber(flightId));
        if (!flightOptional.isPresent()) {
            throw new FlightNotFound("No flight found with id "+flightId);
        }
        log.info("Flight found with id: {}",flightId);
        FlightEntity flight=flightOptional.get();
        if(flight.getAvailableTickets()==0)
        {
            throw new TicketsNotAvailable("Tickets are not available");
        }else {
            int availableTickets = flight.getAvailableTickets() - 1;
            flight.setAvailableTickets(availableTickets);
        }
        Passenger passenger=new Passenger();
        passenger.setFirstName(reservationRequest.getPassengerFirstName());
        passenger.setLastName(reservationRequest.getPassengerLastName());
        passenger.setEmailId(reservationRequest.getPassengerEmail());
        passenger.setPhone(reservationRequest.getPassengerPhone());

        passengerRepository.save(passenger);
        log.info("Saved the passenger:" + passenger);

        FlightBookingEntity reservation=new FlightBookingEntity();
        reservation.setFlight(flight);
        reservation.setPassenger(passenger);
        final FlightBookingEntity savedReservation = flightBookingRepository.save(reservation);
        log.info("Saving the reservation:" + reservation);

        return savedReservation;

    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
