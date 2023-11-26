package com.cab.cabbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CurrentUserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer currUserId;

    private String uuid;

    private String currRole;

    private String currStatus;
}
