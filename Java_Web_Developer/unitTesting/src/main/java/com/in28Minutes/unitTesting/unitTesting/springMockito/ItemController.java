package com.in28Minutes.unitTesting.unitTesting.springMockito;

import com.in28Minutes.unitTesting.unitTesting.springMockito.controller.ItemBusinessService;
import com.in28Minutes.unitTesting.unitTesting.springMockito.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemBusinessService businessService;
    @GetMapping("/dummy-item")
    public Item getItemController(){
        return new Item(1,"abc",3,4);
    }
    @GetMapping("/business-data")
    public  Item getBusinessService(){
        return businessService.getRetrieveData();
    }

    @GetMapping("/all-item-db")
    public List<Item> getAllItemsFromDatabase(){
        List<Item> items=businessService.retrieveAllItemsFromDb();
        for(Item item:items){
            item.setValue(item.getPrice()* item.getQuantity());
        }
        return items;
    }


}
