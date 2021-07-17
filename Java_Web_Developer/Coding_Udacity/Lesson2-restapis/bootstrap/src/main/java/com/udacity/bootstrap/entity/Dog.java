package com.udacity.bootstrap.entity;

import jdk.Exported;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Exported
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String name;
    private String breed;
    protected String origin;
    private Dog(Long id,String Name,String Breed,String Origin){
        this.id=id;
        this.breed=Breed;
        this.name=Name;
        this.origin=Origin;
    }
    private Dog(String Name,String Breed,String Origin){
        this.breed=Breed;
        this.name=Name;
        this.origin=Origin;
    }
    private Dog(){

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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
