package com.GestorPenas.demo.service;

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

	public void setJugador(AddJugadorDTO addJugadorDTO) {
		Long idPena = (long) addJugadorDTO.getIdPena();
		Jugador jugador = new Jugador();

		Optional<Pena> penaAux = penaRepository.findById(idPena);

		if (penaAux != null) {
			jugador.setDireccion(addJugadorDTO.getDireccion());
			jugador.setEdad(addJugadorDTO.getEdad());
			jugador.setNombre(addJugadorDTO.getNombre());
			jugador.setPass(addJugadorDTO.getPass());
			jugador.setTelefono(addJugadorDTO.getTelefono());
			jugadorRepository.save(jugador);
		}

	}
}
