package com.cognizant.ProcessPension.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ProcessPension.model.PensionDetail;
import com.cognizant.ProcessPension.model.PensionerDetail;

import com.cognizant.ProcessPension.repository.PensionDetailRepository;
import com.cognizant.ProcessPension.util.Util;

@Service
public class ProcessPensionService {
	
	@Autowired
	private Util util;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessPensionService.class);
	
	@Autowired
	private PensionDetailRepository pensionDetailRepository;
	
	public PensionDetail calculatePension(PensionerDetail pensionerDetail){
		
		LOGGER.info("ProcessPensionService - calculatePensioner - Started - PensionerDetail -> {}",pensionerDetail);
		PensionDetail pensionDetail = new PensionDetail();
		double lastSalary;
		if(pensionerDetail.getIsSelfPension()){
			lastSalary = pensionerDetail.getLastSalaryEarned()*0.8;
		}else{
			lastSalary = pensionerDetail.getLastSalaryEarned()*0.5;
		}
		
		pensionDetail.setPensionAmount(lastSalary+pensionerDetail.getAllowances());
		
		if(pensionerDetail.getBankDetail().isPublicBank())
			pensionDetail.setBankServiceCharge(util.getPublicbankservicecharge());
		else
			pensionDetail.setBankServiceCharge(util.getPrivatebankservicecharge());
		
		pensionDetail.setAadhaarNumber(pensionerDetail.getAadhaarId());
		pensionDetailRepository.save(pensionDetail);
		LOGGER.info("ProcessPensionService - calculatePensioner - Ended - PensionerDetail -> {} , PensionDetail -> {} ",pensionerDetail,pensionDetail);
		
		return pensionDetail;
	}
}
