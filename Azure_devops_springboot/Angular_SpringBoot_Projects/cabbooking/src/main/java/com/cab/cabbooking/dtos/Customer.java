package com.cab.cabbooking.dtos;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<TripBooking> tripBookings;
}
