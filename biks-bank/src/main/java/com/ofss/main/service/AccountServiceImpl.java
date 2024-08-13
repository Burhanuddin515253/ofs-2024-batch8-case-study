package com.ofss.main.service;


import com.ofss.main.repository.*;

public class AccountServiceImpl implements AccountService{
    private AccountRepo accountRepository= new AccountRepoImpl();
    @Override
    public boolean newAccount(int customer_id, String account_type, int overdraft_amount) {
        return accountRepository.newAccount(customer_id, account_type,overdraft_amount);
    }

    

    

    
}
