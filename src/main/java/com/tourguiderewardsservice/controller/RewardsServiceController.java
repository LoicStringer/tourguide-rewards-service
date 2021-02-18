package com.tourguiderewardsservice.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tourguiderewardsservice.exception.RewardCentralException;
import com.tourguiderewardsservice.service.RewardsService;

@RestController
public class RewardsServiceController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RewardsService rewardsService;

	@GetMapping("/{userId}/attractions/{attractionId}/reward-points")
	public ResponseEntity<Integer> getAttractionRewardPoints
	(@PathVariable UUID userId, @PathVariable UUID attractionId) throws RewardCentralException {
		log.info("Querying Reward Central external library to get reward points corresponding to the attraction "+attractionId);
		return ResponseEntity.ok(rewardsService.getAttractionRewardPoints(attractionId, userId));
	}

}
