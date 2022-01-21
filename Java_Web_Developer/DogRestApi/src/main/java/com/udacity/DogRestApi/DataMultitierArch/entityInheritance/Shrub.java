package com.udacity.DogRestApi.DataMultitierArch.entityInheritance;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Shrub extends  Plant{
    public Shrub(Long id, String name, BigDecimal price, Delivery delivery, int heightCm, int widthCm) {
        super(id, name, price, delivery);
        this.heightCm = heightCm;
        this.widthCm = widthCm;
    }
    public  Shrub(){

    }


    public Shrub(int heightCm, int widthCm) {
        this.heightCm = heightCm;
        this.widthCm = widthCm;
    }

    private int heightCm;
    private int widthCm;

    public int getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(int heightCm) {
        this.heightCm = heightCm;
    }

    public int getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(int widthCm) {
        this.widthCm = widthCm;
    }


}
