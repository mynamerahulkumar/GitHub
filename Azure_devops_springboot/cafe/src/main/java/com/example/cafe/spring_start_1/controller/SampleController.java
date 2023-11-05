package com.example.cafe.spring_start_1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Value("spring.application.name")
    String applName;

    @GetMapping("/")
    public String getMethod(Model model){
        model.addAttribute("applName",applName);
        return "home";
    }
}
