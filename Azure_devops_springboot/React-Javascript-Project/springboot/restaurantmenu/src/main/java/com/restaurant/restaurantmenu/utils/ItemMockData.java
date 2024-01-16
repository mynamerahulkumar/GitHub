package com.restaurant.restaurantmenu.utils;

import com.restaurant.restaurantmenu.dtos.ItemDTO;
import com.restaurant.restaurantmenu.dtos.MenuDTO;

import java.util.ArrayList;
import java.util.List;

public class ItemMockData {

    public static List<MenuDTO> getAllItemMenu1(){
        List<MenuDTO> menuDTOList=new ArrayList<>();
        MenuDTO menuDTO=new MenuDTO();
          String name="North India Thali";
        List<String> cuisines=new ArrayList<>();
        cuisines.add("North Indian");
        cuisines.add("Biryani");
        cuisines.add("Paratha");
         String costFortTwoMessage="400 for Two";
        List<ItemDTO> items=new ArrayList<>();
        ItemDTO itemDTO=new ItemDTO();
        itemDTO.setName("Biryani");
        itemDTO.setPrice(230f);

        ItemDTO itemDTO1=new ItemDTO();
        itemDTO1.setName("Burgers");
        itemDTO1.setPrice(450f);

        ItemDTO itemDTO2=new ItemDTO();
        itemDTO2.setName("Paratha");
        itemDTO2.setPrice(235f);
        items.add(itemDTO1);
        items.add(itemDTO);
        items.add(itemDTO2);


        menuDTO.setItemDTO(items);
        menuDTO.setCuisines(cuisines);
        menuDTO.setName(name);
        menuDTO.setCostFortTwoMessage(costFortTwoMessage);

        MenuDTO menuDTO1=new MenuDTO();
        String name1="South India Thali";
        List<String> cuisines1=new ArrayList<>();
        cuisines1.add("South Indian");
        cuisines1.add("Biryani");
        cuisines1.add("Idli Vada");
        String costFortTwoMessage1="400 for Two";
        List<ItemDTO> items1=new ArrayList<>();
        ItemDTO itemDTO3=new ItemDTO();
        itemDTO3.setName("Biryani");
        itemDTO3.setPrice(230f);

        ItemDTO itemDTO4=new ItemDTO();
        itemDTO4.setName("Idli Vada");
        itemDTO4.setPrice(450f);

        ItemDTO itemDTO5=new ItemDTO();
        itemDTO5.setName("Dosa");
        itemDTO5.setPrice(235f);
        items1.add(itemDTO3);
        items1.add(itemDTO4);
        items1.add(itemDTO5);


        menuDTO1.setItemDTO(items1);
        menuDTO1.setCuisines(cuisines1);
        menuDTO1.setName(name1);
        menuDTO1.setCostFortTwoMessage(costFortTwoMessage1);

        menuDTOList.add(menuDTO);
        menuDTOList.add(menuDTO1);
        return  menuDTOList;

    }
}
