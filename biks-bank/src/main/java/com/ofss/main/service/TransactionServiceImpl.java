package com.ofss.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;
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
		
		//GET PAYEE CUSTOMER
		Optional<Account> optionalaccount1 = accountRepo.findById(transaction.getPayeeAccount().getAccountId());
		if(optionalaccount1.isPresent()) {
			Account account1=optionalaccount1.get();
			double payee_new_balance =0;
			double balance = account1.getAccountBalance();
	        double min_balance = account1.getAccountMinimumBalance();
	        String account_type = account1.getAccountType();
	        double overdraft_amount = account1.getOverdraftAmount();
	        double amount = transaction.getTransactionAmount();
	        double new_amount = amount;
	        if(account_type.equalsIgnoreCase("savings")){
	            if(amount>0 && balance-amount >= min_balance){
	                payee_new_balance = balance - amount;
	            }else{
	                System.out.println("Transaction not possible beacause you dont have enough balance");
	                return null;
	            }
	        }else{
	            if(amount>0 && amount<balance){
	                payee_new_balance = balance-amount;
	            }
	            else if(amount>0 && amount>balance && amount<=balance+overdraft_amount){
	                new_amount=amount-balance;
	                payee_new_balance = 0;
	                overdraft_amount = overdraft_amount-new_amount;
	            }else{
	                System.out.println("Transaction not possible beacause you dont have enough balance");
	                return null;
	            }
	        }
	        //UPDATE PAYEE ACCOUNT
	        account1.setAccountBalance(payee_new_balance);
	        account1.setOverdraftAmount((int)overdraft_amount);
	        accountRepo.save(account1);
		}

          
      //GET PAYER CUSTOMER
		Optional<Account> optionalaccount2 = accountRepo.findById(transaction.getPayerAccount().getAccountId());
		if(optionalaccount2.isPresent()) {
			Account account2=optionalaccount2.get();
	        double payer_new_balance = 0 ;
	        double balance = account2.getAccountBalance();
	        String account_type = account2.getAccountType();
	        int payer_overdraft_amount = account2.getOverdraftAmount();
	        int initial_overdraft_balance = payer_overdraft_amount;
	        System.out.println("overdraft: "+initial_overdraft_balance);
	        double amount = transaction.getTransactionAmount();
	        double new_amount = amount;
	        System.out.println("new_amount"+amount);
	        if(account_type.equalsIgnoreCase("savings")){
	                payer_new_balance = balance + amount;
	                System.out.println("balance: "+balance+" amount: "+amount+"payer balance is: "+payer_new_balance);
	        }else{
	            if(amount>0 && initial_overdraft_balance>payer_overdraft_amount){
	                if(amount<(initial_overdraft_balance-payer_overdraft_amount)){
	                    payer_overdraft_amount += amount;
	                }else{
	                    new_amount = amount - initial_overdraft_balance - payer_overdraft_amount;
	                    payer_overdraft_amount = initial_overdraft_balance;
	                    payer_new_balance = balance + new_amount;
	                }
	            }else{
	                payer_new_balance = balance + amount;
	            }
	        }
	        //UPDATE PAYER ACCOUNT
	        account2.setAccountBalance(payer_new_balance);
	        account2.setOverdraftAmount((int)payer_overdraft_amount);
	        accountRepo.save(account2);
	        
		}

		//insert in transaction
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

	@Override
	public List<Transaction> listOfTransaction(int account_id) {
		Optional<Account> optionalaccount=accountRepo.findById(account_id);
		if(optionalaccount.isPresent()) {
			Account account = optionalaccount.get();
			List<Transaction> transactions=transactionRepo.findByPayeeAccount(account);
			System.out.println("List of transactions is: "+transactions);
			return transactions;
		}
		return null;
	}
	
	
    

    
}
