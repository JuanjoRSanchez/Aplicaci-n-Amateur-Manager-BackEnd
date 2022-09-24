package com.GestorPenas.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestorPenas.demo.Model.Equipo;
import com.GestorPenas.demo.Repositories.EquipoRepository;

@Service
public class EquipoService {

	@Autowired
	private final EquipoRepository equipoRepository;
	
	@Autowired
	public EquipoService(EquipoRepository equipoRepository) {
		this.equipoRepository = equipoRepository;
	}
	
	public Equipo getEquipoById(Long id){
		Optional  <Equipo>  equipoAux = equipoRepository.findById(id);	
		
		return equipoAux.get();
	}

	public List<Equipo> getEquipos() {
		List <Equipo> listaEquipos = equipoRepository.findAll();
		return listaEquipos;
	}
}
