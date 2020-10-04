package com.github.leotsantos.apidemo.requests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.github.leotsantos.apidemo.domain.EventBody;
import com.google.gson.Gson;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void test01_resetStatus_shouldReturnOk() throws Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.post("/reset"))
	            .andExpect(MockMvcResultMatchers.status().isOk())
	            .andReturn()
	            .getResponse()
	            .getContentAsString();
	}
	
	@Test
	public void test02_getBalanceInvalidAccount_shouldReturnNotFound() throws Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/balance?account_id=1234"))
	            .andExpect(MockMvcResultMatchers.status().isNotFound())
	            .andReturn()
	            .getResponse()
	            .getContentAsString();
	}
	
	@Test
	public void test03_createAccountWithInitialBalance_shouldReturnOk() throws Exception {
		
		EventBody body = new EventBody("deposit", null, "100", 10);
		
		Gson gson = new Gson();
	    String json = gson.toJson(body);
		
		String response = mockMvc.perform(MockMvcRequestBuilders.post("/event")
				.contentType(MediaType.APPLICATION_JSON)
	            .content(json))
				.andExpect(MockMvcResultMatchers.status().isOk())
	            .andReturn()
	            .getResponse()
	            .getContentAsString();	
		
		Assert.assertEquals("{\"destination\":{\"id\":\"100\",\"balance\":10}}", response);
	}
	
	@Test
	public void test04_makeDepositOnExistingAccount_shouldReturnOk() throws Exception {
		
		EventBody body = new EventBody("deposit", null, "100", 10);
		
		Gson gson = new Gson();
	    String json = gson.toJson(body);
		
		String response = mockMvc.perform(MockMvcRequestBuilders.post("/event")
				.contentType(MediaType.APPLICATION_JSON)
	            .content(json))
				.andExpect(MockMvcResultMatchers.status().isOk())
	            .andReturn()
	            .getResponse()
	            .getContentAsString();	
		
		Assert.assertEquals("{\"destination\":{\"id\":\"100\",\"balance\":20}}", response);
	}
	
	@Test
	public void test05_getBalanceForExistingAccount_shouldReturnOk() throws Exception {
		
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/balance?account_id=100"))
				.andExpect(MockMvcResultMatchers.status().isOk())
	            .andReturn()
	            .getResponse()
	            .getContentAsString();	
		
		Assert.assertEquals("20", response);
	}
	
	@Test
	public void test06_makeWithdrawOnNonExistingAccount_shouldReturnNotFound() throws Exception {
		
		EventBody body = new EventBody("withdraw", "200", null, 10);
		
		Gson gson = new Gson();
	    String json = gson.toJson(body);
		
		String response = mockMvc.perform(MockMvcRequestBuilders.post("/event")
				.contentType(MediaType.APPLICATION_JSON)
	            .content(json))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
	            .andReturn()
	            .getResponse()
	            .getContentAsString();	
	}

}
