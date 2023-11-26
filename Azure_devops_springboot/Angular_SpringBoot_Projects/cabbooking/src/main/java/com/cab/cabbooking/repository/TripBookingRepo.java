package com.cab.cabbooking.repository;

import com.cab.cabbooking.entity.TripBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripBookingRepo extends JpaRepository<TripBooking,Integer> {
}
