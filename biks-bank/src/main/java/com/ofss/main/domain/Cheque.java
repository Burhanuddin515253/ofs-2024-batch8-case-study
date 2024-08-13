package com.ofss.main.domain;

import java.time.LocalDateTime;

public class Cheque {
    private int cheque_id;
    private String cheque_status;
    private Account cheque_payee_account;
    private Account cheque_payer_account;
    private double cheque_amount;
    private LocalDateTime cheque_date;

    
    
    
    public Cheque() {
    }

    public Cheque(int cheque_id, String cheque_status, Account cheque_payee_account, Account cheque_payer_account,
            double cheque_amount, LocalDateTime cheque_date) {
        this.cheque_id = cheque_id;
        this.cheque_status = cheque_status;
        this.cheque_payee_account = cheque_payee_account;
        this.cheque_payer_account = cheque_payer_account;
        this.cheque_amount = cheque_amount;
        this.cheque_date = cheque_date;
    }

    public Cheque(String cheque_status, Account cheque_payee_account, Account cheque_payer_account,
    double cheque_amount, LocalDateTime cheque_date) {
    this.cheque_status = cheque_status;
    this.cheque_payee_account = cheque_payee_account;
    this.cheque_payer_account = cheque_payer_account;
    this.cheque_amount = cheque_amount;
    this.cheque_date = cheque_date;
    }

    public int getCheque_id() {
        return cheque_id;
    }
    public void setCheque_id(int cheque_id) {
        this.cheque_id = cheque_id;
    }
    public String getCheque_status() {
        return cheque_status;
    }
    public void setCheque_status(String cheque_status) {
        this.cheque_status = cheque_status;
    }
    public Account getCheque_payee_account() {
        return cheque_payee_account;
    }
    public void setCheque_payee_account(Account cheque_payee_account) {
        this.cheque_payee_account = cheque_payee_account;
    }
    public Account getCheque_payer_account() {
        return cheque_payer_account;
    }
    public void setCheque_payer_account(Account cheque_payer_account) {
        this.cheque_payer_account = cheque_payer_account;
    }
    public double getCheque_amount() {
        return cheque_amount;
    }
    public void setCheque_amount(double cheque_amount) {
        this.cheque_amount = cheque_amount;
    }
    public LocalDateTime getCheque_date() {
        return cheque_date;
    }
    public void setCheque_date(LocalDateTime cheque_date) {
        this.cheque_date = cheque_date;
    }

    
}
