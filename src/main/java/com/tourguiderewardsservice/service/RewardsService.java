package com.tourguiderewardsservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguiderewardsservice.exception.RewardCentralException;
import com.tourguiderewardsservice.proxy.RewardCentralProxyImpl;

@Service
public class RewardsService {

	@Autowired
	private RewardCentralProxyImpl rewardCentralProxyImpl;
	
	public int getAttractionRewardPoints(UUID attractionId, UUID userId) throws RewardCentralException {
		return rewardCentralProxyImpl.getAttractionRewardPoints(attractionId, userId);
	}
}
