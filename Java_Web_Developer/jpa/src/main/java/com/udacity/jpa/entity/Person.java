package com.udacity.jpa.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Person {
    @EmbeddedId
    PersonPk id;
    /*
    Rest of the table class
     */

}
