package com.cab.cabbooking.controller;

import com.cab.cabbooking.dtos.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,
                                                   @RequestParam("cuid") String CustomerId){
        return null;
    }

    public ResponseEntity<Customer> deleteCustomer(@RequestParam("customerId") Integer CustomerId,
                                                   @RequestParam("cuid") String customerId){
        return null;
    }
}
