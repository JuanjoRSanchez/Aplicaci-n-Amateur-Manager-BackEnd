package com.GestorPenas.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestorPenas.demo.DTO.AddPenaDTO;
import com.GestorPenas.demo.Model.Gestor;
import com.GestorPenas.demo.Model.Pena;
import com.GestorPenas.demo.repositories.GestorRepository;
import com.GestorPenas.demo.repositories.PenaRepository;

@Service
public class PenaService {
	@Autowired
	private final PenaRepository penaRepository;

	@Autowired
	private final GestorRepository gestorRepository;

	@Autowired
	public PenaService(PenaRepository penaRepository, GestorRepository gestorRepository) {
		super();
		this.penaRepository = penaRepository;
		this.gestorRepository = gestorRepository;
	}

	public Pena getPenaById(Long id) {
		Optional<Pena> penaAux = penaRepository.findById(id);

		if (penaAux != null) {
			return penaAux.get();
		}

		return null;
	}

	public List<Pena> getPena() {
		List<Pena> penaAux = penaRepository.findAll();

		return penaAux;
	}

	public List<Pena> getPenaByGestor(int idGestor) {
		Long idGestorLong = (long) idGestor;
		Optional<Gestor> gestor = gestorRepository.findById(idGestorLong);
		Gestor gestorAux = new Gestor();
		if (gestor.isPresent()) {
			gestorAux = gestor.get();
		}
		List<Pena> penaAux = penaRepository.findByGestor(gestorAux);

		return penaAux;
	}

	public void setPena(Pena pena) {
		Optional<Gestor> gestorAux = gestorRepository.findById(pena.getGestor().getId());
		if (gestorAux != null) {
			penaRepository.save(pena);
		}
	}

	public void setPena01(AddPenaDTO addPenaDTO) {
		Long idGestor = (long) addPenaDTO.getIdGestor();
		Optional<Gestor> gestorAux = gestorRepository.findById(idGestor);
		Pena pena = new Pena();
		Gestor gestor = new Gestor();
		if (gestorAux != null) {
			gestor = gestorAux.get();
			pena.setNombre(addPenaDTO.getNombre());
			pena.setGestor(gestor);
			penaRepository.save(pena);
		}
	}

	public void deletePena(Long id) {
		penaRepository.deleteById(id);

	}

}
