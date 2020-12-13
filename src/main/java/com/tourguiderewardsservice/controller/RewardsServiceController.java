package com.tourguiderewardsservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tourguiderewardsservice.service.RewardsService;

@RestController
public class RewardsServiceController {

	@Autowired
	private RewardsService rewardsService;

	@GetMapping("{userId}/attractions/{attractionId}/reward-points")
	public ResponseEntity<Integer> getAttractionRewardPoints
	(@PathVariable("userId")UUID userId,@PathVariable("attractionId") UUID attractionId) {
		return ResponseEntity.ok(rewardsService.getAttractionRewardPoints(attractionId, userId));
	}

}
