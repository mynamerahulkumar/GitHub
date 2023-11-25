package com.cab.cabbooking.repository;

import com.cab.cabbooking.dtos.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CabRepo extends JpaRepository<Cab,Integer> {


    Optional<Cab> findByCarNumber(String carNumber);
}
