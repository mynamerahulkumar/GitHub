package com.in28Minutes.unitTesting.unitTesting.springMockito.controller;

import com.in28Minutes.unitTesting.unitTesting.springMockito.DbHandling.ItemRepository;
import com.in28Minutes.unitTesting.unitTesting.springMockito.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {
    @Autowired
    ItemRepository itemRepository;
    public Item getRetrieveData(){
        return new Item(1,"def",3,4);
    }
    public List<Item> retrieveAllItemsFromDb(){
        return itemRepository.findAll();
    }


}
