package com.cognizant.ProcessPension.serviceTest;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.ProcessPension.model.BankDetail;
import com.cognizant.ProcessPension.model.PensionDetail;
import com.cognizant.ProcessPension.model.PensionerDetail;
import com.cognizant.ProcessPension.service.ProcessPensionService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProcessPensionServiceTest {

	@Autowired
	private ProcessPensionService processPensionService;
	
	@Test
	public void contextLoads() {
		assertNotNull(processPensionService);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void validCalculatePension() throws ParseException{
		BankDetail bankDetail = new BankDetail("HDFC",23456789l,false);
		PensionerDetail pensionerDetail = new PensionerDetail(329612345677l,"Abbi","ABCD1231A",new SimpleDateFormat("dd-mm-yyyy").parse("01-04-1990"),30000.0,2000.0,true,bankDetail);
		PensionDetail pensionDetail = processPensionService.calculatePension(pensionerDetail);
		assertEquals(26000.0, pensionDetail.getPensionAmount(),0.01);
		assertEquals(550,pensionDetail.getBankServiceCharge(),0);
	}
}
