package com.udacity.DogRestApi.DataMultitierArch.entityInheritance;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Flower extends Plant {
    public Flower(){

    }
    public Flower(Long id, String name, BigDecimal price, Delivery delivery, String color) {
        super(id, name, price, delivery);
        this.color = color;
    }

    public Flower(String color) {
        this.color = color;
    }

    private  String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
