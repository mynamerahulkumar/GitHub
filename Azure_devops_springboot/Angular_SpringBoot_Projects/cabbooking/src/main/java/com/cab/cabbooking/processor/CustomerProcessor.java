package com.cab.cabbooking.processor;

import com.cab.cabbooking.constants.CabBookingConstants;
import com.cab.cabbooking.entity.CurrentUserSession;
import com.cab.cabbooking.entity.Customer;
import com.cab.cabbooking.exception.CabException;
import com.cab.cabbooking.mapper.CustomerMapper;
import com.cab.cabbooking.repository.CurrentUserSessionRepo;
import com.cab.cabbooking.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerProcessor {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CurrentUserSessionRepo currRepo;

    @Autowired
    private CustomerMapper customerMapper;

    public Customer insertCustomerProcess(Customer customer){
        Customer cust=customerRepo.findByemail(customer.getEmail());
        if(cust!=null){
            throw  new CabException.Builder()
                    .status(CabBookingConstants.BAD_REQUEST)
                    .errorCode(CabBookingConstants.CUSTOMER_ALREADY_REGISTERED_CODE)
                    .errorMessage(CabBookingConstants.CUSTOMER_ALREADY_REGISTERED).build();
        }
        else{
            if(customer.getUserRole().equalsIgnoreCase("Customer")){
                return customerRepo.save(customer);
            }
            else{
                throw  new CabException.Builder()
                        .status(CabBookingConstants.BAD_REQUEST)
                        .errorCode(CabBookingConstants.USER_NOT_CUSTOMER_CODE)
                        .errorMessage(CabBookingConstants.USER_NOT_CUSTOMER).build();
            }
        }
    }


    public Customer updateCustomerProcess(Customer customer, String uuid) {
        List<CurrentUserSession> validCustomer=currRepo.findByuuid(uuid);
        if(validCustomer!=null){
            Customer custDetailsByEmailId=customerRepo.findByemail(customer.getEmail());
            if(custDetailsByEmailId!=null){
                Customer updatingCustomer=customerMapper.updateCustomerMapper(customer,custDetailsByEmailId);
                return customerRepo.save(updatingCustomer);
            }
            else{
                throw  new CabException.Builder()
                        .status(CabBookingConstants.BAD_REQUEST)
                        .errorCode(CabBookingConstants.CUSTOMER_NOT_FOUND_CREDENTIAL_CODE)
                        .errorMessage(CabBookingConstants.CUSTOMER_NOT_FOUND_CREDENTIAL).build();
            }
        }
        else {
            throw  new CabException.Builder()
                    .status(CabBookingConstants.BAD_REQUEST)
                    .errorCode(CabBookingConstants.CUSTOMER_NOT_LOGGEDIN_CODE)
                    .errorMessage(CabBookingConstants.CUSTOMER_NOT_LOGGEDIN).build();
        }


    }


    public Customer deleteCustomerProcess( String emailId, String uuid) {
        List<CurrentUserSession> validCustomer=currRepo.findByUuidAndRole(uuid);
        if(validCustomer!=null){
           Customer customer=customerRepo.findByemail(emailId);
            if(customer!=null){
                customerRepo.delete(customer);
                return customer;
            }
            else{
                throw  new CabException.Builder()
                        .status(CabBookingConstants.BAD_REQUEST)
                        .errorCode(CabBookingConstants.CUSTOMER_NOT_FOUND_CODE)
                        .errorMessage(CabBookingConstants.CUSTOMER_NOT_FOUND).build();
            }
        }
        else{
            throw  new CabException.Builder()
                    .status(CabBookingConstants.BAD_REQUEST)
                    .errorCode(CabBookingConstants.CUSTOMER_NOT_LOGGEDIN_CODE)
                    .errorMessage(CabBookingConstants.CUSTOMER_NOT_LOGGEDIN).build();
        }
    }

}
