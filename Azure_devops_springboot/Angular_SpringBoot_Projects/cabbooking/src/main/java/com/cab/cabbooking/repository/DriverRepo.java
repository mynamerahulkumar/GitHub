package com.cab.cabbooking.repository;

import com.cab.cabbooking.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepo  extends JpaRepository<Driver,Integer> {

    Driver findByLicenseNo(String licenseNo);

    Driver findByEmail(String email);

    List<Driver> findByCurrLocationAndCurrDriverStatus(String currLocation,String currDriverStatus);

}