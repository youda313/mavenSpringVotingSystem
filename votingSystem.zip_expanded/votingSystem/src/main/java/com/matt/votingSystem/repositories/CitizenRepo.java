package com.matt.votingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matt.votingSystem.entity.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Integer>{

	public Citizen findByName(String name);
	
	
}
