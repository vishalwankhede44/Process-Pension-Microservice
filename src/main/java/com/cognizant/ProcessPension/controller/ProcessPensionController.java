package com.cognizant.ProcessPension.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.ProcessPension.exception.BadRequestException;
import com.cognizant.ProcessPension.exception.CustomException;
import com.cognizant.ProcessPension.exception.PensionerNotFoundException;
import com.cognizant.ProcessPension.model.PensionDetail;
import com.cognizant.ProcessPension.model.PensionerDetail;
import com.cognizant.ProcessPension.model.ProcessPensionInput;
import com.cognizant.ProcessPension.restClient.AuthorizationClient;
import com.cognizant.ProcessPension.restClient.PensionerDetailProxy;
import com.cognizant.ProcessPension.service.ProcessPensionService;


@RestController
@CrossOrigin
public class ProcessPensionController {
	
	@Autowired
	private PensionerDetailProxy pensionerDetailProxy;
	 
	@Autowired
	private ProcessPensionService processPensionService;
	
	@Autowired
	private AuthorizationClient authorizationClient;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessPensionController.class);
	
	@PostMapping(path="/processPension",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public PensionDetail processPension(@RequestHeader("Authorization") String token,@RequestBody ProcessPensionInput processPensionInput) throws Exception{
		
		LOGGER.info("ProcessPensionController - processPension - Started  (ProcessPensionInput) -> {} ",processPensionInput); 
		
		//validate input parameter
		if(processPensionInput.getAadhaarNumber()==null){
			LOGGER.info("ProcessPensionController - processPension - Ended with BadRequestException (Aadhar parameter is required)  (ProcessPensionInput) -> {} ",processPensionInput); 
			throw new BadRequestException("aadhaarNumber parameter is required");
		}
		
		
		  try{
			if(authorizationClient.authorization(token).getStatusCode() == HttpStatus.OK){
				try{
				
					PensionerDetail pensionerDetail = pensionerDetailProxy.pensionerDetailsByAadhar(token,processPensionInput.getAadhaarNumber());
					PensionDetail pensionDetail = processPensionService.calculatePension(pensionerDetail);
					LOGGER.info("ProcessPensionController - processPension - Ended Successfully  (ProcessPensionInput) -> {} ,  PensionerDetail -> {} , PensionDetail-> {} ",processPensionInput,pensionerDetail,pensionDetail); 
					return pensionDetail;
				}catch(Exception e){
					throw new PensionerNotFoundException("Invalid pensioner detail provided, please provide valid detail");
				}
			}
		  }catch(PensionerNotFoundException pne){
			  LOGGER.info("ProcessPensionController - processPension - Ended with PensionerNotFoundException  (ProcessPensionInput) -> {} ",processPensionInput);
			  throw pne;
		  }catch(Exception e){
			  LOGGER.info("ProcessPensionController - processPension - Ended with Exception (Invalid Token)  (ProcessPensionInput) -> {} ",processPensionInput);
			  throw new CustomException("Invalid Token");
		  }
			return null;
			
	}
	
	
}
