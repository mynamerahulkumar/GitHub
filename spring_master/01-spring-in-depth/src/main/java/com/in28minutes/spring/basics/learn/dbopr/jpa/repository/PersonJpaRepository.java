package com.in28minutes.spring.basics.learn.dbopr.jpa.repository;

import com.in28minutes.spring.basics.learn.dbopr.jdbc.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id){
        return entityManager.find(Person.class,id);
    }
    public Person update(Person person){
        return entityManager.merge(person); // if id present update otherwise insert
    }
    public Person insert(Person person){
        return entityManager.merge(person);
    }

    public void deleteById(int id){
        Person person=findById(id);
        entityManager.remove(person);
    }
    public List<Person> findAll(){
        TypedQuery<Person> typedQuery=entityManager.createNamedQuery("find_all_person",Person.class);
        return typedQuery.getResultList();
    }
}
