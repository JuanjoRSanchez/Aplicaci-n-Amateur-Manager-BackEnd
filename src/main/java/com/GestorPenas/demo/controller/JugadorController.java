
package com.GestorPenas.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestorPenas.demo.DTO.AddJugadorDTO;
import com.GestorPenas.demo.Model.Jugador;
import com.GestorPenas.demo.service.JugadorService;

@RestController
@RequestMapping(path = "/jugador")
public class JugadorController {

	@Autowired
	private final JugadorService jugadorService;

	@Autowired
	public JugadorController(JugadorService jugadorService) {
		super();
		this.jugadorService = jugadorService;
	}
	
	@GetMapping(value = "/{id}")
	public Jugador getListJugador(@PathVariable("id") Long id){
		return jugadorService.getJugadorById(id);
	}
	
	@PostMapping(value = "/add")
	public void setJugador(@RequestBody AddJugadorDTO addJugadorDTO) {
		
		
		 jugadorService.setJugador(addJugadorDTO);
	}

	/*
	@GetMapping(value = "/")
	public List<Jugador> getListJugador(){
		return jugadorService.getJugadores();
	}
	
	*/
}
