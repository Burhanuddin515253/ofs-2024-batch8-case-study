package com.ofss.main.service;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Transaction;

@Service
public interface TransactionService {
    //public String transact(int payee_account_id, int payer_account_id, int amount, String type);
	public String transact(Transaction t);
}
