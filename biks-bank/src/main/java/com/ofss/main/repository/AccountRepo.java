package com.ofss.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.*;
@Repository
public interface AccountRepo extends CrudRepository<Account, Integer>{
//    public boolean newAccount(int customer_id,String account_type, int overdraft_amount);
//    public List<Account> getAccounts(int customer_id);
	public List<Account> findByCustomer(Customer customer);
}
