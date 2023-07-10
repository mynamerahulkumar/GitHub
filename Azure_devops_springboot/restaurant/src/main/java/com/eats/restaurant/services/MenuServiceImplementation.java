package com.eats.restaurant.services;

import com.eats.restaurant.dto.Menus;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImplementation  implements MenuService{
    /**
     * Menu details
     * @param latitude
     * @param longitude
     * @return
     */
    @Override
    public Menus getMenus(float latitude, float longitude) {
        return null;
    }
}
