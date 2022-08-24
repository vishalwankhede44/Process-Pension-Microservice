package com.cognizant.ProcessPension.modelTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.ProcessPension.model.BankDetail;
import com.cognizant.ProcessPension.model.PensionDetail;
import com.cognizant.ProcessPension.model.PensionerDetail;
import com.cognizant.ProcessPension.model.ProcessPensionInput;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProcessPensionModelTest {

	@Test
	public void testBankDetailModel(){
		BeanTester beanTester = new BeanTester();
		beanTester.getFactoryCollection();
		beanTester.testBean(BankDetail.class);
	}
	
	@Test
	public void testPensionDetailModel(){
		BeanTester beanTester = new BeanTester();
		beanTester.getFactoryCollection();
		beanTester.testBean(PensionerDetail.class);
	}
	
	@Test
	public void testPensionerDetailModel(){
		BeanTester beanTester = new BeanTester();
		beanTester.getFactoryCollection();
		beanTester.testBean(PensionDetail.class);
	}
	
	@Test
	public void testProcessPensionInputModel(){
		BeanTester beanTester = new BeanTester();
		beanTester.getFactoryCollection();
		beanTester.testBean(ProcessPensionInput.class);
	}
	
}
