package com.ofss.main.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;
import com.ofss.main.repository.*;


@Service
public class RegistrationServiceImpl implements RegistrationService{
	@Autowired
    private RegistrationRepo customerRepository;

    @Override
    public String register(Customer customer) {
        try {
            customerRepository.save(customer);
            System.out.println("register true");
            return "true";  // Registration successful
        } catch (DataAccessException e) {
            // Log the exception
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("Error occurred while saving customer: ", e);
            return "false";  // Registration failed
        } catch (Exception e) {
            // Log unexpected exceptions
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("Unexpected error occurred while saving customer: ", e);
            return "false";  // Registration failed
        }
    }

//    @Override
//    public String login(String customer_login_id, String customer_password) {
//        return customerRepository.login(customer_login_id,customer_password);
//    }
//
//    @Override
//    public List<Customer> getAllCustomer() {
//        return customerRepository.getAllCustomer();
//    }

    

    

    
   
    
}
