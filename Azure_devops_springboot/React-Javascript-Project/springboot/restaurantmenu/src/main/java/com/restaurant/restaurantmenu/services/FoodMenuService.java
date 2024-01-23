package com.restaurant.restaurantmenu.services;

import com.restaurant.restaurantmenu.dtos.FoodDTO;
import com.restaurant.restaurantmenu.dtos.MenuDTO;
import com.restaurant.restaurantmenu.dtos.RestAllCategoryDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface FoodMenuService {

    public List<FoodDTO> getMenus();
    public RestAllCategoryDTO getOneMenuList(int id);
}
