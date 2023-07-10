package com.eats.restaurant.controller;

import com.eats.restaurant.dto.Menus;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/uber-eats")
public class RestaurantController {
     @GetMapping("/menu/v1")
   public ResponseEntity<Menus> getRestaurantMenu(){

        return null;
    }



}
