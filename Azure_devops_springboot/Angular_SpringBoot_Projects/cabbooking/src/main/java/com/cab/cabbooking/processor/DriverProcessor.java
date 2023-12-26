package com.cab.cabbooking.processor;

import com.cab.cabbooking.constants.CabBookingConstants;
import com.cab.cabbooking.entity.CurrentUserSession;
import com.cab.cabbooking.entity.Driver;
import com.cab.cabbooking.exception.CabException;
import com.cab.cabbooking.mapper.DriverMapper;
import com.cab.cabbooking.repository.CurrentUserSessionRepo;
import com.cab.cabbooking.repository.CustomerRepo;
import com.cab.cabbooking.repository.DriverRepo;
import com.cab.cabbooking.repository.TripBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DriverProcessor {

    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private TripBookingRepo tripBookingRepo;
    @Autowired
    private CurrentUserSessionRepo currentUserSessionRepo;

    @Autowired
    private DriverMapper driverMapper;



    public Driver insertDriverProcess(Driver driver) throws CabException {

       Driver findDriver = driverRepo.findByLicenseNo(driver.getLicenseNo());
        if(findDriver!=null) {
            throw  new CabException.Builder()
                    .status(CabBookingConstants.BAD_REQUEST)
                    .errorCode(CabBookingConstants.DRIVER_REGISTERED_CODE)
                    .errorMessage(CabBookingConstants.DRIVER_REGISTERED).build();
        }
        else {
            if(driver.getUserRole().equalsIgnoreCase("Driver")) {
                return driverRepo.save(driver);
            }
            else {
                throw  new CabException.Builder()
                        .status(CabBookingConstants.BAD_REQUEST)
                        .errorCode(CabBookingConstants.USER_NOT_DRIVER_CODE)
                        .errorMessage(CabBookingConstants.USER_NOT_DRIVER).build();
            }
        }
    }


    public Driver updateDriverProcess(Driver driver, String uuid) throws CabException {

        List<CurrentUserSession> validCustomer = currentUserSessionRepo.findByuuid(uuid);
        if(validCustomer!=null) {
            Driver drvDetailsByEmaildId = driverRepo.findByEmail(driver.getEmail());
            if(drvDetailsByEmaildId!=null) {
                Driver updatingdriver = driverMapper.mapDriverUpdate(driver,drvDetailsByEmaildId);

                return driverRepo.save(updatingdriver);
            }
            else {
                throw  new CabException.Builder()
                        .status(CabBookingConstants.BAD_REQUEST)
                        .errorCode(CabBookingConstants.DRIVER_NOT_FOUND_CREDENTIAL_CODE)
                        .errorMessage(CabBookingConstants.DRIVER_NOT_FOUND_CREDENTIAL).build();
            }
        }
        else {
            throw  new CabException.Builder()
                    .status(CabBookingConstants.BAD_REQUEST)
                    .errorCode(CabBookingConstants.USER_NOT_LOGIN_CODE)
                    .errorMessage(CabBookingConstants.USER_NOT_LOGIN).build();
        }
    }

    public Driver deleteDriverProcess(Integer driverId, String uuid) throws CabException {

        List<CurrentUserSession> validCustomer = currentUserSessionRepo.findByuuid(uuid);
        if(validCustomer!=null) {
            Optional<Driver> drv = driverRepo.findById(driverId);
            if(drv.isPresent()) {
                Driver updatingdriver = drv.get();
                driverRepo.delete(updatingdriver);
                return updatingdriver;
            }
            else {
                throw  new CabException.Builder()
                        .status(CabBookingConstants.BAD_REQUEST)
                        .errorCode(CabBookingConstants.DRIVER_NOT_FOUND_CREDENTIAL_CODE)
                        .errorMessage(CabBookingConstants.DRIVER_NOT_FOUND_CREDENTIAL).build();
            }
        }
        else {
            throw  new CabException.Builder()
                    .status(CabBookingConstants.BAD_REQUEST)
                    .errorCode(CabBookingConstants.USER_NOT_LOGIN_CODE)
                    .errorMessage(CabBookingConstants.USER_NOT_LOGIN).build();
        }
    }

}
