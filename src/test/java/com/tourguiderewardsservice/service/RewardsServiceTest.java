package com.tourguiderewardsservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tourguiderewardsservice.exception.RewardCentralException;
import com.tourguiderewardsservice.proxy.RewardCentralProxyImpl;

@ExtendWith(MockitoExtension.class)
class RewardsServiceTest {

	@Mock
	private RewardCentralProxyImpl rewardCentralProxyImpl;
	
	@InjectMocks
	private RewardsService rewardService;
	
	@Test
	void getAttractionRewardPointsTest() throws RewardCentralException {
		when(rewardCentralProxyImpl.getAttractionRewardPoints(any(UUID.class), any(UUID.class))).thenReturn(100);
		assertEquals(100, rewardService.getAttractionRewardPoints(UUID.randomUUID(), UUID.randomUUID()));
	}

	@Test
	void isExpectedExceptionThrownWhenAttractionRewardPointsIsNotFound() throws RewardCentralException{
		when(rewardCentralProxyImpl.getAttractionRewardPoints(any(UUID.class), any(UUID.class))).thenThrow(RewardCentralException.class);
		assertThrows(RewardCentralException.class, ()->rewardService.getAttractionRewardPoints(UUID.randomUUID(), UUID.randomUUID()));
	}
}
