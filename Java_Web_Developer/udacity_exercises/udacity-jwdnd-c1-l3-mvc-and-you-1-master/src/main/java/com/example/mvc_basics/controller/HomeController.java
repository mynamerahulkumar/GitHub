package com.example.mvc_basics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage(Model model) {
      //  model.addAttribute("greetings", new String[]{"Hi","How "," are","you"});
        model.addAttribute("landingPage",true);
        return "home";
    }
    @PostMapping("/simplehome")
    public String submit(Model model){
        model.addAttribute("landingPage",false);
        return "home";
    }


}
