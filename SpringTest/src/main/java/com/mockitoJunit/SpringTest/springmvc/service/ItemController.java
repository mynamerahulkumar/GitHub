package com.mockitoJunit.SpringTest.springmvc.service;

import com.mockitoJunit.SpringTest.springmvc.model.Item;
import com.mockitoJunit.SpringTest.springmvc.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemBusinessService businessService;


    @GetMapping("/dummy-item")
    public Item getDummy(){
        return  new Item(1,22,"mango");
    }

    @GetMapping("/business-item")
    public Item getItemBusinessData(){
        return  businessService.retrieveItemDate();
    }

    @GetMapping("/item-data")
    public List<Item> getAllItems(){
        return businessService.retriveAllItem();
    }

    @PostMapping("/save-item")
    public Item newItemSave(@RequestBody Item item){
        return businessService.saveItem(item);
    }

}
