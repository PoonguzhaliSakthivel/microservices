package com.apiFactory.flightBooking.repository;

import com.apiFactory.flightBooking.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
