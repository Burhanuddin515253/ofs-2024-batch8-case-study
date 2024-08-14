package com.ofss.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;

@Service
public interface AccountService {
    //public boolean newAccount(int customer_id,String account_type, int overdraft_amount);
    public List<Account> listOfAccount(int customer_id);
    public String createAccount(Account account);
}
