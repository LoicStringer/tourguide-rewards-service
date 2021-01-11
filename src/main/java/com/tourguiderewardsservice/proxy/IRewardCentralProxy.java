package com.tourguiderewardsservice.proxy;

import java.util.UUID;

public interface IRewardCentralProxy {

	int getAttractionRewardPoints(UUID attractionId,UUID userId) throws Exception;
}
