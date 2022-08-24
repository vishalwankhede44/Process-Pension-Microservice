package com.cognizant.ProcessPension.util;

import org.springframework.stereotype.Component;

@Component
public class Util {
	private static final double PUBLIC_BANK_CHARGES  = 500.0;
	private static final double PRIVATE_BANK_CHARGES = 550.0;
	
	public static double getPublicbankservicecharge() {
		return PUBLIC_BANK_CHARGES;
	}

	public static double getPrivatebankservicecharge() {
		return PRIVATE_BANK_CHARGES;
	}
	

}
