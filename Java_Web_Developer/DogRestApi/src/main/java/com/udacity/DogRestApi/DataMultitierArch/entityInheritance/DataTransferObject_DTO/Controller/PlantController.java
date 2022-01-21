package com.udacity.DogRestApi.DataMultitierArch.entityInheritance.DataTransferObject_DTO.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.udacity.DogRestApi.DataMultitierArch.entityInheritance.DataTransferObject_DTO.PlantDTO;
import com.udacity.DogRestApi.DataMultitierArch.entityInheritance.DataTransferObject_DTO.Service.PlantService;
import com.udacity.DogRestApi.DataMultitierArch.entityInheritance.DataTransferObject_DTO.Views;
import com.udacity.DogRestApi.DataMultitierArch.entityInheritance.Plant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @GetMapping("/delivered/{id}")
    public Boolean delivered(@PathVariable Long id){
        return plantService.delivered(id);
    }

    @GetMapping("/under-price/{price}")
    @JsonView(Views.Public.class)
    public List<Plant> plantsCheaperThen(@PathVariable BigDecimal price){
        return plantService.findPlantBelowPrice(price);
    }


    public PlantDTO getPlantDTO(String name){
            return convertPlantToPlantDTO(plantService.getPlantByName(name));
    }

    @JsonView(Views.Public.class)
    public Plant getFileteredPlant(String name){
        return plantService.getPlantByName(name);
    }

    private PlantDTO convertPlantToPlantDTO(Plant plant){
        PlantDTO plantDTO=new PlantDTO();
        BeanUtils.copyProperties(plant,plantDTO);
        return plantDTO;
    }

}
