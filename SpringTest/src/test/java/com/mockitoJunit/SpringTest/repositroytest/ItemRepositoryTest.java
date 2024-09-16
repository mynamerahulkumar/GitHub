package com.mockitoJunit.SpringTest.repositroytest;

import com.mockitoJunit.SpringTest.springmvc.model.Item;
import com.mockitoJunit.SpringTest.springmvc.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@DataJpaTest // automatically run in memory database
public class ItemRepositoryTest {
    @Autowired
    ItemRepository repository;

    @Test
    public void testRepositorySize(){
        List<Item> items=repository.findAll();
        assertEquals(4,items.size());
    }
}
