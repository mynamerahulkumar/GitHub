package com.eats.restaurant.validator;

import com.eats.restaurant.constants.GeoLocationConst;

public class MenuInputValidator {
    public void menuValidation(float latitude ,float longitude){
        if(latitude< GeoLocationConst.LATITUDEMIN || latitude>GeoLocationConst.LATITUDEMAX){

        }
        else if(longitude<GeoLocationConst.LONGITUDEMIN || longitude>GeoLocationConst.LATITUDEMAX){

        }
    }
}
