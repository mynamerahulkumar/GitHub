package com.cab.cabbooking.services;

import com.cab.cabbooking.entity.Cab;
import com.cab.cabbooking.entity.Driver;
import com.cab.cabbooking.exception.CabException;
import com.cab.cabbooking.repository.CabRepo;
import com.cab.cabbooking.repository.CurrentUserSessionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CabServiceImplTest {

    @Mock
    private CabRepo cabRepo;

    @Mock
    private CurrentUserSessionRepo currRepo;

    @InjectMocks
    private CabServiceImpl cabService;
    Cab cab;

    Driver driver;

    @BeforeEach
    public void init() {
        cab = new Cab();
        driver = new Driver();
        cab.setPerKmRate(10);
        cab.setCabId(234234);
        cab.setCarType("SUDAN");
        cab.setCarName("BMW");
        cab.setCabCurrStatus("PRESENT");
        cab.setDriver(driver);
    }


    @Test
    public void insertCab() throws CabException {
        Cab response = cabService.insertCab(cab);
        Assertions.assertNotNull(response);

    }
}
