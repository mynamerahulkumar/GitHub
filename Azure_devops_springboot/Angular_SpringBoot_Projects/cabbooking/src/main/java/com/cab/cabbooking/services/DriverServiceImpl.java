package com.cab.cabbooking.services;

import com.cab.cabbooking.constants.CabBookingConstants;
import com.cab.cabbooking.dtos.CabOutPutDTO;
import com.cab.cabbooking.dtos.DriverOutPutDTO;
import com.cab.cabbooking.entity.Cab;
import com.cab.cabbooking.entity.CurrentUserSession;
import com.cab.cabbooking.entity.Driver;
import com.cab.cabbooking.exception.CabException;
import com.cab.cabbooking.mapper.CabMapper;
import com.cab.cabbooking.mapper.DriverMapper;
import com.cab.cabbooking.processor.CabProcessor;
import com.cab.cabbooking.processor.DriverProcessor;
import com.cab.cabbooking.repository.CurrentUserSessionRepo;
import com.cab.cabbooking.repository.CustomerRepo;
import com.cab.cabbooking.repository.DriverRepo;
import com.cab.cabbooking.repository.TripBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverServiceImpl  implements  DriverService{

    @Autowired
    private DriverProcessor driverProcessor;

    @Autowired
    private DriverMapper driverMapper;
    @Override
    public DriverOutPutDTO insertDriver(Driver driver) {

        Driver resDriver = driverProcessor.insertDriverProcess(driver);
        DriverOutPutDTO driverOutPutDTO = driverMapper.updateResponseInsert(resDriver);
        return driverOutPutDTO;

    }

    @Override
    public DriverOutPutDTO updateDriver(Driver driver, String uuid) {
        Driver resDriver = driverProcessor.updateDriverProcess(driver,uuid);
        DriverOutPutDTO driverOutPutDTO = driverMapper.updateResponseUpdate(resDriver);
        return driverOutPutDTO;

    }

    @Override
    public DriverOutPutDTO deleteDriver(Integer driverId,String uuid) {
        Driver resDriver = driverProcessor.deleteDriverProcess(driverId,uuid);
        DriverOutPutDTO driverOutPutDTO = driverMapper.updateResponseDelete(resDriver);
        return driverOutPutDTO;
    }

}
