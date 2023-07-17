package com.eats.restaurant.processor;

import com.eats.restaurant.dto.Menus;
import com.eats.restaurant.services.MenuServiceImplementation;
import com.eats.restaurant.validator.MenuInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuProcessor {
    @Autowired
    private MenuServiceImplementation menuServiceImplementation;
    @Autowired
    private MenuInputValidator menuInputValidator;

    public Menus processMenus(String latitude, String longitude,String userName,String email){
        menuInputValidator.menuValidation(latitude,longitude);
        Menus menus=menuServiceImplementation.getMenus(latitude,longitude);
        return menus;
    }
}
