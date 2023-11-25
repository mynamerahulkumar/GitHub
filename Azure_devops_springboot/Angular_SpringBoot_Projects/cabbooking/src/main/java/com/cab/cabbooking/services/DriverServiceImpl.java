package com.cab.cabbooking.services;

import com.cab.cabbooking.constants.CabBookingConstants;
import com.cab.cabbooking.dtos.Cab;
import com.cab.cabbooking.dtos.CurrentUserSession;
import com.cab.cabbooking.dtos.Driver;
import com.cab.cabbooking.exception.CabException;
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
    private DriverRepo driverRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private TripBookingRepo tripBookingRepo;
    @Autowired
    private CurrentUserSessionRepo currentUserSessionRepo;



    @Override
    public Driver insertDriver(Driver driver) throws CabException {

        Optional<Driver> findDriver = driverRepo.findByLicenseNo(driver.getLicenseNo());
        if(findDriver.isPresent()) {
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

    @Override
    public Driver updateDriver(Driver driver, String uuid) throws CabException {

        Optional<CurrentUserSession> validCustomer = currentUserSessionRepo.findByUUid(uuid);
        if(validCustomer.isPresent()) {
            Optional<Driver> drv = driverRepo.findByEmail(driver.getEmail());
            if(drv.isPresent()) {
                Driver updatingdriver = drv.get();
                updatingdriver.setAddress(driver.getAddress());
                updatingdriver.setEmail(driver.getEmail());
                updatingdriver.setMobileNumber(driver.getMobileNumber());
                updatingdriver.setPassword(driver.getPassword());
                updatingdriver.setUserName(driver.getUserName());
                updatingdriver.setLicenseNo(driver.getLicenseNo());
                updatingdriver.setCab(driver.getCab());

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

    @Override
    public Driver deleteDriver(Integer driverId, String uuid) throws CabException {

        Optional<CurrentUserSession> validCustomer = currentUserSessionRepo.findByUUid(uuid);
        if(validCustomer.isPresent()) {
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
