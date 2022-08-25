package com.cognizant.ProcessPension;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.ProcessPension.controllerTest.ProcessPensionControllerTest;
import com.cognizant.ProcessPension.modelTest.ProcessPensionModelTest;
import com.cognizant.ProcessPension.serviceTest.ProcessPensionServiceTest;


@RunWith(Suite.class)
@SuiteClasses({ProcessPensionModelTest.class,ProcessPensionControllerTest.class,ProcessPensionServiceTest.class})

public class ProcessPensionApplicationTests {

	

}
