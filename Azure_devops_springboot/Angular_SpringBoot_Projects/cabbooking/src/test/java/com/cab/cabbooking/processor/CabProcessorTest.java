package com.cab.cabbooking.processor;

import com.cab.cabbooking.constants.CabBookingConstants;
import com.cab.cabbooking.entity.Cab;
import com.cab.cabbooking.entity.CurrentUserSession;
import com.cab.cabbooking.exception.CabException;
import com.cab.cabbooking.mapper.CabMapper;
import com.cab.cabbooking.repository.CabRepo;
import com.cab.cabbooking.repository.CurrentUserSessionRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CabProcessorTest {

    @Mock
    private CabRepo cabRepo;

    @Mock
    private CurrentUserSessionRepo currRepo;

    @Mock
    private CabMapper cabMapper;

    @InjectMocks
    private CabProcessor cabProcessor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInsertCabProcess() throws CabException {
        // Arrange
        Cab cab = new Cab();
        cab.setCarNumber("ABC123");

        when(cabRepo.findByCarNumber(cab.getCarNumber())).thenReturn(null);
        when(cabRepo.save(cab)).thenReturn(cab);

        // Act
        Cab result = cabProcessor.insertCabProcess(cab);

        // Assert
        assertNotNull(result);
        assertEquals(cab, result);

        verify(cabRepo, times(1)).findByCarNumber(cab.getCarNumber());
        verify(cabRepo, times(1)).save(cab);
    }

    @Test
    void testInsertCabProcess_CabAlreadyRegistered() {
        // Arrange
        Cab cab = new Cab();
        cab.setCarNumber("ABC123");

        when(cabRepo.findByCarNumber(cab.getCarNumber())).thenReturn(cab);

        // Act & Assert
        assertThrows(CabException.class, () -> cabProcessor.insertCabProcess(cab));

        verify(cabRepo, times(1)).findByCarNumber(cab.getCarNumber());
        verify(cabRepo, never()).save(cab);
    }

    @Test
    void testUpdateCabProcess() throws CabException {
        // Arrange
        Cab cab = new Cab();
        cab.setCarNumber("ABC123");

        String uuid = "12345";

        List<CurrentUserSession> validUser = new ArrayList<>();
        validUser.add(new CurrentUserSession());

        when(currRepo.findByUuidAndRole(uuid)).thenReturn(validUser);
        when(cabRepo.findByCarNumber(cab.getCarNumber())).thenReturn(cab);
        when(cabMapper.updateCabMapper(cab, cab)).thenReturn(cab);
        when(cabRepo.save(cab)).thenReturn(cab);

        // Act
        Cab result = cabProcessor.updateCabProcess(cab, uuid);

        // Assert
        assertNotNull(result);
        assertEquals(cab, result);

        verify(currRepo, times(1)).findByUuidAndRole(uuid);
        verify(cabRepo, times(1)).findByCarNumber(cab.getCarNumber());
        verify(cabMapper, times(1)).updateCabMapper(cab, cab);
        verify(cabRepo, times(1)).save(cab);
    }

    @Test
    void testUpdateCabProcess_UserNotLoggedIn() {
        // Arrange
        Cab cab = new Cab();
        cab.setCarNumber("ABC123");

        String uuid = "12345";

        when(currRepo.findByUuidAndRole(uuid)).thenReturn(null);

        // Act & Assert
        assertThrows(CabException.class, () -> cabProcessor.updateCabProcess(cab, uuid));

        verify(currRepo, times(1)).findByUuidAndRole(uuid);
        verify(cabRepo, never()).findByCarNumber(cab.getCarNumber());
        verify(cabMapper, never()).updateCabMapper(cab, cab);
        verify(cabRepo, never()).save(cab);
    }

}