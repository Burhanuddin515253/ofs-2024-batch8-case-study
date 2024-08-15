package com.ofss.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.*;
@Repository
public interface AccountRepo extends CrudRepository<Account, Integer>{
	public List<Account> findByCustomer(Customer customer);
	public List<Account> findByCustomerAndAccountStatus(Customer customer,String status);
}
