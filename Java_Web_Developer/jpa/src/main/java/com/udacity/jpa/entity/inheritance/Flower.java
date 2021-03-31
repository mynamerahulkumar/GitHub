package com.udacity.jpa.entity.inheritance;

import javax.persistence.Entity;

@Entity
public class Flower extends Plant {
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color;

}
