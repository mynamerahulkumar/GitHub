package com.cab.cabbooking.services;

import com.cab.cabbooking.dtos.CustomerOutPutDTO;
import com.cab.cabbooking.entity.Customer;

import java.util.List;

public interface CustomerService {

    CustomerOutPutDTO insertCustomer(Customer customer);

    CustomerOutPutDTO updateCustomer(Customer customer,String uuid);

    CustomerOutPutDTO  deleteCustomer(String  emailId , String uuid);

}
