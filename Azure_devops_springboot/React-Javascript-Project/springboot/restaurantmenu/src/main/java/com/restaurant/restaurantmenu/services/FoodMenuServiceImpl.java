package com.restaurant.restaurantmenu.services;

import com.restaurant.restaurantmenu.dtos.FoodDTO;
import com.restaurant.restaurantmenu.dtos.MenuDTO;
import com.restaurant.restaurantmenu.dtos.RestAllCategoryDTO;
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
    public RestAllCategoryDTO getOneMenuList(int id){
        List<RestAllCategoryDTO> restAllCategoryDTOList= ItemMockData.getAllItemMenu();
        if(restAllCategoryDTOList!=null){
            int size=restAllCategoryDTOList.size();
            if(id<size){
                return restAllCategoryDTOList.get(id);
            }
        }
        return null;

    }
}
