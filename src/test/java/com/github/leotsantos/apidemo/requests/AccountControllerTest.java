package com.github.leotsantos.apidemo.requests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void getBalanceInvalidAccount_shouldReturnNotFound() throws Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/balance?account_id=1234"))
	            .andExpect(MockMvcResultMatchers.status().isNotFound())
	            .andReturn()
	            .getResponse()
	            .getContentAsString();
	}

}
