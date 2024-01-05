package com.restaurant.restaurantmenu.services;

import com.restaurant.restaurantmenu.dtos.FoodDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface FoodMenuService {

    public List<FoodDTO> getMenus();
}
