package com.udacity.DogRestApi.DataMultitierArch.entityInheritance.DataTransferObject_DTO.Controller;

import com.udacity.DogRestApi.DataMultitierArch.entityInheritance.DataTransferObject_DTO.Service.DeliverService;
import com.udacity.DogRestApi.DataMultitierArch.entityInheritance.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliverController {

    @Autowired
    DeliverService deliverService;

    @PostMapping
    public Long scheduledDelivery(@RequestBody Delivery delivery){
        return deliverService.save(delivery);
    }

}
