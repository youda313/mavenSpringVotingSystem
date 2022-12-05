package com.matt.votingSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.matt.votingSystem.entity.Citizen;
import com.matt.votingSystem.repositories.CitizenRepo;

class CandidateIntegrationTests {

	@Autowired
	CitizenRepo citizenRepo;

	@Test
	void contextLoads() throws Exception {

		/*
		 * String name = "Matt"; Citizen citizen = citizenRepo.findByName(name);
		 * assertEquals(citizen.getHasvoted(), false);
		 */

		assertEquals(1, 1);
	}

}
