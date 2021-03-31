package com.udacity.jpa.entity.id;

import com.udacity.jpa.entity.PersonPk;

import javax.persistence.Entity;
import javax.persistence.IdClass;

@Entity
@IdClass(PersonPk.class)
public class Person {
    private int heightCm;
    private String sockColor;

    public PersonPk getId(){
        PersonPk id=new PersonPk();
        id.setHeightCm(heightCm);
        id.setSockColor(sockColor);
        return id;
    }
    public void setId(PersonPk id){
        this.heightCm=id.getHeightCm();
        this.sockColor=id.getSockColor();
    }
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


}
