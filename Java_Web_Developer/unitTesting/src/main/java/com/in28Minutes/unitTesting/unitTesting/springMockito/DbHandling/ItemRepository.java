package com.in28Minutes.unitTesting.unitTesting.springMockito.DbHandling;

import com.in28Minutes.unitTesting.unitTesting.springMockito.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository  extends JpaRepository<Item,Integer> {
}
