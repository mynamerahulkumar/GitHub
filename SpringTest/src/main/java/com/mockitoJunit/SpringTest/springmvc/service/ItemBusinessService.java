package com.mockitoJunit.SpringTest.springmvc.service;

import com.mockitoJunit.SpringTest.springmvc.model.Item;
import com.mockitoJunit.SpringTest.springmvc.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {
    @Autowired
    ItemRepository itemRepository;

    public List<Item> retriveAllItem(){
        List<Item>items=itemRepository.findAll();
        for(Item item:items){
            int v=item.getPrice();
            v=v*2;// assuming 2 quantity
            item.setValue(v);
        }
        return itemRepository.findAll();
    }
    public Item saveItem(Item item){
        return  itemRepository.save(item);
    }

    public Item retrieveItemDate(){
       return new Item(1,22,"mango");
    }
}
