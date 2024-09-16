package com.in28minutes.spring.basics.learn.dbopr.jpa.repository;

import com.in28minutes.spring.basics.learn.dbopr.jdbc.entity.Person;
import com.in28minutes.spring.basics.learn.dbopr.jpa.entity.People;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PeopleRepository {

    @PersistenceContext
    EntityManager entityManager;
    public Person findById(int id){
        return entityManager.find(Person.class,id);
    }


}
