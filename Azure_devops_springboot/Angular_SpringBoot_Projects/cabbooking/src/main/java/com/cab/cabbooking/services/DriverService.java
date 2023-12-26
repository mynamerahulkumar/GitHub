package com.cab.cabbooking.services;

import com.cab.cabbooking.dtos.DriverOutPutDTO;
import com.cab.cabbooking.entity.Driver;

public interface DriverService {

    DriverOutPutDTO insertDriver(Driver driver);

    DriverOutPutDTO updateDriver(Driver driver,String uuid);

    DriverOutPutDTO deleteDriver(Integer driverId,String uuid);
}
