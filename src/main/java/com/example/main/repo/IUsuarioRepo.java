package com.example.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.models.Usuario;



public interface IUsuarioRepo extends JpaRepository<Usuario,Integer> {

	//Consulta para encontrar usuario por su nombre
	//Equivalente a Select * From usuario where userr=?
	Usuario findByUserr(String userr);	
}
