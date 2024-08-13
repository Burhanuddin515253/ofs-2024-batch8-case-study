package com.ofss.main.domain;

import java.time.LocalDateTime;

public class Transaction {
    private int transaction_id;
    private Account payee_account;
    private Account payer_account;
    private double transaction_amount;
    private String transaction_status;
    private String transaction_remarks;
    private LocalDateTime transaction_created_at;
    private LocalDateTime transaction_completed_at;
    private String transfer_type;
    private String transaction_type;

    public int getTransaction_id() {
        return transaction_id;
    }
    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }
    public Account getPayee_account() {
        return payee_account;
    }
    public void setPayee_account(Account payee_account) {
        this.payee_account = payee_account;
    }
    public Account getPayer_account() {
        return payer_account;
    }
    public void setPayer_account(Account payer_account) {
        this.payer_account = payer_account;
    }
    public double getTransaction_amount() {
        return transaction_amount;
    }
    public void setTransaction_amount(double transaction_amount) {
        this.transaction_amount = transaction_amount;
    }
    public String getTransaction_status() {
        return transaction_status;
    }
    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }
    public String getTransaction_remarks() {
        return transaction_remarks;
    }
    public void setTransaction_remarks(String transaction_remarks) {
        this.transaction_remarks = transaction_remarks;
    }
    public LocalDateTime getTransaction_created_at() {
        return transaction_created_at;
    }
    public void setTransaction_created_at(LocalDateTime transaction_created_at) {
        this.transaction_created_at = transaction_created_at;
    }
    public LocalDateTime getTransaction_completed_at() {
        return transaction_completed_at;
    }
    public void setTransaction_completed_at(LocalDateTime transaction_completed_at) {
        this.transaction_completed_at = transaction_completed_at;
    }
    public String getTransfer_type() {
        return transfer_type;
    }
    public void setTransfer_type(String transfer_type) {
        this.transfer_type = transfer_type;
    }
    public String getTransaction_type() {
        return transaction_type;
    }
    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    
}

