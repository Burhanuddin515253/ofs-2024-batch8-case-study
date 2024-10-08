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
import com.ofss.main.domain.Admin;
import com.ofss.main.domain.Cheque;
import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Transaction;
import com.ofss.main.service.AccountService;
import com.ofss.main.service.AdminService;
import com.ofss.main.service.ChequeService;
import com.ofss.main.service.RegistrationService;
import com.ofss.main.service.TransactionService;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("customer")
@CrossOrigin(origins = "*")
public class RegisterController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private ChequeService chequeService;
	@Autowired
	private AdminService adminService;
	
	
	
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
	
	@PostMapping("transaction")
	public String transact(@RequestBody Transaction transaction) {
		return transactionService.transact(transaction);
	}
	
	@GetMapping("alltransactions/{id}")
	public List<Transaction> allTransactions(@PathVariable int id){
		return transactionService.listOfTransaction(id);
	}
	
	@PostMapping("cheque")
	public String newCheque(@RequestBody Cheque cheque) {
		return chequeService.createCheque(cheque);
	}
	
	@PostMapping("adminLogin")
	public String newCheque(@RequestBody Admin admin) {
		return adminService.adminLogin(admin.getAdminLoginId(), admin.getAdminPassword());
	}
	
	@PostMapping("adminUnblock")
	public String adminUnblock(@RequestBody Customer customer) {
		return adminService.unblock(customer.getCustomerLoginId());
	}
	
	@PostMapping("adminApprove")
	public String adminApproval(@RequestBody Account account) {
		return adminService.approve(account.getAccountId());
	}
	
	@GetMapping("inactiveAccounts/{id}")
	public List<Account> getAccounts(@PathVariable int id) {
		return adminService.getInactiveAccounts(id);
	}
	
	@GetMapping("issuedCheques")
	public List<Cheque> getCheques() {
		return adminService.getCheques();
	}
	
	@PostMapping("clearCheques/{id}/{flag}")
	public String clearCheques(@PathVariable int id,@PathVariable boolean flag) {
		return adminService.clearCheque(id, flag);
	}
	
}


