package com.udacity.DogRestApi.DataMultitierArch.entityInheritance;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant {

    @Id
    @GeneratedValue
    private  Long id;

    @Nationalized
    private  String name;

    @Column(precision = 12,scale = 4)
    private BigDecimal price;



    @ManyToOne(fetch = FetchType.LAZY) // don't retreive delivery if we don't need
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    public Plant(Long id, String name, BigDecimal price, Delivery delivery) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.delivery = delivery;
    }
    public Plant() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }


}
