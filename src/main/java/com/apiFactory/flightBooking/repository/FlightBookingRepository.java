package com.apiFactory.flightBooking.repository;

import com.apiFactory.flightBooking.model.FlightBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBookingEntity,Long> {
}
