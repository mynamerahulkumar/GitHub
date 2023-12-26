package com.cab.cabbooking.mapper;

import com.cab.cabbooking.constants.CabBookingConstants;
import com.cab.cabbooking.dtos.CabOutPutDTO;
import com.cab.cabbooking.dtos.DriverOutPutDTO;
import com.cab.cabbooking.entity.Customer;
import com.cab.cabbooking.entity.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {

    public Driver mapDriverUpdate(Driver driver,Driver driverDetailsByEmailId){
        Driver updatingdriver = driverDetailsByEmailId;
        updatingdriver.setAddress(driver.getAddress());
        updatingdriver.setEmail(driver.getEmail());
        updatingdriver.setMobileNumber(driver.getMobileNumber());
        updatingdriver.setPassword(driver.getPassword());
        updatingdriver.setUserName(driver.getUserName());
        updatingdriver.setLicenseNo(driver.getLicenseNo());
        updatingdriver.setCab(driver.getCab());
        return updatingdriver;
    }
    public DriverOutPutDTO updateResponseInsert(Driver driver){
        DriverOutPutDTO driverOutPutDTO=new DriverOutPutDTO();
        if(driver!=null){
            driverOutPutDTO.setStatus(CabBookingConstants.SUCCESS_MESSAGE);
            driverOutPutDTO.setMessage(CabBookingConstants.DRIVER_ADDED);
        }
        return driverOutPutDTO;
    }
    public DriverOutPutDTO updateResponseUpdate(Driver driver){
        DriverOutPutDTO driverOutPutDTO=new DriverOutPutDTO();
        if(driver!=null){
            driverOutPutDTO.setStatus(CabBookingConstants.SUCCESS_MESSAGE);
            driverOutPutDTO.setMessage(CabBookingConstants.DRIVER_UPDATED);
        }
        return driverOutPutDTO;
    }
    public DriverOutPutDTO updateResponseDelete(Driver driver){
        DriverOutPutDTO driverOutPutDTO=new DriverOutPutDTO();
        if(driver!=null){
            driverOutPutDTO.setStatus(CabBookingConstants.SUCCESS_MESSAGE);
            driverOutPutDTO.setMessage(CabBookingConstants.DRIVER_DELETED);
        }
        return driverOutPutDTO;
    }

}
