package com.cab.cabbooking.entity;

import com.cab.cabbooking.entity.Driver;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cabId;

    private String carType;

    private String carName;

    private String carNumber;

    private float perKmRate;

    private String currLocation;

    private String cabCurrStatus;

    @OneToOne
    @JsonIgnore
    private Driver driver;

}
