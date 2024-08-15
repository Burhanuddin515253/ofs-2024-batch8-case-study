package com.ofss.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Cheque;

@Service
public interface AdminService {
    public String adminLogin(String admin_login_id, String admin_password);
    public String unblock(String customer_login_id);
//    public List<Account> getAccounts(int customer_id);
    public String approve(int accountId);
//    public List<Cheque> getCheques();
//    public String getAccountType(int account_id);
//    public String clearCheque(int cheque_id, boolean flag);
}
