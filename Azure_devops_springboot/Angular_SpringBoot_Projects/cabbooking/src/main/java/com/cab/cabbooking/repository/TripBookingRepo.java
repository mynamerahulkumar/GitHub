package com.cab.cabbooking.repository;

import com.cab.cabbooking.dtos.TripBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripBookingRepo extends JpaRepository<TripBooking,Integer> {
}
