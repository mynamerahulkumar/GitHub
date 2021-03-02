package com.in28Minutes.unitTesting.unitTesting.SpringTestMockito;

import com.in28Minutes.unitTesting.unitTesting.springMockito.DbHandling.ItemRepository;
import com.in28Minutes.unitTesting.unitTesting.springMockito.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest // it will load the data from in-memory database
public class ItemRepositoryTest {
    @Autowired // it will instantiate repository with constructor
    ItemRepository repository;
//    @MockBean 
//    ItemRepository itemRepository;// to mock out itemrepository -suppose you don't use application db and only one use in memory db
    @Test
    public void testFindAll(){
        List<Item> items=repository.findAll();// get all the data from inmemory database
        assertEquals(4,items.size());
    }
}
