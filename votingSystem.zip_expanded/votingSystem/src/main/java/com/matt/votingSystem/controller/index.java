package com.matt.votingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matt.votingSystem.entity.Candidate;
import com.matt.votingSystem.entity.Citizen;
import com.matt.votingSystem.repositories.CandidateRepo;
import com.matt.votingSystem.repositories.CitizenRepo;

@RestController
public class index {

	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	
	@RequestMapping("/doAction")
	public String doAction() {
		
		//populate the database
		Citizen t = new Citizen((long)1,"Bob");
		t.setHasvoted(false);
		citizenRepo.save(t);
		
		Candidate c1 = new Candidate((long)1,"c1");
		Candidate c2 = new Candidate((long)2,"c2");
		candidateRepo.save(c1);
		candidateRepo.save(c2);
		
		return "Success";
	}
}
