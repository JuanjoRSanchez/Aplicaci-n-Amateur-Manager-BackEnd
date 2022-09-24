package com.GestorPenas.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestorPenas.demo.Model.Pena;
import com.GestorPenas.demo.service.PenaService;

@RestController
@RequestMapping(path = "/pena")
public class PenaController {
	
	@Autowired
	private final PenaService penaService;

	@Autowired
	public PenaController(PenaService penaService) {
		super();
		this.penaService = penaService;
	}
	
	@GetMapping(value = "/")
	public List<Pena> getListPena(){
		List<Pena> aux = penaService.getPena();
		return aux;
	}
	
	@GetMapping(value = "/pena/{id}")
	public Pena getPena(@PathVariable("id") Long id){
		return penaService.getPenaById(id);
	}
	

	@PostMapping(value = "/add")
	public void setPena(@RequestBody Pena pena) {
		
		 penaService.setPena(pena);
	}
	/*
	@PutMapping
	public Pena updateUsuario(@RequestBody Pena pena) {
		return penaService.updateUsuario(pena);
	}
	*/
	@DeleteMapping(value = "/delete/{id}")
	public void deletePena(@PathVariable("id") Long id) {
		 penaService.deletePena(id);
	}
}
