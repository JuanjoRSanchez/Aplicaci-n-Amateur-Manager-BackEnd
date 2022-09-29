package com.GestorPenas.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestorPenas.demo.DTO.AddJugadorDTO;
import com.GestorPenas.demo.Model.Jugador;
import com.GestorPenas.demo.Model.Pena;
import com.GestorPenas.demo.Repositories.JugadorRepository;
import com.GestorPenas.demo.Repositories.PenaRepository;

@Service
public class JugadorService {

	@Autowired
	private final JugadorRepository jugadorRepository;

	@Autowired
	private final PenaRepository penaRepository;

	@Autowired
	public JugadorService(JugadorRepository jugadorRepository, PenaRepository penaRepository) {
		this.jugadorRepository = jugadorRepository;
		this.penaRepository = penaRepository;
	}

	public Jugador getJugadorById(Long id) {
		Optional<Jugador> jugadorAux = jugadorRepository.findById(id);

		return jugadorAux.get();
	}

	public List <Jugador> getJugadorByIdPena(int id) {
		List <Jugador> jugadores = new ArrayList<Jugador>();
		Long idPenaLong = (long) id;
		Optional <Pena> pena = penaRepository.findById(idPenaLong);
		if(pena.isPresent()) {
			jugadores = jugadorRepository.findByPena(pena.get());
		}
		
		return jugadores;
	}
	
	public void setJugador(AddJugadorDTO addJugadorDTO) {
		Long idPena = (long) addJugadorDTO.getIdPena();
		Jugador jugador = new Jugador();

		Optional<Pena> penaAux = penaRepository.findById(idPena);

		if (penaAux.isPresent()) {
			jugador.setDireccion(addJugadorDTO.getDireccion());
			jugador.setEdad(addJugadorDTO.getEdad());
			jugador.setNombre(addJugadorDTO.getNombre());
			jugador.setPass(addJugadorDTO.getPass());
			jugador.setTelefono(addJugadorDTO.getTelefono());
			jugador.setPena(penaAux.get());
			jugadorRepository.save(jugador);
		}

	}
}
