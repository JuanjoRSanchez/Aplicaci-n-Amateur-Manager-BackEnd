package com.GestorPenas.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestorPenas.demo.Model.Partido;
import com.GestorPenas.demo.service.PartidoService;

@RestController
@RequestMapping(path = "/partido")
public class PartidoController {

	@Autowired
	private final PartidoService partidoService;

	@Autowired
	public PartidoController(PartidoService partidoService) {
		super();
		this.partidoService = partidoService;
	}
	
	@GetMapping(value = "/id")
	public Optional <Partido> getPartidoById(@PathVariable("id") Long id) {
		
		return partidoService.getPartido(id);
	}
	
	@GetMapping(value = "/")
	public List<Partido> getPartidos(){
		
		return partidoService.getPartidos();
	}
	
}
