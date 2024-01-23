package com.restaurant.restaurantmenu.dtos;

import lombok.Data;

import java.util.List;
@Data
public class RestAllCategoryDTO {
    int id;
    List<MenuDTO> menuDTOList;
    String name;
    public List<String> cuisines;
    public String costFortTwoMessage;

}
