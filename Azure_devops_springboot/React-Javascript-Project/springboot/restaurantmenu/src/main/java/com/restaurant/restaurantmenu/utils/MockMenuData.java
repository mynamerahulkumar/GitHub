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

        FoodDTO foodDTO2=new FoodDTO();
        foodDTO2.setName("Kachodi");
        foodDTO2.setId(2);
        foodDTO2.setCuisines(cusines);
        foodDTO2.setAvgRating(3.9f);
        foodDTO2.setDeliveryTime(30);
        foodDTO2.setImageId("f3.jpg");
        foodDTO2.setCostForTwo(40000);

        FoodDTO foodDTO4=new FoodDTO();
        foodDTO4.setName("Idli");
        foodDTO4.setId(3);
        foodDTO4.setCuisines(cusines);
        foodDTO4.setAvgRating(3.9f);
        foodDTO4.setDeliveryTime(30);
        foodDTO4.setImageId("f4.webp");
        foodDTO4.setCostForTwo(40000);

        FoodDTO foodDTO5=new FoodDTO();
        foodDTO5.setName("Biryani Thali");
        foodDTO5.setId(4);
        foodDTO5.setCuisines(cusines);
        foodDTO5.setAvgRating(3.9f);
        foodDTO5.setDeliveryTime(30);
        foodDTO5.setImageId("f5.jpg");
        foodDTO5.setCostForTwo(40000);

        FoodDTO foodDTO6=new FoodDTO();
        foodDTO6.setName("Curd Chart");
        foodDTO6.setId(5);
        foodDTO6.setCuisines(cusines);
        foodDTO6.setAvgRating(3.9f);
        foodDTO6.setDeliveryTime(30);
        foodDTO6.setImageId("f6.jpg");
        foodDTO6.setCostForTwo(40000);

        FoodDTO foodDTO7=new FoodDTO();
        foodDTO7.setName("North Indian Roti Thali");
        foodDTO7.setId(6);
        foodDTO7.setCuisines(cusines);
        foodDTO7.setAvgRating(3.9f);
        foodDTO7.setDeliveryTime(30);
        foodDTO7.setImageId("f7.jpg");
        foodDTO7.setCostForTwo(40000);

        FoodDTO foodDTO8=new FoodDTO();
        foodDTO8.setName("North Indian Thali");
        foodDTO8.setId(7);
        foodDTO8.setCuisines(cusines);
        foodDTO8.setAvgRating(3.9f);
        foodDTO8.setDeliveryTime(30);
        foodDTO8.setImageId("f8.jpg");
        foodDTO8.setCostForTwo(40000);

        FoodDTO foodDTO9=new FoodDTO();
        foodDTO9.setName("South Indian Big Thali");
        foodDTO9.setId(8);
        foodDTO9.setCuisines(cusines);
        foodDTO9.setAvgRating(3.9f);
        foodDTO9.setDeliveryTime(30);
        foodDTO9.setImageId("f9.jpg");
        foodDTO9.setCostForTwo(40000);

        FoodDTO foodDT10=new FoodDTO();
        foodDT10.setName("Jalebi");
        foodDT10.setId(9);
        foodDT10.setCuisines(cusines);
        foodDT10.setAvgRating(3.9f);
        foodDT10.setDeliveryTime(30);
        foodDT10.setImageId("f10.jpg");
        foodDT10.setCostForTwo(40000);

        FoodDTO foodDT11=new FoodDTO();
        foodDT11.setName("North Indian Medium Thali");
        foodDT11.setId(10);
        foodDT11.setCuisines(cusines);
        foodDT11.setAvgRating(3.9f);
        foodDT11.setDeliveryTime(30);
        foodDT11.setImageId("f11.jpg");
        foodDT11.setCostForTwo(40000);

        FoodDTO foodDTO12=new FoodDTO();
        foodDTO12.setName("Rasgulla");
        foodDTO12.setId(11);
        foodDTO12.setCuisines(cusines);
        foodDTO12.setAvgRating(3.9f);
        foodDTO12.setDeliveryTime(30);
        foodDTO12.setImageId("f12.jpg");
        foodDTO12.setCostForTwo(40000);

        FoodDTO foodDT13=new FoodDTO();
        foodDT13.setName("Rice Roti Curry");
        foodDT13.setId(12);
        foodDT13.setCuisines(cusines);
        foodDT13.setAvgRating(3.9f);
        foodDT13.setDeliveryTime(30);
        foodDT13.setImageId("f13.webp");
        foodDT13.setCostForTwo(40000);

        FoodDTO foodDT14=new FoodDTO();
        foodDT14.setName("South Indian Thali");
        foodDT14.setId(13);
        foodDT14.setCuisines(cusines);
        foodDT14.setAvgRating(3.9f);
        foodDT14.setDeliveryTime(30);
        foodDT14.setImageId("f2.jpg");
        foodDT14.setCostForTwo(40000);

        FoodDTO foodDT15=new FoodDTO();
        foodDT15.setName("South Indian Thali");
        foodDT15.setId(14);
        foodDT15.setCuisines(cusines);
        foodDT15.setAvgRating(3.9f);
        foodDT15.setDeliveryTime(30);
        foodDT15.setImageId("f3.jpg");
        foodDT15.setCostForTwo(40000);





        foodDTOList.add(foodDTO);
        foodDTOList.add(foodDTO1);
        foodDTOList.add(foodDTO2);
        foodDTOList.add(foodDTO4);
        foodDTOList.add(foodDTO5);
        foodDTOList.add(foodDTO6);
        foodDTOList.add(foodDTO7);
        foodDTOList.add(foodDTO8);
        foodDTOList.add(foodDTO9);
        foodDTOList.add(foodDT10);
        foodDTOList.add(foodDT11);
        foodDTOList.add(foodDTO12);
        foodDTOList.add(foodDT13);
        foodDTOList.add(foodDT14);
        foodDTOList.add(foodDT15);
        return foodDTOList;

    }


}
