package com.ofss.main.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;
import com.ofss.main.repository.*;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	RegistrationRepo registerRepo;
	@Autowired
	AccountRepo accountRepo;
	
	public List<Account> listOfAccount(int customer_id) {
		Optional<Customer> optionalcustomer=registerRepo.findById(customer_id);
		if(optionalcustomer.isPresent()) {
			Customer customer = optionalcustomer.get();
			List<Account> accounts=accountRepo.findByCustomer(customer);
			System.out.println("List of account is: "+accounts);
			return accounts;
		}
		return null;
	}
	
	public String createAccount(Account account) {
        try {
            accountRepo.save(account);
            System.out.println("account created");
            return "true";  
        } catch (DataAccessException e) {
            // Log the exception
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("Error occurred while account creation: ", e);
            return "false";  
        } catch (Exception e) {
            // Log unexpected exceptions
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("Unexpected error occurred while account creation: ", e);
            System.out.println(account);
            return "false";  
        }
	}
    
}
