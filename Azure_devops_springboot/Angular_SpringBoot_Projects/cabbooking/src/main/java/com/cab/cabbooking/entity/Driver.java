package com.cab.cabbooking.entity;

import com.cab.cabbooking.dtos.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity(name = "driver")
public class Driver extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer driverId;

    private String licenseNo;

    private float rating;

    private String currLocation;

    private String currDriverStatus;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "driver")
    @JsonIgnore
    List<TripBooking> trips=new ArrayList<>();

    @OneToOne
    @JsonIgnore
    private Cab cab;


}
