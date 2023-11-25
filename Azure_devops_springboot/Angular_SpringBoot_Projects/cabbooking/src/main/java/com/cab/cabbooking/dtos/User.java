package com.cab.cabbooking.dtos;

import lombok.Data;

@Data
public class User {
    private String userName;
    private String password;
    private String address;
    private String mobileNumber;
    private String email;
    private String userRole;
}
