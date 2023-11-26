package com.cab.cabbooking.dtos;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class User {
    private String userName;
    private String password;
    private String address;
    private String mobileNumber;
    private String email;
    private String userRole;
}
