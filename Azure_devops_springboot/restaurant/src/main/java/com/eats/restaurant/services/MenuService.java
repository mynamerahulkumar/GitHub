package com.eats.restaurant.services;

import com.eats.restaurant.dto.Menus;

public interface MenuService {

    public Menus getMenus(String latitude, String longitude);
}
