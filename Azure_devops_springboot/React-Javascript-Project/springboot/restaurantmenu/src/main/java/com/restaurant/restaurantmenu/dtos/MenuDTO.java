package com.restaurant.restaurantmenu.dtos;

import lombok.Data;

import java.util.List;

@Data
public class MenuDTO {
    public  String name;
    public List<String> cuisines;
    public String costFortTwoMessage;
    public List<ItemDTO> itemDTO;
}
