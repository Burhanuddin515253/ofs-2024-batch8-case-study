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
@Table(name="Cheque")
public class Cheque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cheque_id")
    private int chequeId;
	@Column(name="cheque_status")
    private String chequeStatus;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payee_account_id")
    private Account chequePayeeAccount;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payer_account_id")
    private Account chequePayerAccount;
    @Column(name="cheque_amount")
    private Double chequeAmount;
    @Column(name="cheque_date")
    private LocalDateTime chequeDate;

    public Cheque() {
    }

	public Cheque(int chequeId, String chequeStatus, Account chequePayeeAccount, Account chequePayerAccount,
			Double chequeAmount, LocalDateTime chequeDate) {
		super();
		this.chequeId = chequeId;
		this.chequeStatus = chequeStatus;
		this.chequePayeeAccount = chequePayeeAccount;
		this.chequePayerAccount = chequePayerAccount;
		this.chequeAmount = chequeAmount;
		this.chequeDate = chequeDate;
	}

	public int getChequeId() {
		return chequeId;
	}

	public void setChequeId(int chequeId) {
		this.chequeId = chequeId;
	}

	public String getChequeStatus() {
		return chequeStatus;
	}

	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}

	public Account getChequePayeeAccount() {
		return chequePayeeAccount;
	}

	public void setChequePayeeAccount(Account chequePayeeAccount) {
		this.chequePayeeAccount = chequePayeeAccount;
	}

	public Account getChequePayerAccount() {
		return chequePayerAccount;
	}

	public void setChequePayerAccount(Account chequePayerAccount) {
		this.chequePayerAccount = chequePayerAccount;
	}

	public Double getChequeAmount() {
		return chequeAmount;
	}

	public void setChequeAmount(Double chequeAmount) {
		this.chequeAmount = chequeAmount;
	}

	public LocalDateTime getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(LocalDateTime chequeDate) {
		this.chequeDate = chequeDate;
	}

	@Override
	public String toString() {
		return "Cheque [chequeId=" + chequeId + ", chequeStatus=" + chequeStatus + ", chequePayeeAccount="
				+ chequePayeeAccount + ", chequePayerAccount=" + chequePayerAccount + ", chequeAmount=" + chequeAmount
				+ ", chequeDate=" + chequeDate + "]";
	}
   
}
