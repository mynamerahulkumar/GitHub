package com.udacity.DogRestApi.DataMultitierArch.entityInheritance.DataTransferObject_DTO.Service;

import com.udacity.DogRestApi.DataMultitierArch.entityInheritance.Delivery;
import com.udacity.DogRestApi.DataMultitierArch.entityInheritance.JPA.repository.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliverService {
    @Autowired
    DeliverRepository deliverRepository;

    public  Long save(Delivery delivery){
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliverRepository.persist(delivery);
        return delivery.getId();
    }
}
