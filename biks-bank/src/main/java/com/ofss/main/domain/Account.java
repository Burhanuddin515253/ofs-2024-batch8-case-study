package com.ofss.main.domain;
import java.util.*; 

public class Account {
    private int account_id;
    private Customer customer;
    private String account_type;
    private double account_rate;
    private double account_balance;
    private double account_minimum_balance;
    private String account_status;
    private int overdraft_amount;

    

    

    public Account(int account_id) {
        this.account_id = account_id;
    }

    public Account(Customer customer, String account_type, double account_rate, double account_balance,
            double account_minimum_balance, String account_status, int overdraft_amount) {
        this.customer = customer;
        this.account_type = account_type;
        this.account_rate = account_rate;
        this.account_balance = account_balance;
        this.account_minimum_balance = account_minimum_balance;
        this.account_status = account_status;
        this.overdraft_amount = overdraft_amount;
    }

    public Account(int account_id, String account_type, double account_rate, double account_balance,
    double account_minimum_balance, String account_status, int overdraft_amount) {
        this.account_id = account_id;
        this.account_type = account_type;
        this.account_rate = account_rate;
        this.account_balance = account_balance;
        this.account_minimum_balance = account_minimum_balance;
        this.account_status = account_status;
        this.overdraft_amount = overdraft_amount;
}

    public int getAccount_id() {
        return account_id;
    }
    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
    public Customer getCustomer_id() {
        return customer;
    }
    public void setCustomer_id(Customer customer_id) {
        this.customer = customer_id;
    }
    public String getAccount_type() {
        return account_type;
    }
    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }
    public double getAccount_rate() {
        return account_rate;
    }
    public void setAccount_rate(double account_rate) {
        this.account_rate = account_rate;
    }
    public double getAccount_balance() {
        return account_balance;
    }
    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }
    public double getAccount_minimum_balance() {
        return account_minimum_balance;
    }
    public void setAccount_minimum_balance(double account_minimum_balance) {
        this.account_minimum_balance = account_minimum_balance;
    }
    public String getAccount_status() {
        return account_status;
    }
    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }
    public int getOverdraft_amount() {
        return overdraft_amount;
    }
    public void setOverdraft_amount(int overdraft_amount) {
        this.overdraft_amount = overdraft_amount;
    }

    

}

