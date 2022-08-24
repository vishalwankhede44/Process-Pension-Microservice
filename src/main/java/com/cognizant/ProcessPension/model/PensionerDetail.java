package com.cognizant.ProcessPension.model;


import java.text.SimpleDateFormat;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
public class PensionerDetail {

	private Long aadhaarId;
	private String name;
	private String pan;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dateOfBirth;
	private Double lastEarnedSalary,allowances;
	private Boolean isSelfPension;
	
	private BankDetail bankDetail;
	
	public PensionerDetail(){}

	public PensionerDetail(Long aadharId, String name, String pan, Date dateOfBirth, Double lastSalaryEarned,
			Double allowances, Boolean isSelfPension, BankDetail bankDetail) {
		super();
		this.aadhaarId = aadharId;
		this.name = name;
		this.pan = pan;
		this.dateOfBirth = dateOfBirth;
		this.lastEarnedSalary = lastSalaryEarned;
		this.allowances = allowances;
		this.isSelfPension = isSelfPension;
		this.bankDetail = bankDetail;
	}

	public Long getAadhaarId() {
		return aadhaarId;
	}

	public void setAadhaarId(Long aadhaarId) {
		this.aadhaarId = aadhaarId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Double getLastSalaryEarned() {
		return lastEarnedSalary;
	}

	public void setLastSalaryEarned(Double lastSalaryEarned) {
		this.lastEarnedSalary = lastSalaryEarned;
	}

	public Double getAllowances() {
		return allowances;
	}

	public void setAllowances(Double allowances) {
		this.allowances = allowances;
	}

	public Boolean getIsSelfPension() {
		return isSelfPension;
	}

	public void setIsSelfPension(Boolean isSelfPension) {
		this.isSelfPension = isSelfPension;
	}

	public BankDetail getBankDetail() {
		return bankDetail;
	}

	public void setBankDetail(BankDetail bankDetail) {
		this.bankDetail = bankDetail;
	}

	@Override
	public String toString() {
		return "PensionerDetail [aadhaarId=" + aadhaarId + ", name=" + name + ", pan=" + pan + ", dateOfBirth="
				+ dateOfBirth + ", lastSalaryEarned=" + lastEarnedSalary + ", allowances=" + allowances
				+ ", isSelfPension=" + isSelfPension + ", bankDetail=" + bankDetail + "]";
	}
	
	
	
	
	
}
