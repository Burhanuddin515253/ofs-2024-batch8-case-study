package com.ofss.main.domain;

import java.time.LocalDateTime;

public class FixedDeposit {
    private int deposit_id;
    private Account account_id;
    private double deposit_amount;
    private float deposit_rate;
    private LocalDateTime deposit_created_at;
    private LocalDateTime deposit_expires_at;
    private String deposit_type;
    
    public int getDeposit_id() {
        return deposit_id;
    }
    public void setDeposit_id(int deposit_id) {
        this.deposit_id = deposit_id;
    }
    public Account getAccount_id() {
        return account_id;
    }
    public void setAccount_id(Account account_id) {
        this.account_id = account_id;
    }
    public double getDeposit_amount() {
        return deposit_amount;
    }
    public void setDeposit_amount(double deposit_amount) {
        this.deposit_amount = deposit_amount;
    }
    public float getDeposit_rate() {
        return deposit_rate;
    }
    public void setDeposit_rate(float deposit_rate) {
        this.deposit_rate = deposit_rate;
    }
    public LocalDateTime getDeposit_created_at() {
        return deposit_created_at;
    }
    public void setDeposit_created_at(LocalDateTime deposit_created_at) {
        this.deposit_created_at = deposit_created_at;
    }
    public LocalDateTime getDeposit_expires_at() {
        return deposit_expires_at;
    }
    public void setDeposit_expires_at(LocalDateTime deposit_expires_at) {
        this.deposit_expires_at = deposit_expires_at;
    }
    public String getDeposit_type() {
        return deposit_type;
    }
    public void setDeposit_type(String deposit_type) {
        this.deposit_type = deposit_type;
    }

    

}
