package com.ofss.main.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="admin_id")
    private int adminId;
	@Column(name="admin_name")
    private String adminName;
	@Column(name="admin_login_id")
    private String adminLoginId;
	@Column(name="admin_password")
    private String adminPassword;

	public Admin() {
		
	}

	public Admin(int adminId, String adminName, String adminLoginId, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminLoginId = adminLoginId;
		this.adminPassword = adminPassword;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminLoginId() {
		return adminLoginId;
	}

	public void setAdminLoginId(String adminLoginId) {
		this.adminLoginId = adminLoginId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminLoginId=" + adminLoginId
				+ ", adminPassword=" + adminPassword + "]";
	}
	
	
	
}

