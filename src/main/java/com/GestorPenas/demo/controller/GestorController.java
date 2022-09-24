package com.GestorPenas.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestorPenas.demo.Model.Gestor;
import com.GestorPenas.demo.service.GestorService;

@RestController
@RequestMapping(path = "/gestor")
public class GestorController {
	
	@Autowired
	private final GestorService gestorService;

	@Autowired
	public GestorController(GestorService gestorService) {
		super();
		this.gestorService = gestorService;
	}
	
	@GetMapping(value = "/")
	public List<Gestor> getGestores(){
		List<Gestor> aux = gestorService.getGestores();
		return aux;
	}
	
	@GetMapping(value = "/{id}")
	public Gestor getGestor(@PathVariable("id") Long id){
		return gestorService.getGestorById(id);
	}
	

	@PostMapping(value = "/add")
	public void setGestor(@RequestBody Gestor gestor) {
		gestorService.setGestor(gestor);
	}
	/*
	@PutMapping
	public Pena updateUsuario(@RequestBody Pena pena) {
		return penaService.updateUsuario(pena);
	}
	*/
	@DeleteMapping(value = "/delete/{id}")
	public void deleteGestor(@PathVariable("id") Long id) {
		gestorService.deleteGestor(id);
	}
	
	
	
}
