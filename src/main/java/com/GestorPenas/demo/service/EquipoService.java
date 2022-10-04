package com.GestorPenas.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestorPenas.demo.Model.Equipo;
import com.GestorPenas.demo.Model.Partido;
import com.GestorPenas.demo.repositories.EquipoRepository;

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
	
	public void setEquipo(String color, Partido  NuevoPartido) {
		Equipo equipo = new Equipo();
		
		equipo.setColor(color);
		equipo.setPartido(NuevoPartido);
		equipoRepository.save(equipo);
		
	}
	/*
	public int updateResultado(int idEquipo, AddResultadoDTO addResultadoDTO) {
		int salida = 1;
		Equipo equipo = new Equipo();
		Long idEquipoLong = (long) idEquipo;
		equipo = getEquipoById(idEquipoLong);
		
		equipo.se
		
		return salida;
		
	}
	*/
}
