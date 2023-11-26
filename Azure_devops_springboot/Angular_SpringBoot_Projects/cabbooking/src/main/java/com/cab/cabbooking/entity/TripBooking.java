package com.cab.cabbooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TripBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tripBookingId;

    private String pickupLocation;

    private String fromDateTime;

    private String dropLocation;

    private String toDateTime;

    private float distanceInKm;

    private String currStatus;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Driver driver;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Customer customer;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Cab cab;

}
