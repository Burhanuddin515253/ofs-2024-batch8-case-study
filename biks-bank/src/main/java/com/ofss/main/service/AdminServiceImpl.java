package com.ofss.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Admin;
import com.ofss.main.domain.Cheque;
import com.ofss.main.domain.Customer;
import com.ofss.main.repository.AccountRepo;
import com.ofss.main.repository.AdminRepo;
import com.ofss.main.repository.RegistrationRepo;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminRepo adminRepo;
	@Autowired
	RegistrationRepo registrationRepo;
	@Autowired
	AccountRepo accountRepo;
	
	@Override
	public String adminLogin(String admin_login_id, String admin_password) {
		Optional<Admin> optionalAdmin = adminRepo.findByAdminLoginId(admin_login_id);
		String result = null;
        if(optionalAdmin.isPresent()){
        	Admin admin = optionalAdmin.get();
            String pass = admin.getAdminPassword();
            if(pass.equals(admin_password)){
                return "Login Successful !";
            }else{
                return "Password Incorrect";
            }
        }else{
            result = "Admin does not exist.";
            return result;
        }
	}

	@Override
	public String unblock(String customer_login_id) {
		List<Customer> optionalCustomer = registrationRepo.findByCustomerLoginId(customer_login_id);
		System.out.println(optionalCustomer);
		if(!optionalCustomer.isEmpty()) {
			Customer customer=optionalCustomer.get(0);
				if(customer.getCustomer_status().equalsIgnoreCase("inactive")){
				customer.setCustomer_status("active");
				customer.setLogin_attempts(0);
				registrationRepo.save(customer);
				return "Customer activated";
				}else {
					return "It is active only";
				}
		}
		return "false";
	}

	@Override
	public String approve(int accountId) {
		Optional<Account> optionalAccount = accountRepo.findById(accountId);
		if(optionalAccount.isPresent()) {
			Account account = optionalAccount.get();
			if(account.getAccountStatus().equalsIgnoreCase("inactive")){
				account.setAccountStatus("active");
				accountRepo.save(account);
				return "true";
			}else {
				return "Account already active";
			}
		}
		return "false";
		
	}
	
	
	

}
