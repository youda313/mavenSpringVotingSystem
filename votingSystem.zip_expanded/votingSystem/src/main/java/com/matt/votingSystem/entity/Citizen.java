package com.matt.votingSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "citizens")
public class Citizen {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "citizen_name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Citizen(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Citizen() {
		super();

	}
	
	@Column(name="hasvoted")
	private Boolean hasvoted;

	public Boolean getHasvoted() {
		return hasvoted;
	}

	public void setHasvoted(Boolean hasvoted) {
		this.hasvoted = hasvoted;
	}
	
}
