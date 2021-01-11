package com.tourguiderewardsservice.proxy;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguiderewardsservice.exception.RewardCentralException;

import rewardCentral.RewardCentral;

@Service
public class RewardCentralProxyImpl implements IRewardCentralProxy {
	
	@Autowired
	private RewardCentral rewardCentral;

	@Override
	public int getAttractionRewardPoints(UUID attractionId, UUID userId) throws RewardCentralException {
		int attractionRewardPoints = rewardCentral.getAttractionRewardPoints(attractionId, userId);
		if(attractionRewardPoints==0)
			throw new RewardCentralException("A problem occured with external library \"RewardCentral\" : can't retrieve the attraction reward points.");
		return attractionRewardPoints;
	}
	
	

}
