package com.eats.restaurant.controller;

import com.eats.restaurant.dto.Menus;
import com.eats.restaurant.processor.MenuProcessor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/uber-eats")
public class RestaurantController {
    @Autowired
    private MenuProcessor menuProcessor;
    /**
     * Get the Restaurant menu
     * @return
     */
     @GetMapping("/menu/v1")
   public ResponseEntity<Menus> getRestaurantMenu(Principal principal){

        return null;
    }
    @GetMapping("/")
    public String getTestMethod(Principal principal){

        return "User-"+principal.getName();
    }

    public String customers(Principal principal, Model model){
         model.addAttribute("username",principal.getName());
         return "customers";
    }



}
