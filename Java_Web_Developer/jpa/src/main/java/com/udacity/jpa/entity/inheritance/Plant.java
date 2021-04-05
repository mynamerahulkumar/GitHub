package com.udacity.jpa.entity.inheritance;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jpa.model.Views;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;

@Entity
public class Plant {
    @Id
    @GeneratedValue
    Integer id;
    @Nationalized
    String name;
    @JsonView(Views.Public.class)
    @Column(precision = 12,scale = 4)
    double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }


}

