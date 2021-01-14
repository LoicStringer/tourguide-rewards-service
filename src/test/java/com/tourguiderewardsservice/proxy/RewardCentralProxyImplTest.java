package com.tourguiderewardsservice.proxy;

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

import rewardCentral.RewardCentral;

@ExtendWith(MockitoExtension.class)
class RewardCentralProxyImplTest {

	@InjectMocks
	private RewardCentralProxyImpl rewardCentralProxyImpl;
	
	@Mock
	private RewardCentral rewardCentral;
	
	@Test
	void getAttractionReawardPointsTest() throws RewardCentralException {
		when(rewardCentral.getAttractionRewardPoints(any(UUID.class),any(UUID.class))).thenReturn(100);
		assertEquals(100, rewardCentralProxyImpl.getAttractionRewardPoints(UUID.randomUUID(), UUID.randomUUID()));
	}

	@Test
	void isExpectedExceptionThrownWhenRewardCentralReturnsNull(){
		when(rewardCentral.getAttractionRewardPoints(any(UUID.class),any(UUID.class))).thenReturn(0);
		assertThrows(RewardCentralException.class,()->rewardCentralProxyImpl.getAttractionRewardPoints(UUID.randomUUID(), UUID.randomUUID()));
	}
	
}
