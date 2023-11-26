package com.cab.cabbooking.services;

import com.cab.cabbooking.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer insertCustomer(Customer customer);

    Customer updateCustomer(Customer customer,String uuid);

    List<Customer> deleteCustomer(Integer customerId, String uuid);

}
