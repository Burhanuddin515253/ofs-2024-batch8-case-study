package com.ofss.main.repository;

import java.util.List;

import com.ofss.main.domain.*;
public interface AccountRepo {
    public boolean newAccount(int customer_id,String account_type, int overdraft_amount);
    public List<Account> getAccounts(int customer_id);
}
