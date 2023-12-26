package com.cab.cabbooking.controller;

import com.cab.cabbooking.dtos.CabOutPutDTO;
import com.cab.cabbooking.dtos.CustomerOutPutDTO;
import com.cab.cabbooking.entity.Customer;
import com.cab.cabbooking.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("/register")
    public ResponseEntity<CustomerOutPutDTO> registerCustomer(@RequestBody Customer customer){
        CustomerOutPutDTO response=customerService.insertCustomer(customer);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerOutPutDTO> updateCustomer(@RequestBody Customer customer,
                                                   @RequestParam("uuid") String uuid){
        CustomerOutPutDTO response=customerService.updateCustomer(customer,uuid);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CustomerOutPutDTO> deleteCustomer(@RequestParam("emailID") String  emailId,
                                                   @RequestParam("uuid") String uuid){
        CustomerOutPutDTO response=customerService.deleteCustomer(emailId,uuid);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
