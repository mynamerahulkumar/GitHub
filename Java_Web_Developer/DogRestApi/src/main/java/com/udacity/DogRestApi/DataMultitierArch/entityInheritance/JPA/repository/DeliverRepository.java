package com.udacity.DogRestApi.DataMultitierArch.entityInheritance.JPA.repository;

import com.udacity.DogRestApi.DataMultitierArch.entityInheritance.DataTransferObject_DTO.RecipientAndPrice;
import com.udacity.DogRestApi.DataMultitierArch.entityInheritance.Delivery;
import com.udacity.DogRestApi.DataMultitierArch.entityInheritance.Plant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DeliverRepository {

    public List<Delivery> findDeliveriesByName(String name){
        TypedQuery<Delivery>query=entityManager.createNamedQuery("Delivery.findByName",Delivery.class);
        query.setParameter("name",name);
        return query.getResultList();
    }
    // one possible way to solve this -query a list of plants with deliveryId matching
    // the one provides and sum their results

    public RecipientAndPrice getBill(Long deliveryId){
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> query=cb.createQuery(RecipientAndPrice.class);
        Root<Plant> root=query.from(Plant.class);
        query.select(
                cb.construct(
                        RecipientAndPrice.class,
                        root.get("delivery").get("name"),
                        cb.sum(root.get("price"))))
                .where(cb.equal(root.get("delivery").get("id"),deliveryId));
        return  entityManager.createQuery(query).getSingleResult();

    }

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery){
        entityManager.persist(delivery);
    }

    public Delivery find(Long id){
        return entityManager.find(Delivery.class,id);
    }

    public Delivery merge(Delivery delivery){
        return  entityManager.merge(delivery);
    }

    public void Delete(Long id){
        Delivery delivery=entityManager.find(Delivery.class,id);
        entityManager.remove(delivery);
    }

}
