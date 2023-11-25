package com.cab.cabbooking.services;

import com.cab.cabbooking.dtos.Driver;

public interface DriverService {

    Driver insertDriver(Driver driver);

    Driver updateDriver(Driver driver,String uuid);

    Driver deleteDriver(Integer driverId,String uuid);
}
