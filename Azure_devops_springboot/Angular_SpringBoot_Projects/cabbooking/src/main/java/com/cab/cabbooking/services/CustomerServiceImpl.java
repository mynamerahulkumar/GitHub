package com.cab.cabbooking.services;

import com.cab.cabbooking.constants.CabBookingConstants;
import com.cab.cabbooking.dtos.CustomerOutPutDTO;
import com.cab.cabbooking.entity.CurrentUserSession;
import com.cab.cabbooking.entity.Customer;
import com.cab.cabbooking.exception.CabException;
import com.cab.cabbooking.mapper.CustomerMapper;
import com.cab.cabbooking.processor.CabProcessor;
import com.cab.cabbooking.processor.CustomerProcessor;
import com.cab.cabbooking.repository.CurrentUserSessionRepo;
import com.cab.cabbooking.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerProcessor customerProcessor;

    @Autowired
    private CustomerMapper customerMapper;

    public CustomerOutPutDTO insertCustomer(Customer customer) {

        Customer resCustomer = customerProcessor.insertCustomerProcess(customer);
        CustomerOutPutDTO customerOutPutDTO = customerMapper.updateResponseInsert(resCustomer);
        return customerOutPutDTO;

    }

    @Override
    public CustomerOutPutDTO updateCustomer(Customer customer, String uuid) {
        Customer resCustomer = customerProcessor.updateCustomerProcess(customer, uuid);
        CustomerOutPutDTO customerOutPutDTO = customerMapper.updateResponseUpdate(resCustomer);
        return customerOutPutDTO;

    }

    @Override
    public CustomerOutPutDTO deleteCustomer(String  emailId, String uuid) {
        Customer resCustomer = customerProcessor.deleteCustomerProcess(emailId, uuid);
        CustomerOutPutDTO customerOutPutDTO = customerMapper.updateResponseDelete(resCustomer);
        return customerOutPutDTO;
    }


}
