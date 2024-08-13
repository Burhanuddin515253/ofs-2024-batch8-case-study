package com.ofss.main.service;

import com.ofss.main.domain.Account;

public interface AccountService {
    public boolean newAccount(int customer_id,String account_type, int overdraft_amount);
}
