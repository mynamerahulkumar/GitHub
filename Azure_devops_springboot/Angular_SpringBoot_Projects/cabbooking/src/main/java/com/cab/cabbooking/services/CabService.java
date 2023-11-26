package com.cab.cabbooking.services;

import com.cab.cabbooking.entity.Cab;

public interface CabService {
    Cab insertCab(Cab cab);

    Cab updateCab(Cab cab,String uuid);

    Cab deleteCab(Integer cabId,String uuid);
}
