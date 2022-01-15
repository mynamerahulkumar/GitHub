package com.udacity.eureka.repository;

import com.udacity.eureka.Animal.Entity.Dog;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog,Long> {

}
