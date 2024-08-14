package com.ofss.main.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;
import com.ofss.main.service.AccountService;
import com.ofss.main.service.RegistrationService;


@RestController
@RequestMapping("customer")
@CrossOrigin(origins = "*")
public class RegisterController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private RegistrationService registrationService;
	
	
	
	@PostMapping("register")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
		return ResponseEntity.ok(registrationService.register(customer));
		
	}
	
	@PostMapping("login")
	public ResponseEntity<String> loginCustomer(@RequestBody Customer customer){
		System.out.println(customer);
		return ResponseEntity.ok(registrationService.login(customer.getCustomerLoginId(), customer.getCustomer_password()));
	}
	
	@PostMapping("account")
	public String accountCreation(@RequestBody Account account) {
		return accountService.createAccount(account);
	}
	
	@GetMapping("allaccounts/{id}")
	public List<Account> allAccounts(@PathVariable int id){
		return accountService.listOfAccount(id);
	}
	
	
	
	
	
}


