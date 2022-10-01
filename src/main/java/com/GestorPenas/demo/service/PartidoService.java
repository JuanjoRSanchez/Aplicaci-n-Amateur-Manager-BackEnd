package com.GestorPenas.demo.service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestorPenas.demo.DTO.AddPartido01DTO;
import com.GestorPenas.demo.DTO.AddResultadoDTO;
import com.GestorPenas.demo.model.Partido;
import com.GestorPenas.demo.model.Pena;
import com.GestorPenas.demo.repositories.PartidoRepository;

@Service
public class PartidoService {

	@Autowired
	public final PartidoRepository partidoRepository;

	@Autowired
	public final EquipoService equipoService;

	@Autowired
	public final PenaService penaService;

	@Autowired
	public PartidoService(PartidoRepository partidoRepository, EquipoService equipoService, PenaService penaService) {
		super();
		this.partidoRepository = partidoRepository;
		this.equipoService = equipoService;
		this.penaService = penaService;

	}

	public Optional<Partido> getPartido(int id) {
		Long idPartido = (long) id;
		Optional<Partido> partido = partidoRepository.findPartidoById(idPartido);
		return partido;
	}

	public List<Partido> getPartidos() {
		List<Partido> partidos = new ArrayList<Partido>();
		partidos = partidoRepository.findAll();

		return partidos;
	}

	public List<Partido> getPartidosByPena(int idPena) {
		
		List<Partido> partidos = new ArrayList<Partido>();
		Long id_pena = (long) idPena;
		Pena pena = penaService.getPenaById(id_pena);
		partidos = partidoRepository.findPartidoByPena(pena);

		return partidos;
	}

	public List<Partido> getPartidosByPena(Long id) {
		List<Partido> partido = partidoRepository.findAll();

		return partido;
	}

	public void setPartido(int idPena) {
		Partido auxPartido = new Partido();
		Pena pena = new Pena();

		Long idPenaLong = (long) idPena;
		pena = penaService.getPenaById(idPenaLong);

		auxPartido.setPena(pena);
		partidoRepository.save(auxPartido);

		List<Partido> partidos = getPartidosByPena(idPenaLong);
		partidos.sort(Comparator.comparing(Partido::getFechaCreacion));
		Partido NuevoPartido = partidos.get(partidos.size() - 1);
		equipoService.setEquipo("negro", NuevoPartido);
		equipoService.setEquipo("blanco", NuevoPartido);

	}

	public int setPartido01(int id, String date) {
		int salida = 1;
		Partido auxPartido = new Partido();
		Pena pena = new Pena();
		Long idPenaLong = (long) id;
		pena = penaService.getPenaById(idPenaLong);
		
		String dateString = date;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime parsedDateTime = LocalDateTime.parse(dateString, formatter);
		
		auxPartido.setFechaPartido(parsedDateTime);
		auxPartido.setPena(pena);
		
		if(auxPartido != null) {
			partidoRepository.save(auxPartido);
			salida = 0;
		}
		
		List<Partido> partidos = getPartidosByPena(idPenaLong);
		partidos.sort(Comparator.comparing(Partido::getFechaCreacion));
		Partido NuevoPartido = partidos.get(partidos.size() - 1);
		equipoService.setEquipo("negro", NuevoPartido);
		equipoService.setEquipo("blanco", NuevoPartido);
		return salida;
	}
	
	public int setPartido02(AddPartido01DTO addPartido01DTO) {
		int salida = 1;
		Partido auxPartido = new Partido();
		Pena pena = new Pena();
		Long idPenaLong = (long) addPartido01DTO.getIdPena();
		pena = penaService.getPenaById(idPenaLong);
		
		String dateString = addPartido01DTO.getFechaPartido();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime parsedDateTime = LocalDateTime.parse(dateString, formatter);
		
		auxPartido.setFechaPartido(parsedDateTime);
		auxPartido.setPena(pena);
		
		if(auxPartido != null) {
			partidoRepository.save(auxPartido);
			salida = 0;
		}
		
		List<Partido> partidos = getPartidosByPena(idPenaLong);
		partidos.sort(Comparator.comparing(Partido::getFechaCreacion));
		Partido NuevoPartido = partidos.get(partidos.size() - 1);
		equipoService.setEquipo("negro", NuevoPartido);
		equipoService.setEquipo("blanco", NuevoPartido);
		return salida;
	}
	public int updarteResultadoEnPartido(AddResultadoDTO addResultadoDTO, int idPartido) {
		int salida = 1;
		Partido partido01 = new Partido();

		Optional<Partido> partido = getPartido(idPartido);

		if (partido.isPresent()) {

			partido01 = partido.get();
			partido01.setMarcadorBlanco(Integer.parseInt(addResultadoDTO.getResultadoBlanco()));
			partido01.setMarcadorNegro(Integer.parseInt(addResultadoDTO.getResultadoNegro()));
			partidoRepository.save(partido01);

			salida = 0;
		}

		return salida;
	}
	public int updarteResultadoEnPartido01(AddPartido01DTO addPartido01DTO) {
		int salida = 1;
		Partido partido01 = new Partido();

		Optional<Partido> partido = getPartido(addPartido01DTO.getIdPartido());

		if (partido.isPresent()) {

			partido01 = partido.get();
			partido01.setMarcadorBlanco(Integer.parseInt(addPartido01DTO.getMarcadorBlanco()));
			partido01.setMarcadorNegro(Integer.parseInt(addPartido01DTO.getMarcadorNegro()));
			partidoRepository.save(partido01);

			salida = 0;
		}

		return salida;
	}
}
