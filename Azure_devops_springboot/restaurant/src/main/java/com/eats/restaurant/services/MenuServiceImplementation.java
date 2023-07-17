package com.eats.restaurant.services;

import com.eats.restaurant.dto.Menu;
import com.eats.restaurant.dto.Menus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImplementation  implements MenuService{
    /** currently this is constant later we will change to db call
     * Menu details
     * @param latitude
     * @param longitude
     * @return
     */
    @Override
    public Menus getMenus(String  latitude, String longitude) {
        Menus menus=new Menus();
        List<Menu> menuList=new ArrayList<>();
        Menu menu=new Menu();
        menu.setDescription("Hot Burger");
        menu.setMenu_name("Burger");
        menu.setMenuId("234");
        menu.setPrice(34);
        menu.setServeCapacity(2);
        menuList.add(menu);
        menus.setMenus(menuList);
        return menus;
    }
}
