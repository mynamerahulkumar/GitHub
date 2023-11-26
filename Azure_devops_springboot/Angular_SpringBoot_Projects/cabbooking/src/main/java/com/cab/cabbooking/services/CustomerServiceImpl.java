package com.cab.cabbooking.services;

import com.cab.cabbooking.constants.CabBookingConstants;
import com.cab.cabbooking.entity.CurrentUserSession;
import com.cab.cabbooking.entity.Customer;
import com.cab.cabbooking.exception.CabException;
import com.cab.cabbooking.repository.CurrentUserSessionRepo;
import com.cab.cabbooking.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl  implements CustomerService{

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CurrentUserSessionRepo currRepo;

    public Customer insertCustomer(Customer customer){
        Optional<Customer> cust=customerRepo.findByemail(customer.getEmail());
        if(cust.isPresent()){
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

    @Override
    public Customer updateCustomer(Customer customer, String uuid) {
        Optional<CurrentUserSession> validCustomer=currRepo.findByuuid(uuid);
        if(validCustomer.isPresent()){
            Optional<Customer> cust=customerRepo.findByemail(customer.getEmail());
            if(cust.isPresent()){
                Customer updatingCustomer=cust.get();
                updatingCustomer.setAddress(customer.getAddress());
                updatingCustomer.setEmail(customer.getEmail());
                updatingCustomer.setMobileNumber(customer.getMobileNumber());
                updatingCustomer.setPassword(customer.getPassword());
                updatingCustomer.setUserName(customer.getUserName());
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

    @Override
    public List<Customer> deleteCustomer(Integer customerId, String uuid) {
        Optional<CurrentUserSession> validCustomer=currRepo.findByUuidAndRole(uuid);
        if(validCustomer.isPresent()){
            List<Customer> viewCustomers=customerRepo.findAll();
            if(!viewCustomers.isEmpty()){
                return viewCustomers;
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
