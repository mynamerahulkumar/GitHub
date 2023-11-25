package com.cab.cabbooking.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CurrentUserSession {

    @Id
    private Integer currUserId;

    private String uuid;

    private String currRole;

    private String currStatus;
}
