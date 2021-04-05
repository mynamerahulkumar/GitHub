package com.udacity.jpa.entity.jpa_ex_1;

import com.udacity.jpa.entity.inheritance.Delivery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DeliveryRepository {
    @PersistenceContext
    EntityManager entityManager;
    public void persist(Delivery delivery){
        entityManager.persist(delivery);
    }
    public Delivery findDelivery(Long id){
        return entityManager.find(Delivery.class,id);
    }
    public Delivery  merge(Delivery delivery){
       return entityManager.merge(delivery);
    }
    public void delete(Long id){
        Delivery delivery=entityManager.find(Delivery.class,id);
        entityManager.remove(delivery);
    }

}
