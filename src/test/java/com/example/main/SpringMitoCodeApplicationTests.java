package com.example.main;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.main.models.Usuario;
import com.example.main.repo.IUsuarioRepo;

@SpringBootTest
class SpringMitoCodeApplicationTests {

	@Autowired
	private IUsuarioRepo repo;
	
	//se inyecta el bean de SecurityConfig para codificar la pasword
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	/**
	 * El test se ejecuta simple y crea un usuario en la bd para probar.
	 */
	@Test
	void crearUsuarioTest() {
		Usuario us= new Usuario();
		us.setIdUsuario(123);
		us.setUser("user3");
		us.setPassword(encoder.encode("1234"));
		Usuario retorno=repo.save(us);
		//Condicion para que sea un test
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
