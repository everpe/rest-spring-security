package com.example.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.models.Persona;

public interface IPersonaRepo extends JpaRepository<Persona,Integer> {

	
	
}
