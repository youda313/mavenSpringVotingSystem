package com.matt.votingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matt.votingSystem.entity.Candidate;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Integer> {

	public Candidate findById(int id);
}
