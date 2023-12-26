package com.cab.cabbooking.services;

import com.cab.cabbooking.dtos.CabOutPutDTO;
import com.cab.cabbooking.entity.Cab;

public interface CabService {
    CabOutPutDTO insertCab(Cab cab);

    CabOutPutDTO updateCab(Cab cab,String uuid);

    CabOutPutDTO deleteCab(Integer cabId,String uuid);
}
