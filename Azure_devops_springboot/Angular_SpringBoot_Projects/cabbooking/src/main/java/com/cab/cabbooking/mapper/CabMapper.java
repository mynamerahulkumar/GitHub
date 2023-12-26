package com.cab.cabbooking.mapper;

import com.cab.cabbooking.constants.CabBookingConstants;
import com.cab.cabbooking.dtos.CabOutPutDTO;
import com.cab.cabbooking.entity.Cab;
import com.cab.cabbooking.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CabMapper {
    public Cab updateCabMapper(Cab cab,Cab cabByCarNum){
        Cab data=cabByCarNum;
        data.setCarName(cab.getCarName());
        data.setCarType(cab.getCarType());
        data.setPerKmRate(cab.getPerKmRate());
        return data;
    }
    public CabOutPutDTO updateResponseInsert(Cab cab){
        CabOutPutDTO cabOutPutDTO=new CabOutPutDTO();
        if(cab!=null){
            cabOutPutDTO.setStatus(CabBookingConstants.SUCCESS_MESSAGE);
            cabOutPutDTO.setMessage(CabBookingConstants.CAB_ADDED);
        }
        return cabOutPutDTO;
    }
    public CabOutPutDTO updateResponseUpdate(Cab cab){
        CabOutPutDTO cabOutPutDTO=new CabOutPutDTO();
        if(cab!=null){
            cabOutPutDTO.setStatus(CabBookingConstants.SUCCESS_MESSAGE);
            cabOutPutDTO.setMessage(CabBookingConstants.CAB_UPDATED);
        }
        return cabOutPutDTO;
    }
    public CabOutPutDTO updateResponseDelete(Cab cab){
        CabOutPutDTO cabOutPutDTO=new CabOutPutDTO();
        if(cab!=null){
            cabOutPutDTO.setStatus(CabBookingConstants.SUCCESS_MESSAGE);
            cabOutPutDTO.setMessage(CabBookingConstants.CAB_DELETED);
        }
        return cabOutPutDTO;
    }
}
