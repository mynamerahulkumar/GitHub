package com.restaurant.restaurantmenu.services;

import com.restaurant.restaurantmenu.dtos.FoodDTO;
import com.restaurant.restaurantmenu.dtos.MenuDTO;
import com.restaurant.restaurantmenu.utils.ItemMockData;
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
    @Override
    public MenuDTO getOneMenu(int id){
        List<MenuDTO> menuDTOList= ItemMockData.getAllItemMenu1();
        if(menuDTOList!=null){
            int size=menuDTOList.size();
            if(id<size){
                return menuDTOList.get(id);
            }
        }
        return null;

    }
}
