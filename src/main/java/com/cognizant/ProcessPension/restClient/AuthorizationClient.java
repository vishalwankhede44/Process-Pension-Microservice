package com.cognizant.ProcessPension.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.ProcessPension.exception.PensionerNotFoundException;

@FeignClient(name="authorizationService", url="${authorization_service_uri}")
public interface AuthorizationClient {
	
	@GetMapping("/validate")
	public ResponseEntity<?> authorization(@RequestHeader("Authorization") String token) throws PensionerNotFoundException;

	
}
