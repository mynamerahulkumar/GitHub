package com.restaurant.restaurantmenu.dtos;

import lombok.Data;

import java.util.List;

@Data
public class FoodDTO {

    public int id;

    public float avgRating;

    public String name;

    public float costForTwo;

    public float deliveryTime;

    public List<String> cuisines;

    public String imageId;

}
