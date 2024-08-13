package com.ofss.main.service;

import java.util.List;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Cheque;
import com.ofss.main.repository.AdminRepo;
import com.ofss.main.repository.AdminRepoImpl;

public class AdminServiceImpl implements AdminService{
    private AdminRepo adminRepository= new AdminRepoImpl();
    public String adminLogin(String customer_login_id, String customer_password) {
        return adminRepository.adminLogin(customer_login_id,customer_password);
    }
    @Override
    public String unblock(String customer_login_id) {
        return adminRepository.unblock(customer_login_id);
    }
    @Override
    public List<Account> getAccounts(int customer_id) {
        return adminRepository.getAccounts(customer_id);
    }
    @Override
    public String approve(Account account) {
        return adminRepository.approve(account);
    }
    @Override
    public List<Cheque> getCheques() {
        return adminRepository.getCheques();
    }
    @Override
    public String getAccountType(int account_id) {
        return adminRepository.getAccountType(account_id);
    }
    @Override
    public String clearCheque(int cheque_id, boolean flag) {
        return adminRepository.clearCheque(cheque_id, flag);
    }   
}
