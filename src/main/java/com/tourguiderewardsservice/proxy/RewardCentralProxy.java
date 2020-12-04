package com.tourguiderewardsservice.proxy;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rewardCentral.RewardCentral;

@Service
public class RewardCentralProxy implements IRewardCentralProxy {
	
	@Autowired
	private RewardCentral rewardCentral;

	@Override
	public int getAttractionRewardPoints(UUID attractionId, UUID userId) {
		return rewardCentral.getAttractionRewardPoints(attractionId, userId);
	}
	
	

}
