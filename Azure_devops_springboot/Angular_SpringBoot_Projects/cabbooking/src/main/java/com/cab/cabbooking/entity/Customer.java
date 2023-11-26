package com.cab.cabbooking.entity;

import com.cab.cabbooking.dtos.User;
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
