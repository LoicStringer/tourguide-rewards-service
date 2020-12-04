package com.tourguiderewardsservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguiderewardsservice.proxy.RewardCentralProxy;

@Service
public class RewardsService {

	@Autowired
	private RewardCentralProxy rewardCentralProxy;
	
	public int getAttractionRewardPoints(UUID attractionId, UUID userId) {
		return rewardCentralProxy.getAttractionRewardPoints(attractionId, userId);
	}
}
