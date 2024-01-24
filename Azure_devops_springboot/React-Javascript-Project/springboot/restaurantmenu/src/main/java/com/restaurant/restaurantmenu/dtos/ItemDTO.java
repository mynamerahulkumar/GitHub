package com.restaurant.restaurantmenu.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ItemDTO {
    public String name;
    public float price;
    public int id;
    public String description;
}
