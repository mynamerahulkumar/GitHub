package com.restaurant.restaurantmenu.utils;

import com.restaurant.restaurantmenu.dtos.FoodDTO;

import java.util.ArrayList;
import java.util.List;

public class MockMenuData {

    public static List<FoodDTO> getMenuMockData(){
        List<FoodDTO> foodDTOList=new ArrayList<>();
        List<String> cusines=new ArrayList<>();
        cusines.add("Burgers");
        cusines.add("Biryani");
        cusines.add("Snacks");
        cusines.add("Fast Food");
        FoodDTO foodDTO=new FoodDTO();
        foodDTO.setName("Biryani");
        foodDTO.setId(0);
        foodDTO.setCuisines(cusines);
        foodDTO.setAvgRating(4.6f);
        foodDTO.setDeliveryTime(30);
        foodDTO.setImageId("f1.jpg");
        foodDTO.setCostForTwo(50000);

        FoodDTO foodDTO1=new FoodDTO();
        foodDTO1.setName("South Indian Thali");
        foodDTO1.setId(1);
        foodDTO1.setCuisines(cusines);
        foodDTO1.setAvgRating(3.9f);
        foodDTO1.setDeliveryTime(30);
        foodDTO1.setImageId("f2.jpg");
        foodDTO1.setCostForTwo(40000);

        foodDTOList.add(foodDTO);
        foodDTOList.add(foodDTO1);
        return foodDTOList;

    }


}
