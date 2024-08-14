package com.ofss.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Transaction;

@Service
public interface TransactionService {
    //public String transact(int payee_account_id, int payer_account_id, int amount, String type);
	public List<Transaction> listOfTransaction(int account_id);
	public String transact(Transaction t);
}
