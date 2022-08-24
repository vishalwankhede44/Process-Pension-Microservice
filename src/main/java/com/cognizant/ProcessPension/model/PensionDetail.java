package com.cognizant.ProcessPension.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PensionDetail {
	private double pensionAmount;
	private double bankServiceCharge;
	
	@Id
	private Long aadhaarNumber;
	
	public PensionDetail(){}
	
	public PensionDetail(double pensionAmount, double bankServiceCharge) {
		super();
		this.pensionAmount = pensionAmount;
		this.bankServiceCharge = bankServiceCharge;
	}
	

	public PensionDetail(double pensionAmount, double bankServiceCharge, Long aadhaarNumber) {
		super();
		this.pensionAmount = pensionAmount;
		this.bankServiceCharge = bankServiceCharge;
		this.aadhaarNumber = aadhaarNumber;
	}

	public double getPensionAmount() {
		return pensionAmount;
	}

	public void setPensionAmount(double pensionAmount) {
		this.pensionAmount = pensionAmount;
	}

	public double getBankServiceCharge() {
		return bankServiceCharge;
	}

	public void setBankServiceCharge(double bankServiceCharge) {
		this.bankServiceCharge = bankServiceCharge;
	}


	public Long getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(Long aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	@Override
	public String toString() {
		return "PensionDetail [pensionAmount=" + pensionAmount + ", bankServiceCharge=" + bankServiceCharge
				+ ", aadhaarNumber=" + aadhaarNumber + "]";
	}	
	
	
}
