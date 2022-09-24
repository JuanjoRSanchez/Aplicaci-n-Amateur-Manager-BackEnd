package com.GestorPenas.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestorPenas.demo.Model.Partido;
import com.GestorPenas.demo.Repositories.PartidoRepository;

@Service
public class PartidoService {
	
	@Autowired
	public final PartidoRepository partidoRepository;

	@Autowired
	public PartidoService(PartidoRepository partidoRepository) {
		super();
		this.partidoRepository = partidoRepository;
	}
	
	public Optional <Partido> getPartido(Long id) {
		Optional<Partido> partido = partidoRepository.findPartidoById(id);
		
		return partido;
	}
	
	public List <Partido> getPartidos(){
		List <Partido> partidos = new ArrayList<Partido>();
		partidos = partidoRepository.findAll();
		return partidos;
	}
	
	
}
