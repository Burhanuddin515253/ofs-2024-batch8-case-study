package com.ofss.main.domain;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transaction_id")
    private int transactionId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payee_account_id")
    private Account payeeAccount;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payer_account_id")
    private Account payerAccount;
	@Column(name="transaction_amount")
    private double transactionAmount;
	@Column(name="transaction_status")
    private String transactionStatus;
	@Column(name="transaction_remarks")
    private String transactionRemarks;
	@Column(name="transaction_created_at")
    private LocalDateTime transactionCreatedAt;
	@Column(name="transaction_completed_at")
    private LocalDateTime transactionCompletedAt;
	@Column(name="transfer_type")
    private String transferType;
	@Column(name="transaction_type")
    private String transactionType;
	
	public Transaction() {
		
	}
	
	public Transaction(int transactionId, Account payeeAccount, Account payerAccount, double transactionAmount,
			String transactionStatus, String transactionRemarks, LocalDateTime transactionCreatedAt,
			LocalDateTime transactionCompletedAt, String transferType, String transactionType) {
		super();
		this.transactionId = transactionId;
		this.payeeAccount = payeeAccount;
		this.payerAccount = payerAccount;
		this.transactionAmount = transactionAmount;
		this.transactionStatus = transactionStatus;
		this.transactionRemarks = transactionRemarks;
		this.transactionCreatedAt = transactionCreatedAt;
		this.transactionCompletedAt = transactionCompletedAt;
		this.transferType = transferType;
		this.transactionType = transactionType;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Account getPayeeAccount() {
		return payeeAccount;
	}
	public void setPayeeAccount(Account payeeAccount) {
		this.payeeAccount = payeeAccount;
	}
	public Account getPayerAccount() {
		return payerAccount;
	}
	public void setPayerAccount(Account payerAccount) {
		this.payerAccount = payerAccount;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public String getTransactionRemarks() {
		return transactionRemarks;
	}
	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}
	public LocalDateTime getTransactionCreatedAt() {
		return transactionCreatedAt;
	}
	public void setTransactionCreatedAt(LocalDateTime transactionCreatedAt) {
		this.transactionCreatedAt = transactionCreatedAt;
	}
	public LocalDateTime getTransactionCompletedAt() {
		return transactionCompletedAt;
	}
	public void setTransactionCompletedAt(LocalDateTime transactionCompletedAt) {
		this.transactionCompletedAt = transactionCompletedAt;
	}
	public String getTransferType() {
		return transferType;
	}
	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transactionId + ", payeeAccount=" + payeeAccount + ", payerAccount="
				+ payerAccount + ", transactionAmount=" + transactionAmount + ", transactionStatus=" + transactionStatus
				+ ", transactionRemarks=" + transactionRemarks + ", transactionCreatedAt=" + transactionCreatedAt
				+ ", transactionCompletedAt=" + transactionCompletedAt + ", transferType=" + transferType
				+ ", transactionType=" + transactionType + "]";
	}
	
	
    
    
    
}

