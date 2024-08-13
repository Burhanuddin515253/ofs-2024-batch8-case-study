package com.ofss.main.service;

import com.ofss.main.repository.TransactionRepo;
import com.ofss.main.repository.TransactionRepoImpl;

public class TransactionServiceImpl implements TransactionService{
    private TransactionRepo transactionService = new TransactionRepoImpl();
    @Override
    public String transact(int payee_account_id, int payer_account_id, int amount, String type) {
        return transactionService.transact(payee_account_id, payer_account_id, amount, type);
    }

    
}
