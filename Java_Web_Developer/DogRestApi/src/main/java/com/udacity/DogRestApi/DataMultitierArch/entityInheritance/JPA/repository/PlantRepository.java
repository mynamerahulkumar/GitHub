package com.udacity.DogRestApi.DataMultitierArch.entityInheritance.JPA.repository;

import com.udacity.DogRestApi.DataMultitierArch.entityInheritance.Delivery;
import com.udacity.DogRestApi.DataMultitierArch.entityInheritance.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

    Boolean existPlantByIdAndDeliveryCompleted(Long id, Boolean delivered);

    @Query("select p.delivery.completed from Plant p where p.id=:plantId")
    Boolean deliveryCompleted(Long plantId);

    // to return a wrapper class ,you may need to construct as a projection
    @Query("select new.java.lang.Boolean(p.delivery.completed) from Plant pl where p.id=:plantid")
    Boolean deliveryCompletedBoolean(Long plantid);

    // we can do this entirely with the method name
    List<Plant> findPriceLessThan(BigDecimal price);

}
