package com.matt.votingSystem.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.matt.votingSystem.entity.Candidate;
import com.matt.votingSystem.entity.Citizen;
import com.matt.votingSystem.repositories.CandidateRepo;
import com.matt.votingSystem.repositories.CitizenRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class VotingController {

	public final Logger logger = Logger.getLogger(VotingController.class.getName());
	
	@Autowired
	CitizenRepo citizenRepo;

	@Autowired
	CandidateRepo candidateRepo;

	@RequestMapping("/")
	public String goToVote() {
		
		logger.info("Returning vote.html file");
		return "vote.html";
	}

	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam String name, Model model, HttpSession session) {

		logger.info("getting citizen from database");
		Citizen citizen = citizenRepo.findByName(name);
		session.setAttribute("citizen", citizen);
		
		if (!citizen.getHasvoted()) {
			List<Candidate> candidates = candidateRepo.findAll();
			model.addAttribute("candidates",candidates);
			
			
			return "/performVote.html";
		}
		else {
			return "/alreadyVoted.html";
		}
	}
	
	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Integer id, HttpSession session) {
		
		Citizen citizen = (Citizen)session.getAttribute("citizen");
		
		if(!citizen.getHasvoted()) {
			citizen.setHasvoted(true);
			
			Candidate c = candidateRepo.findById((int)id);
			c.setNumberOfVotes(c.getNumberOfVotes()+1);
			candidateRepo.save(c);
			citizenRepo.save(citizen);
			return "/voted.html";
		}
		
		return "/alreadyVoted.html"; 
		
		
		
	}
	
	
}
