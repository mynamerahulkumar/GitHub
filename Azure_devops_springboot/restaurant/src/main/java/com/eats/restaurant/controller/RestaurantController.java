package com.eats.restaurant.controller;

import com.eats.restaurant.dto.Menu;
import com.eats.restaurant.dto.Menus;
import com.eats.restaurant.processor.MenuProcessor;
import com.nimbusds.jose.shaded.gson.JsonObject;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/uber-eats")
public class RestaurantController {
    @Autowired
    private MenuProcessor menuProcessor;
    /**
     * Get the Restaurant menu
     * @return
     */

    @GetMapping(value = "/menudetails",produces = {"application/json"})
    public ResponseEntity<String> getAdmin(Principal principal, @RequestHeader(required = false) String  latitude , @RequestHeader(required = false) String longitude) {
        JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
        String userName = (String) token.getTokenAttributes().get("name");
        String userEmail = (String) token.getTokenAttributes().get("email");
        Menus menus=menuProcessor.processMenus(latitude,longitude,userName,userEmail);
        return ResponseEntity.ok(menus.toString());
    }




}
