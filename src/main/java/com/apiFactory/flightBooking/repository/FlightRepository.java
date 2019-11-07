package com.apiFactory.flightBooking.repository;

import com.apiFactory.flightBooking.model.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<FlightEntity,String>
{
List<FlightEntity> findAllByArrivalCityAndDepartureCity(String source, String destination);
FlightEntity findByFlightNumber(String flightNumber);

}
