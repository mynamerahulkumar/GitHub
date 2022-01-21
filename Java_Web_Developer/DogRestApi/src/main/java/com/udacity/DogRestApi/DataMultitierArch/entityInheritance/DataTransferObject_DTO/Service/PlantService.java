package com.udacity.DogRestApi.DataMultitierArch.entityInheritance.DataTransferObject_DTO.Service;

import com.udacity.DogRestApi.DataMultitierArch.entityInheritance.JPA.repository.PlantRepository;
import com.udacity.DogRestApi.DataMultitierArch.entityInheritance.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {
    @Autowired
    PlantRepository plantRepository;

    public  Long save(Plant plant){
        return plantRepository.save(plant).getId();
    }
    public Boolean delivered(Long id){
        return  plantRepository.existPlantByIdAndDeliveryCompleted(id,true);
    }
    public List<Plant> findPlantBelowPrice(BigDecimal price){
        return plantRepository.findPriceLessThan(price);
    }
    public Plant getPlantByName(String name){
        return new Plant();
    }



}
