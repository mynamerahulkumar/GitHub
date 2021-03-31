package com.udacity.jpa.controller;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jpa.entity.inheritance.Plant;
import com.udacity.jpa.model.PlantDTo;
import com.udacity.jpa.model.Views;
import com.udacity.jpa.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.View;

@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    PlantService plantService;

    public PlantDTo getPlantDto(String name){
        Plant plant=plantService.getPlantByName(name);
        return convertPlantToPLantDTO(plant);
    }
    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(String name){
        return plantService.getPlantByName(name);
    }
    private PlantDTo convertPlantToPLantDTO(Plant plant){
        PlantDTo plantDTo=new PlantDTo();
        BeanUtils.copyProperties(plant,plantDTo);
        return plantDTo;
    }
}
