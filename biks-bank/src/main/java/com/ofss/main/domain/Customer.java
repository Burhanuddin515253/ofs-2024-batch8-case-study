package com.ofss.main.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Customer")

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
    private int customer_id;
	@Column(name="customer_name")
    private String customer_name;
	@Column(name="customer_email")
	@JsonProperty
    private String customer_email;
	@Column(name="customer_login_id")
    private String customerLoginId;
	@Column(name="customer_password")
    private String customer_password;
	@Column(name="customer_phone")
    private String customer_phone;
	@Column(name="customer_address")
    private String customer_address;
	@Column(name="customer_status")
    private String customer_status;
	@Column(name="customer_state")
    private String customer_state;
	@Column(name="login_attempts")
    private int login_attempts;
	@Column(name="customer_country")
    private String customer_country;
    
    public Customer(){

    }
    

    
    public Customer(String customer_name, String customer_email, String customer_login_id, String customer_password,
            String customer_phone, String customer_address, String customer_state, String customer_country) {
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        customerLoginId = customer_login_id;
        this.customer_password = customer_password;
        this.customer_phone = customer_phone;
        this.customer_address = customer_address;
        this.customer_state = customer_state;
        this.customer_country = customer_country;
    }
    
//    public Customer(String customer_login_id, String customer_password) {
//    	customerLoginId = customer_login_id;
//        this.customer_password = customer_password;
//    }
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public String getCustomer_name() {
        return customer_name;
    }
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
    public String getEmail() {
        return customer_email;
    }
    public void setEmail(String customer_email) {
        this.customer_email = customer_email;
    }
    public String getCustomerLoginId() {
        return customerLoginId;
    }
    public void setCustomer_login_id(String customer_login_id) {
        this.customerLoginId = customer_login_id;
    }
    public String getCustomer_password() {
        return customer_password;
    }
    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }
    public String getCustomer_phone() {
        return customer_phone;
    }
    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }
    public String getCustomer_address() {
        return customer_address;
    }
    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }
    public String getCustomer_status() {
        return customer_status;
    }
    public void setCustomer_status(String customer_status) {
        this.customer_status = customer_status;
    }
    public String getCustomer_state() {
        return customer_state;
    }
    public void setCustomer_state(String customer_state) {
        this.customer_state = customer_state;
    }
    public int getLogin_attempts() {
        return login_attempts;
    }
    public void setLogin_attempts(int login_attempts) {
        this.login_attempts = login_attempts;
    }
    public String getCustomer_country() {
        return customer_country;
    }
    public void setCustomer_country(String customer_country) {
        this.customer_country = customer_country;
    }



	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_email="
				+ customer_email + ", customerLoginId=" + customerLoginId + ", customer_password=" + customer_password
				+ ", customer_phone=" + customer_phone + ", customer_address=" + customer_address + ", customer_status="
				+ customer_status + ", customer_state=" + customer_state + ", login_attempts=" + login_attempts
				+ ", customer_country=" + customer_country + "]";
	}
    
    

    
}
