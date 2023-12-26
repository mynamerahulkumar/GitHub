package com.cab.cabbooking.processor;

import com.cab.cabbooking.constants.CabBookingConstants;
import com.cab.cabbooking.entity.Cab;
import com.cab.cabbooking.entity.CurrentUserSession;
import com.cab.cabbooking.exception.CabException;
import com.cab.cabbooking.mapper.CabMapper;
import com.cab.cabbooking.repository.CabRepo;
import com.cab.cabbooking.repository.CurrentUserSessionRepo;
import com.cab.cabbooking.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class CabProcessor {


    @Autowired
    private CabRepo cabRepo;

    @Autowired
    private CurrentUserSessionRepo currRepo;

    @Autowired
    private CabMapper cabMapper;

    public Cab insertCabProcess(Cab cab) throws CabException {
        Cab findCab=cabRepo.findByCarNumber(cab.getCarNumber());
        if(findCab==null ){
            return cabRepo.save(cab);
        }
        else{
            throw  new CabException.Builder()
                    .status(CabBookingConstants.BAD_REQUEST)
                    .errorCode(CabBookingConstants.CAB_REGISTERED_CODE)
                    .errorMessage(CabBookingConstants.CAB_REGISTERED).build();
        }
    }


    public Cab updateCabProcess(Cab cab, String uuid) throws CabException {
        List<CurrentUserSession> validUser=currRepo.findByUuidAndRole(uuid);
        if(validUser!=null){
            Cab cbbyCarNum=cabRepo.findByCarNumber(cab.getCarNumber());
            if(cbbyCarNum!=null){
                Cab data=cabMapper.updateCabMapper(cab,cbbyCarNum);
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

    public Cab deleteCabProcess(Integer cabId, String uuid) {
        List<CurrentUserSession> validUser=currRepo.findByUuidAndRole(uuid);
        if(validUser!=null){
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
