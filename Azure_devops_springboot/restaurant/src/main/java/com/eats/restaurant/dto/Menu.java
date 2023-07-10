package com.eats.restaurant.dto;

import lombok.Data;

@Data
public class Menu {

    private String menuId;
    private String menu_name;

    private String description;

    private String image;

    private int  serveCapacity;

    private float price;

}
