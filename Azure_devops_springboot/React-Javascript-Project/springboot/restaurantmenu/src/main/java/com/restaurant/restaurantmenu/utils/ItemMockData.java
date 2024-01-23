package com.restaurant.restaurantmenu.utils;

import com.restaurant.restaurantmenu.dtos.ItemDTO;
import com.restaurant.restaurantmenu.dtos.MenuDTO;
import com.restaurant.restaurantmenu.dtos.RestAllCategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class ItemMockData {

    public static List<RestAllCategoryDTO> getAllItemMenu(){
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
        itemDTO.setCategory("Main_Course");

        ItemDTO itemDTO1=new ItemDTO();
        itemDTO1.setName("Burgers");
        itemDTO1.setPrice(450f);
        itemDTO1.setCategory("Dinner Course");

        ItemDTO itemDTO2=new ItemDTO();
        itemDTO2.setName("Paratha");
        itemDTO2.setPrice(235f);
        itemDTO2.setCategory("Main_Course");

        items.add(itemDTO1);
        items.add(itemDTO);
        items.add(itemDTO2);



        menuDTO.setItemDTO(items);
        menuDTO.setCuisines(cuisines);
        menuDTO.setName(name);
        menuDTO.setCostFortTwoMessage(costFortTwoMessage);
        menuDTO.setId(0);

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
        menuDTO1.setId(1);


        MenuDTO menuDTO3=new MenuDTO();
        String name3="Snacks";
        List<String> cuisines3=new ArrayList<>();
        cuisines3.add("North Indian");
        cuisines3.add("Pizza");
        cuisines3.add("Burgers");
        String costFortTwoMessage3="300 for Two";
        List<ItemDTO> items3=new ArrayList<>();
        ItemDTO itemDTO6=new ItemDTO();
        itemDTO6.setName("Veg Biryani");
        itemDTO6.setPrice(230f);
        itemDTO6.setCategory("Snacks");

        ItemDTO itemDTO7=new ItemDTO();
        itemDTO7.setName("Pizza");
        itemDTO7.setPrice(450f);
        itemDTO7.setCategory("Snacks");

        ItemDTO itemDTO8=new ItemDTO();
        itemDTO8.setName("Burgers");
        itemDTO8.setPrice(235f);
        itemDTO8.setCategory("Snacks");

        items3.add(itemDTO6);
        items3.add(itemDTO7);
        items3.add(itemDTO8);



        menuDTO3.setItemDTO(items3);
        menuDTO3.setCuisines(cuisines3);
        menuDTO3.setName(name3);
        menuDTO3.setCostFortTwoMessage(costFortTwoMessage3);
        menuDTO3.setId(2);


        menuDTOList.add(menuDTO);
        menuDTOList.add(menuDTO1);
        menuDTOList.add(menuDTO3);

        List<RestAllCategoryDTO> allCategoryDTOS=new ArrayList<>();
        RestAllCategoryDTO restAllCategoryDTO=new RestAllCategoryDTO();
        restAllCategoryDTO.setId(0);
        restAllCategoryDTO.setMenuDTOList(menuDTOList);
        restAllCategoryDTO.setName("South Indian Restauarant");
        restAllCategoryDTO.setCuisines(cuisines3);
        restAllCategoryDTO.setCostFortTwoMessage(costFortTwoMessage3);

        RestAllCategoryDTO restAllCategoryDTO1=new RestAllCategoryDTO();
        restAllCategoryDTO1.setId(1);
        restAllCategoryDTO1.setMenuDTOList(menuDTOList);
        restAllCategoryDTO1.setName("North Indian Restauarant");
        restAllCategoryDTO1.setCuisines(cuisines);
        restAllCategoryDTO1.setCostFortTwoMessage(costFortTwoMessage);

        allCategoryDTOS.add(restAllCategoryDTO1);
        allCategoryDTOS.add(restAllCategoryDTO);

        return  allCategoryDTOS;

    }
}
