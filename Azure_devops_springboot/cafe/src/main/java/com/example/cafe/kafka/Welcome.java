package com.example.cafe.kafka;

import lombok.Data;

@Data
public class Welcome {
    private String message;
    private Integer remainingMinutes;
}
