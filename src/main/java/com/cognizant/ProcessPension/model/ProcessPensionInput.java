package com.cognizant.ProcessPension.model;

public class ProcessPensionInput {
    private Long aadhaarNumber;
     
    public ProcessPensionInput(){} 

	public ProcessPensionInput(Long aadhaarNumber) {
		super();
		this.aadhaarNumber = aadhaarNumber;
	}

	public Long getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(Long aadharNumber) {
		this.aadhaarNumber = aadharNumber;
	}

	@Override
	public String toString() {
		return "ProcessPensionInput [aadhaarNumber=" + aadhaarNumber + "]";
	}
	 
}
