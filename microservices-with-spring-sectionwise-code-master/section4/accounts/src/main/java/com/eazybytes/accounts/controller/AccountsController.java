/**
 * 
 */
package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.config.AccountsServiceConfig;
import com.eazybytes.accounts.model.*;
import com.eazybytes.accounts.service.client.CardsFeignClient;
import com.eazybytes.accounts.service.client.LoansFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eazybytes.accounts.repository.AccountsRepository;

import java.util.List;

/**
 * @author Eazy Bytes
 *
 */

@RestController
public class AccountsController {
	
	@Autowired
	private AccountsRepository accountsRepository;

	@Autowired
	private AccountsServiceConfig accountsServiceConfig;

	@Autowired
	 LoansFeignClient loansFeignClient;
	@Autowired
	 CardsFeignClient cardsFeignClient;

	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {

		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		if (accounts != null) {
			return accounts;
		} else {
			return null;
		}

	}

	@GetMapping("/account/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow=new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties=new Properties(accountsServiceConfig.getMsg(),accountsServiceConfig.getBuildVersion(),
				accountsServiceConfig.getMailDetails(),accountsServiceConfig.getActiveBranches());
		String jsonStr=ow.writeValueAsString(properties);
		return jsonStr;
	}

	@PostMapping("/myCustomerDetails")
	@CircuitBreaker(name = "detailsForCustomerSupportApp",fallbackMethod = "myCustomerDetailsFallBack")//open the circuit if not reachable
	//@Retry(name = "retryForCustomerDetails",fallbackMethod = "myCustomerDetailsFallBack")//retry aftersometime
	public CustomerDetails myCustomerDetails(@RequestHeader("eazybank-correlation-id") String correlationid, @RequestBody Customer customer){
		Accounts accounts=accountsRepository.findByCustomerId(customer.getCustomerId());
		List<Loans> loans=loansFeignClient.getLoansDetails(correlationid,customer);
		List<Cards> cards=cardsFeignClient.getCardDetails(correlationid,customer);
		CustomerDetails customerDetails=new CustomerDetails();
		customerDetails.setAccounts(accounts);
		customerDetails.setCards(cards);
		customerDetails.setLoans(loans);
		return customerDetails;
	}
	private CustomerDetails myCustomerDetailsFallBack(@RequestHeader("eazybank-correlation-id") String correlationid,Customer customer){
		Accounts accounts=accountsRepository.findByCustomerId(customer.getCustomerId());
		List<Loans>loans=loansFeignClient.getLoansDetails(correlationid,customer);
		List<Cards>cards=cardsFeignClient.getCardDetails(correlationid,customer);
		CustomerDetails customerDetails=new CustomerDetails();
		customerDetails.setAccounts(accounts);
		customerDetails.setLoans(loans);
		return  customerDetails;
	}

	@GetMapping("/sayHello")
	@RateLimiter(name = "sayHello",fallbackMethod = "sayHelloFallback")
	public String getHello(){
		return "Welcome to eazy bank";
	}
	private String sayHelloFallback(){
		return "Welcome to eazy bank secondary";
	}





}
