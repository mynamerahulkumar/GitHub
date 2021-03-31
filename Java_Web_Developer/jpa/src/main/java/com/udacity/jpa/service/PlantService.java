package com.udacity.jpa.service;

import com.udacity.jpa.entity.inheritance.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
    public Plant getPlantByName(String name){
        Plant plant=new Plant();
        return plant;
    }
}
