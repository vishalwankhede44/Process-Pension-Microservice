package com.cognizant.ProcessPension.controllerTest;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.ProcessPension.controller.ProcessPensionController;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ProcessPensionControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ProcessPensionController processPensionController;
	
	@Test
	public void contextLoads() {
//		assertNotNull(processPensionController);
	}
	
	@Test
	public void testWithValidAadhaar() throws Exception{
		ResultActions actions = mockMvc.
									perform(post("/processPension")
											.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJWaXNoYWwiLCJleHAiOjE2NjExNDcwMTgsImlhdCI6MTY2MTE0MzQxOH0.bCjfKWkzFY59Et9J2IW323k8jn1A6QVvve8wDA1VcvQ")
											.contentType(MediaType.APPLICATION_JSON)
											.content("{ \"aadhaarNumber\": 329612345677 }") );
		
		actions.andExpect(status().isOk());
	}
	
	@Test
	public void testWithInvalidAadhaar() throws Exception{
		ResultActions actions = mockMvc.
									perform(post("/processPension")
											.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJWaXNoYWwiLCJleHAiOjE2NjExNDcwMTgsImlhdCI6MTY2MTE0MzQxOH0.bCjfKWkzFY59Et9J2IW323k8jn1A6QVvve8wDA1VcvQ")
											.contentType(MediaType.APPLICATION_JSON)
											.content("{ \"aadhaarNumber\": 3296123456770 }") );
		
		actions.andExpect(status().isNotFound());
	}
	

	@Test
	public void testWithInvalidToken() throws Exception{
		ResultActions actions = mockMvc.
									perform(post("/processPension")
											.header("Authorization", "Bearer eyeeJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJWaXNoYWwiLCJleHAiOjE2NjExNDcwMTgsImlhdCI6MTY2MTE0MzQxOH0.bCjfKWkzFY59Et9J2IW323k8jn1A6QVvve8wDA1VcvQ")
											.contentType(MediaType.APPLICATION_JSON)
											.content("{ \"aadhaarNumber\": 329612345677 }") );
		
		actions.andExpect(status().isForbidden());
	}
}
