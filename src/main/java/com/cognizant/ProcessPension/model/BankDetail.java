package com.cognizant.ProcessPension.model;


public class BankDetail {

	private String bankName;
	private Long accountNumber;
	private Boolean isPublicBank;
	
	public BankDetail(){}
	
	public BankDetail(String bankName, Long accountNumber, Boolean isPublicBank) {
		super();
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.isPublicBank = isPublicBank;
	}
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Boolean isPublicBank() {
		return isPublicBank;
	}
	public void setIsPublicBank(Boolean isPublicBank) {
		this.isPublicBank = isPublicBank;
	}

	@Override
	public String toString() {
		return "BankDetail [bankName=" + bankName + ", accountNumber=" + accountNumber + ", isPublicBank="
				+ isPublicBank + "]";
	}
	
	
	
	
	
}
