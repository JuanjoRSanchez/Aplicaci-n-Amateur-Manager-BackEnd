package com.GestorPenas.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.GestorPenas.demo.service.PenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.GestorPenas.demo.DTO.AddJugadorDTO;
import com.GestorPenas.demo.Model.Jugador;
import com.GestorPenas.demo.service.JugadorService;
import com.GestorPenas.demo.service.PenaService;


@RestController
@RequestMapping(path = "/jugador")
public class JugadorController {

	@Autowired
	private final JugadorService jugadorService;

	@Autowired
	private final PenaService penaService;

	@Autowired
	public JugadorController(JugadorService jugadorService, PenaService penaService) {
		super();
		this.jugadorService = jugadorService;
		this.penaService = penaService;
	}

	@GetMapping(value = "/all/{idPena}")
	public List<Jugador> getJugadores(@PathVariable("idPena") int idPena){
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores = jugadorService.getJugadoresByIdPena(idPena);

		return jugadores;
	}

	@GetMapping(value = "/allJugadores/")
	public List<Jugador> getJugadoresAll(){
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores = jugadorService.getJugadoresByPena();

		return jugadores;
	}

	@GetMapping(value = "/{id}")
	public Jugador getJugador(@PathVariable("id") int id){
		return jugadorService.getJugadorById(id);
	}

	@PostMapping(value = "/add")
	public void setJugador(@RequestBody AddJugadorDTO addJugadorDTO) {
		 jugadorService.setJugador(addJugadorDTO);
	}
	@PostMapping(value = "/update")
	public int updateJugador(@RequestBody AddJugadorDTO addJugadorDTO) {

		return jugadorService.updateJugador(addJugadorDTO);
	}

}
