package com.ofss.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.*;

@Service
public interface RegistrationService {

    public String register(Customer customer);

//    public String login(String customer_login_id, String customer_password);
//
//    List<Customer> getAllCustomer();
 
 
}
