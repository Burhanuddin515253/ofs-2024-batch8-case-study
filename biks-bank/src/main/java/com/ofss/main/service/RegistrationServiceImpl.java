package com.ofss.main.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aot.hint.annotation.RegisterReflectionForBindingProcessor;
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
            return "success";  // Registration successful
        } catch (DataAccessException e) {
            // Log the exception
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("Error occurred while saving customer: ", e);
            return "false";  // Registration failed
        } catch (Exception e) {
            // Log unexpected exceptions
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("Unexpected error occurred while saving customer: ", e);
            System.out.println(customer);
            return "false";  // Registration failed
        }
    }

  @Override
public String login(String customer_login_id, String customer_password) {
        List<Customer> customers = customerRepository.findByCustomerLoginId(customer_login_id);
        System.out.println("hello"+customer_login_id);
        System.out.println(customers.get(0));
        if(customers.isEmpty()) {
        	return "customer not found";
        }else {
        	if(customers.get(0).getCustomer_password().equals(customer_password)) {
        		return "login successfull";
        	}else {
        		Customer customer = customers.get(0);
        		customer.setLogin_attempts(customer.getLogin_attempts()+1);
        		if(customer.getLogin_attempts()==3) {
        			customer.setCustomer_status("inactive");
        		}
            	customerRepository.save(customer);
            	return "wrong password";
        	}

        } 
  }
//
//    @Override
//    public List<Customer> getAllCustomer() {
//        return customerRepository.getAllCustomer();
//    }   
    
}
