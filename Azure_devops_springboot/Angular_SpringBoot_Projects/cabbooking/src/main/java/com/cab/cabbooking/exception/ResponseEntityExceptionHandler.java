package com.cab.cabbooking.exception;

import com.cab.cabbooking.constants.CabBookingConstants;
import com.cab.cabbooking.dtos.CabResponseErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResponseEntityExceptionHandler {
    @ExceptionHandler(CabException.class)
    public ResponseEntity<CabResponseErrorDTO> customException(CabException cabException){
        CabResponseErrorDTO cabResponseErrorDTO=setCabException(cabException);
        if(cabException.getStatus()== CabBookingConstants.BAD_REQUEST){
            return  new ResponseEntity<>(cabResponseErrorDTO, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(cabResponseErrorDTO,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public CabResponseErrorDTO setCabException(CabException cabException){
        CabResponseErrorDTO cabResponseErrorDTO=new CabResponseErrorDTO();
        cabResponseErrorDTO.setStatus(cabException.getStatus());
        cabResponseErrorDTO.setErrorMessage(cabException.getErrorMessage());
        cabResponseErrorDTO.setErrorCode(cabException.getErrorCode());
        cabResponseErrorDTO.setTraceId(cabException.getTraceId());
        return cabResponseErrorDTO;
    }

}
