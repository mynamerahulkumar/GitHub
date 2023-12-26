package com.cab.cabbooking.controller;

import com.cab.cabbooking.dtos.CustomerOutPutDTO;
import com.cab.cabbooking.entity.Customer;
import com.cab.cabbooking.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegisterCustomer() {
        // Arrange
        Customer customer = new Customer();
        CustomerOutPutDTO expectedResponse = new CustomerOutPutDTO();
        when(customerService.insertCustomer(customer)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<CustomerOutPutDTO> response = customerController.registerCustomer(customer);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        verify(customerService, times(1)).insertCustomer(customer);
    }

    @Test
    void testUpdateCustomer() {
        // Arrange
        Customer customer = new Customer();
        String uuid = "123";
        CustomerOutPutDTO expectedResponse = new CustomerOutPutDTO();
        when(customerService.updateCustomer(customer, uuid)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<CustomerOutPutDTO> response = customerController.updateCustomer(customer, uuid);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        verify(customerService, times(1)).updateCustomer(customer, uuid);
    }

    @Test
    void testDeleteCustomer() {
        // Arrange
        String emailId = "test@example.com";
        String uuid = "123";
        CustomerOutPutDTO expectedResponse = new CustomerOutPutDTO();
        when(customerService.deleteCustomer(emailId, uuid)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<CustomerOutPutDTO> response = customerController.deleteCustomer(emailId, uuid);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        verify(customerService, times(1)).deleteCustomer(emailId, uuid);
    }
}
