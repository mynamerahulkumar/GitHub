package com.mockitoJunit.SpringTest.repositroytest;

import com.mockitoJunit.SpringTest.springmvc.service.ItemBusinessService;
import com.mockitoJunit.SpringTest.springmvc.service.ItemController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class BusinessRespositoryTest {

    @Autowired
    ItemController itemController;
    @Autowired
    ItemBusinessService businessService;
    @Test
    public void retrieveAllItems(){

    }

}
