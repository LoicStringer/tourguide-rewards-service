package com.tourguiderewardsservice.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import com.tourguiderewardsservice.exception.RewardCentralException;
import com.tourguiderewardsservice.proxy.RewardCentralProxyImpl;

@SpringBootTest
@AutoConfigureMockMvc
class RewardsServiceTestIT {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RewardCentralProxyImpl rewardCentralProxyImpl;

	@Test
	void getAttractionRewardPointsIntegrationTest() throws Exception {
		when(rewardCentralProxyImpl.getAttractionRewardPoints(any(UUID.class), any(UUID.class))).thenReturn(100);
		mockMvc.perform(get("/"+UUID.randomUUID()+"/attractions/"+UUID.randomUUID()+"/reward-points"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").value(100));
	}

	@Test
	void isExpectedExceptionIsThrownWhenRewardCentralReturnsNull() throws Exception {
		when(rewardCentralProxyImpl.getAttractionRewardPoints(any(UUID.class), any(UUID.class))).thenThrow(RewardCentralException.class);
		mockMvc.perform(get("/"+UUID.randomUUID()+"/attractions/"+UUID.randomUUID()+"/reward-points"))
		.andExpect(status().isNotFound())
		.andExpect(result->assertTrue(result.getResolvedException() instanceof RewardCentralException));
	}
	
}
