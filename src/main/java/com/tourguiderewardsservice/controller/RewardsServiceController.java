package com.tourguiderewardsservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tourguiderewardsservice.service.RewardsService;

@RestController
public class RewardsServiceController {

	@Autowired
	private RewardsService rewardsService;

	@GetMapping("/rewardPoints")
	public ResponseEntity<Integer> getAttractionRewardPoints
	(@RequestParam("attractionId") UUID attractionId, @RequestParam("userId")UUID userId) {
		return ResponseEntity.ok(rewardsService.getAttractionRewardPoints(attractionId, userId));
	}

}
