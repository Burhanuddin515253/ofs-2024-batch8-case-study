package com.ofss.main.repository;

import java.util.List;

import com.ofss.main.domain.*;

public interface AdminRepo {
    public String adminLogin(String admin_login_id, String admin_password);
    public String unblock(String customer_login_id);
    public List<Account> getAccounts(int customer_id);
    public String approve(Account account);
    public List<Cheque> getCheques();
    public String getAccountType(int account_id);
    public String clearCheque(int cheque_id, boolean flag);
}
