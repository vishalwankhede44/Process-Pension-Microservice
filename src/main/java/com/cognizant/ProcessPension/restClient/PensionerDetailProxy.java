package com.cognizant.ProcessPension.restClient;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.ProcessPension.exception.PensionerNotFoundException;
import com.cognizant.ProcessPension.model.PensionerDetail;


//@FeignClient(name="pensioner-detail", url="localhost:8000")
@FeignClient(name="pensioner-detail", url="${pensioner_detail_uri}")
public interface PensionerDetailProxy {
	
	@GetMapping("/pensionerDetailByAadhar/{aadhaarNumber}")
	public PensionerDetail pensionerDetailsByAadhar(@RequestHeader("Authorization") String token,@PathVariable("aadhaarNumber") Long aadhaarNumber) throws PensionerNotFoundException;
}
