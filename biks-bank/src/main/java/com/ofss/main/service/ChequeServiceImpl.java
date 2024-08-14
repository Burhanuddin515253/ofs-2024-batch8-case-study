package com.ofss.main.service;

import java.lang.StackWalker.Option;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Cheque;
import com.ofss.main.repository.AccountRepo;
import com.ofss.main.repository.ChequeRepo;

@Service
public class ChequeServiceImpl implements ChequeService{
	@Autowired
    ChequeRepo chequeRepo;
	@Autowired
    AccountRepo accountRepo;

	@Override
	public String createCheque(Cheque cheque) {
		Optional<Account> optionalaccount1 = accountRepo.findById(cheque.getChequePayeeAccount().getAccountId());
		Optional<Account> optionalaccount2 = accountRepo.findById(cheque.getChequePayerAccount().getAccountId());
		if(optionalaccount1.isPresent() && optionalaccount2.isPresent()) {
			Account account1 = optionalaccount1.get();
			Account account2 = optionalaccount2.get();
			cheque.setChequePayeeAccount(account1);
			cheque.setChequePayerAccount(account2);
			cheque.setChequeDate(LocalDateTime.now());
			cheque.setChequeStatus("issued");
			chequeRepo.save(cheque);
			return "true";
		}
		
		return null;
	}



	
	

    
}
