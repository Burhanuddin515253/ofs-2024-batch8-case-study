package com.ofss.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Transaction;
import com.ofss.main.repository.AccountRepo;
import com.ofss.main.repository.TransactionRepo;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	TransactionRepo transactionRepo;
	
	@Autowired
	AccountRepo accountRepo;
	
	@Override
	public String transact(Transaction transaction) {
		Optional<Account> optionalaccount1 = accountRepo.findById(transaction.getPayeeAccount().getAccountId());
		Optional<Account> optionalaccount2 = accountRepo.findById(transaction.getPayerAccount().getAccountId());
		if(optionalaccount1.isPresent() && optionalaccount2.isPresent()) {
			Account account1=optionalaccount1.get();
			Account account2=optionalaccount2.get();
			transaction.setPayeeAccount(account1);
			transaction.setPayerAccount(account2);
			System.out.println("transaction object is: "+transaction);
			transactionRepo.save(transaction);
			return "true";
		}
		return null;
	}
    

    
}
