package com.example.main.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.main.models.Persona;
import com.example.main.repo.IPersonaRepo;

@Controller
public class DemoController {
	
	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping("/saludo")  //parametros y si es obligatorio y default, Variable_Parametro,Modelo con los datos que requiera enviar a la vista       
	public String greeting( @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
		//Esta Logica es la que debe de hacer el Servicio.
		Persona persona=new Persona();
		persona.setIdPersona(3333);
		persona.setNombre("Luis P");
		repo.save(persona);
		
		model.addAttribute("name", name);
		return "Vista";//hace referencia a vista en templates Thymeleaf
	}
	
	
	/*Multiples Parametros por ruta 
	@GetMapping("/saludo/{name}/{lastname}")
	public String savePdf(@PathVariable("name") String name,@PathVariable("lastname") String lastname) throws FileNotFoundException {
		return"Vista";
	}*/    
	
	
	@GetMapping("/listar")
	public String greeting(Model model) {
		model.addAttribute("personas",repo.findAll());
		return "Vista";
	}
		
}
