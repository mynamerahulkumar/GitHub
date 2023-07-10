package com.eats.restaurant.services;

import com.eats.restaurant.dto.Menus;

public interface MenuService {

    public Menus getMenus(float latitude, float longitude);
}
