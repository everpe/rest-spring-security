package com.example.main.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.models.Persona;
import com.example.main.repo.IPersonaRepo;


/**
 * @Note el Controller llama al servicio y el serviocio se comunica con el repositorio
 * @author Ever
 *
 */
@RestController
@RequestMapping("/personas")//prefijo para las rutas del controller
public class RestDemoController {

	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping
	public List<Persona> listar(){
		//Esto lo debe de hacer el servicio
		return repo.findAll();
	} 
	
	
	/**
	 * Para enviar datos necesitamos postman 
	 * @param per, Instacia de Persona q viene de postman.
	 * @RequestBody captura datos Json y los convierte en una Intancia de Persona
	 */
	@PostMapping        
	public void create(@RequestBody Persona per) {
		repo.save(per);
	}
	
	
	/**
	 * El metodo save se adapta si encuentra la llave primaria lo modifica sino crea la entidad.
	 * No equivocarse con la llave primaria
	 * @param per
	 */
	@PutMapping        
	public String update(@RequestBody Persona per) {
		Persona persona= repo.save(per);
		if(persona!=null)
			return"Actualizado Correctamente";
		else
			return "No se pudó Actualizar";
	}
	
		
	/**
	 * Pasa el id de la URL por parametro para eleiminar.
	 * @param id de la persona q se desea eliminar, se pasa por URL.
	 */
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
	
	
	
	
	
}
