package com.cab.cabbooking.services;

import com.cab.cabbooking.constants.CabBookingConstants;
import com.cab.cabbooking.dtos.CabOutPutDTO;
import com.cab.cabbooking.dtos.CustomerOutPutDTO;
import com.cab.cabbooking.entity.Cab;
import com.cab.cabbooking.entity.CurrentUserSession;
import com.cab.cabbooking.entity.Customer;
import com.cab.cabbooking.exception.CabException;
import com.cab.cabbooking.mapper.CabMapper;
import com.cab.cabbooking.mapper.CustomerMapper;
import com.cab.cabbooking.processor.CabProcessor;
import com.cab.cabbooking.processor.CustomerProcessor;
import com.cab.cabbooking.repository.CabRepo;
import com.cab.cabbooking.repository.CurrentUserSessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabServiceImpl implements CabService {


    @Autowired
    private CabProcessor cabProcessor;

    @Autowired
    private CabMapper cabMapper;

    public CabOutPutDTO insertCab(Cab cab) {
        int num=2/0;
        Cab resCab = cabProcessor.insertCabProcess(cab);
        CabOutPutDTO cabOutPutDTO = cabMapper.updateResponseInsert(resCab);
        return cabOutPutDTO;

    }

    @Override
    public CabOutPutDTO updateCab(Cab cab, String uuid) {
        Cab resCab = cabProcessor.updateCabProcess(cab,uuid);
        CabOutPutDTO cabOutPutDTO = cabMapper.updateResponseUpdate(resCab);
        return cabOutPutDTO;


    }

    @Override
    public CabOutPutDTO deleteCab(Integer cabId,String uuid) {
        Cab resCab = cabProcessor.deleteCabProcess(cabId,uuid);
        CabOutPutDTO cabOutPutDTO = cabMapper.updateResponseDelete(resCab);
        return cabOutPutDTO;
    }

}
