package com.cab.cabbooking.dtos;

import lombok.Data;

@Data
public class CabResponseErrorDTO {
    private int  status;
    private String errorMessage;

    private String errorCode;

    private String traceId;
}
