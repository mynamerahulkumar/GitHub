package com.cab.cabbooking.repository;

import com.cab.cabbooking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {


    Customer findByemail(String email);
}