package com.cab.cabbooking.services;

import com.cab.cabbooking.dtos.CabOutPutDTO;
import com.cab.cabbooking.entity.Cab;
import com.cab.cabbooking.mapper.CabMapper;
import com.cab.cabbooking.processor.CabProcessor;
import com.cab.cabbooking.services.CabServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CabServiceImplTest {

    @Mock
    private CabProcessor cabProcessor;

    @Mock
    private CabMapper cabMapper;

    @InjectMocks
    private CabServiceImpl cabService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testInsertCab() {
        // Arrange
        Cab cab = new Cab();
        Cab resCab = new Cab();
        CabOutPutDTO expectedOutputDTO = new CabOutPutDTO();

        when(cabProcessor.insertCabProcess(cab)).thenReturn(resCab);
        when(cabMapper.updateResponseInsert(resCab)).thenReturn(expectedOutputDTO);

        // Act
        CabOutPutDTO actualOutputDTO = cabService.insertCab(cab);

        // Assert
        assertEquals(expectedOutputDTO, actualOutputDTO);
        verify(cabProcessor, times(1)).insertCabProcess(cab);
        verify(cabMapper, times(1)).updateResponseInsert(resCab);
    }

    @Test
    void testUpdateCab() {
        // Arrange
        Cab cab = new Cab();
        String uuid = "123";
        Cab resCab = new Cab();
        CabOutPutDTO expectedOutputDTO = new CabOutPutDTO();

        when(cabProcessor.updateCabProcess(cab, uuid)).thenReturn(resCab);
        when(cabMapper.updateResponseUpdate(resCab)).thenReturn(expectedOutputDTO);

        // Act
        CabOutPutDTO actualOutputDTO = cabService.updateCab(cab, uuid);

        // Assert
        assertEquals(expectedOutputDTO, actualOutputDTO);
        verify(cabProcessor, times(1)).updateCabProcess(cab, uuid);
        verify(cabMapper, times(1)).updateResponseUpdate(resCab);
    }

    @Test
    void testDeleteCab() {
        // Arrange
        Integer cabId = 1;
        String uuid = "123";
        Cab resCab = new Cab();
        CabOutPutDTO expectedOutputDTO = new CabOutPutDTO();

        when(cabProcessor.deleteCabProcess(cabId, uuid)).thenReturn(resCab);
        when(cabMapper.updateResponseDelete(resCab)).thenReturn(expectedOutputDTO);

        // Act
        CabOutPutDTO actualOutputDTO = cabService.deleteCab(cabId, uuid);

        // Assert
        assertEquals(expectedOutputDTO, actualOutputDTO);
        verify(cabProcessor, times(1)).deleteCabProcess(cabId, uuid);
        verify(cabMapper, times(1)).updateResponseDelete(resCab);
    }
}
