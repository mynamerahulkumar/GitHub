package com.cab.cabbooking.controller;

import com.cab.cabbooking.dtos.CabOutPutDTO;
import com.cab.cabbooking.entity.Cab;
import com.cab.cabbooking.services.CabService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CabBookingControllerTest {

    @Mock
    private CabService cabService;

    @InjectMocks
    private CabBookingController cabBookingController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegister() {
        // Arrange
        Cab cab = new Cab();
        CabOutPutDTO expectedResponse = new CabOutPutDTO();
        when(cabService.insertCab(cab)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<CabOutPutDTO> response = cabBookingController.register(cab);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        verify(cabService, times(1)).insertCab(cab);
    }

    @Test
    void testUpdate() {
        // Arrange
        Cab cab = new Cab();
        String uuid = "123";
        CabOutPutDTO expectedResponse = new CabOutPutDTO();
        when(cabService.updateCab(cab, uuid)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<CabOutPutDTO> response = cabBookingController.update(cab, uuid);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        verify(cabService, times(1)).updateCab(cab, uuid);
    }

    @Test
    void testDeleteCab() {
        // Arrange
        Integer cabId = 1;
        String uuid = "123";
        CabOutPutDTO expectedResponse = new CabOutPutDTO();
        when(cabService.deleteCab(cabId, uuid)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<CabOutPutDTO> response = cabBookingController.deleteCab(cabId, uuid);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        verify(cabService, times(1)).deleteCab(cabId, uuid);
    }
}
