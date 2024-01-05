package com.restaurant.restaurantmenu.controller;

import com.restaurant.restaurantmenu.dtos.FoodDTO;
import com.restaurant.restaurantmenu.services.FoodMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class MenuController {

    @Autowired
    FoodMenuService foodMenuService;

    @GetMapping("/menu/v1")
    public ResponseEntity<?> getRestaurantMenu(){
        List<FoodDTO> foodMenuResponse=foodMenuService.getMenus();
        return  new ResponseEntity<>(foodMenuResponse, HttpStatus.OK);
    }


}
