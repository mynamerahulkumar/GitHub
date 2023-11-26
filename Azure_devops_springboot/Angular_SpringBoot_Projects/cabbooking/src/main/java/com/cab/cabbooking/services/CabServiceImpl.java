package com.cab.cabbooking.services;

import com.cab.cabbooking.constants.CabBookingConstants;
import com.cab.cabbooking.entity.Cab;
import com.cab.cabbooking.entity.CurrentUserSession;
import com.cab.cabbooking.exception.CabException;
import com.cab.cabbooking.repository.CabRepo;
import com.cab.cabbooking.repository.CurrentUserSessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabServiceImpl implements CabService {


    @Autowired
    private CabRepo cabRepo;

    @Autowired
    private CurrentUserSessionRepo currRepo;
    @Override
    public Cab insertCab(Cab cab) throws CabException {
        Optional<Cab> findCab=cabRepo.findByCarNumber(cab.getCarNumber());
        if(findCab.isEmpty()){
            return cabRepo.save(cab);
        }
        else{
            throw  new CabException.Builder()
                    .status(CabBookingConstants.BAD_REQUEST)
                    .errorCode(CabBookingConstants.CAB_REGISTERED_CODE)
                    .errorMessage(CabBookingConstants.CAB_REGISTERED).build();
        }
    }

    @Override
    public Cab updateCab(Cab cab, String uuid) throws CabException {
        Optional<CurrentUserSession> validUser=currRepo.findByUuidAndRole(uuid);
        if(validUser.isPresent()){
            Optional<Cab> cb=cabRepo.findByCarNumber(cab.getCarNumber());
            if(cb.isPresent()){
                Cab data=cb.get();
                data.setCarName(cab.getCarName());
                data.setCarType(cab.getCarType());
                data.setPerKmRate(cab.getPerKmRate());
                return cabRepo.save(data);
            }
            else{
                throw  new CabException.Builder()
                        .status(CabBookingConstants.BAD_REQUEST)
                        .errorCode(CabBookingConstants.CAB_NOT_REGISTERED_CODE)
                        .errorMessage(CabBookingConstants.CAB_NOT_REGISTERED).build();
            }
        }
        else{

                throw  new CabException.Builder()
                        .status(CabBookingConstants.BAD_REQUEST)
                        .errorCode(CabBookingConstants.USER_NOT_LOGIN)
                        .errorMessage(CabBookingConstants.USER_NOT_LOGIN_CODE).build();

        }
    }

    @Override
    public Cab deleteCab(Integer cabId, String uuid) {
        Optional<CurrentUserSession> validUser=currRepo.findByUuidAndRole(uuid);
        if(validUser.isPresent()){
            Optional<Cab> cb=cabRepo.findById(cabId);
            if(cb.isPresent()){
                Cab cab=cb.get();
                cabRepo.delete(cab);
                return cab;
            }
            else{
                throw  new CabException.Builder()
                        .status(CabBookingConstants.BAD_REQUEST)
                        .errorCode(CabBookingConstants.CAB_NOT_REGISTERED_CODE)
                        .errorMessage(CabBookingConstants.CAB_NOT_REGISTERED).build();
            }
        }
        else{
            throw  new CabException.Builder()
                    .status(CabBookingConstants.BAD_REQUEST)
                    .errorCode(CabBookingConstants.USER_NOT_LOGIN)
                    .errorMessage(CabBookingConstants.USER_NOT_LOGIN_CODE).build();
        }
    }
}
