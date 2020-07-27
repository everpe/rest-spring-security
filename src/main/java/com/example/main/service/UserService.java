package com.example.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.main.models.Usuario;
import com.example.main.repo.IUsuarioRepo;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private IUsuarioRepo repoUsu;
	
	/*
	 * Metodo de la interfaz.
	 * Va a buscar en la tabla de usuario para validar login
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usu= repoUsu.findByUserr(username);
		//Los roles se deberia tener un repositorio para roles y extraerlos de ahí de BD.
		List<GrantedAuthority>roles=new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		UserDetails userDet=new User(usu.getUser(),usu.getPassword(),roles);
		return userDet;
	}

}
