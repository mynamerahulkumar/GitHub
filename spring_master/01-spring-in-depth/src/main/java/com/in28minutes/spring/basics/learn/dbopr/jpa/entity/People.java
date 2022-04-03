package com.in28minutes.spring.basics.learn.dbopr.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class People {

    @Id
    @GeneratedValue
    private  int id;

    private String location;
    private Date birth_Date;
    private  String name;
    public People(){

    }

    public People(String name, String location, Date birth_Date) {
        super();
        this.name = name;
        this.location = location;
        this.birth_Date = birth_Date;
    }
    public People(int id, String name, String location, Date birth_Date) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.birth_Date = birth_Date;
    }
    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birth_Date=" + birth_Date +
                '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirth_Date() {
        return birth_Date;
    }

    public void setBirth_Date(Date birth_Date) {
        this.birth_Date = birth_Date;
    }

}
