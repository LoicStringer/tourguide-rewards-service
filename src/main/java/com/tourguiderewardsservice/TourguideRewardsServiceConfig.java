package com.tourguiderewardsservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rewardCentral.RewardCentral;

@Configuration
public class TourguideRewardsServiceConfig {
	
	@Bean
	public RewardCentral getRewardCentral() {
		return new RewardCentral();
	}

}
