package com.udacity.jpa.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonPk implements Serializable {
    private int heightCm;
    private String sockColor;

    public int getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(int heightCm) {
        this.heightCm = heightCm;
    }

    public String getSockColor() {
        return sockColor;
    }

    public void setSockColor(String sockColor) {
        this.sockColor = sockColor;
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null||getClass()!=o.getClass()) return false;
        PersonPk personPk=(PersonPk) o;
        return heightCm==personPk.heightCm && sockColor.equals(personPk.sockColor);
    }
    @Override
    public int hashCode(){
        return Objects.hash(heightCm,sockColor);
    }


}
