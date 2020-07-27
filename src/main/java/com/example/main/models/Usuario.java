package com.example.main.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity																															
public class Usuario {

	@Id
	private int idUsuario;
	private String userr;
	private String password;
	
	
	
	public int getId() {
		return idUsuario;
	}
	public void setIdUsuario(int id) {
		this.idUsuario = id;
	}
	public String getUser() {
		return userr;
	}
	public void setUser(String user) {
		this.userr = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
