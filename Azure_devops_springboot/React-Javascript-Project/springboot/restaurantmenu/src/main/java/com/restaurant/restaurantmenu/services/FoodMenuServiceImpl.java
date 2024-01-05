package com.restaurant.restaurantmenu.services;

import com.restaurant.restaurantmenu.dtos.FoodDTO;
import com.restaurant.restaurantmenu.utils.MockMenuData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodMenuServiceImpl implements FoodMenuService {
    @Override
    public List<FoodDTO> getMenus() {
        List<FoodDTO> allMenus= MockMenuData.getMenuMockData();
        System.out.println("Show all menus");
        return allMenus;
    }
}
