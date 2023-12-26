package com.cab.cabbooking.mapper;

import com.cab.cabbooking.constants.CabBookingConstants;
import com.cab.cabbooking.dtos.CabOutPutDTO;
import com.cab.cabbooking.dtos.CustomerOutPutDTO;
import com.cab.cabbooking.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer updateCustomerMapper(Customer customer,Customer customerDetailByEmailId){
        Customer updatedCustomer=customerDetailByEmailId;
        updatedCustomer.setAddress(customer.getAddress());
        updatedCustomer.setEmail(customer.getEmail());
        updatedCustomer.setMobileNumber(customer.getMobileNumber());
        updatedCustomer.setPassword(customer.getPassword());
        updatedCustomer.setUserName(customer.getUserName());
        return updatedCustomer;
    }

    public CustomerOutPutDTO updateResponseInsert(Customer customer){
        CustomerOutPutDTO customerOutPutDTO=new CustomerOutPutDTO();
        if(customer!=null){
            customerOutPutDTO.setStatus(CabBookingConstants.SUCCESS_MESSAGE);
            customerOutPutDTO.setMessage(CabBookingConstants.CUSTOMER_ADDED);
        }
        return customerOutPutDTO;
    }
    public CustomerOutPutDTO updateResponseUpdate(Customer customer){
        CustomerOutPutDTO customerOutPutDTO=new CustomerOutPutDTO();
        if(customer!=null){
            customerOutPutDTO.setStatus(CabBookingConstants.SUCCESS_MESSAGE);
            customerOutPutDTO.setMessage(CabBookingConstants.CUSTOMER_UPDATED);
        }
        return customerOutPutDTO;
    }
    public CustomerOutPutDTO updateResponseDelete(Customer customer){
        CustomerOutPutDTO customerOutPutDTO=new CustomerOutPutDTO();
        if(customer!=null){
            customerOutPutDTO.setStatus(CabBookingConstants.SUCCESS_MESSAGE);
            customerOutPutDTO.setMessage(CabBookingConstants.CUSTOMER_DELETED);
        }
        return customerOutPutDTO;
    }
}
