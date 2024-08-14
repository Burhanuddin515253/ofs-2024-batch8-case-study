package com.ofss.main.domain;
import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table; 

@Entity
@Table(name="Account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
    private int accountId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
    private Customer customer;
	@Column(name="account_type")
    private String accountType;
	@Column(name="account_rate")
    private double accountRate;
	@Column(name="account_balance")
    private double accountBalance;
	@Column(name="account_minimum_balance")
    private double accountMinimumBalance;
	@Column(name="account_status")
    private String accountStatus;
	@Column(name="overdraft_amount")
    private int overdraftAmount;
	
	public Account() {
		
	}
	
	public Account(int accountId, Customer customer, String accounType, double accountRate, double accountBalance,
			double accountMinimumBalance, String accountStatus, int overdraftAmount) {
		super();
		this.accountId = accountId;
		this.customer = customer;
		this.accountType = accounType;
		this.accountRate = accountRate;
		this.accountBalance = accountBalance;
		this.accountMinimumBalance = accountMinimumBalance;
		this.accountStatus = accountStatus;
		this.overdraftAmount = overdraftAmount;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accounType) {
		this.accountType = accounType;
	}

	public double getAccountRate() {
		return accountRate;
	}

	public void setAccountRate(double accountRate) {
		this.accountRate = accountRate;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double getAccountMinimumBalance() {
		return accountMinimumBalance;
	}

	public void setAccountMinimumBalance(double accountMinimumBalance) {
		this.accountMinimumBalance = accountMinimumBalance;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public int getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(int overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", customer=" + customer + ", accountType=" + accountType
				+ ", accountRate=" + accountRate + ", accountBalance=" + accountBalance + ", accountMinimumBalance="
				+ accountMinimumBalance + ", accountStatus=" + accountStatus + ", overdraftAmount=" + overdraftAmount
				+ "]";
	}
	
	
	
	
	
	
	
    

    

}
    
    
    

