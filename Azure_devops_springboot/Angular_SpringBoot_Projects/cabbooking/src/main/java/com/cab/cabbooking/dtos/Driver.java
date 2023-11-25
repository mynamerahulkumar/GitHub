package com.cab.cabbooking.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Driver extends User {

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
