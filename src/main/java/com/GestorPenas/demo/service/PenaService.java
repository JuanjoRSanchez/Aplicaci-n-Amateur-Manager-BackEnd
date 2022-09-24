package com.GestorPenas.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestorPenas.demo.Model.Gestor;
import com.GestorPenas.demo.Model.Pena;
import com.GestorPenas.demo.Repositories.GestorRepository;
import com.GestorPenas.demo.Repositories.PenaRepository;

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

	public void setPena(Pena pena) {
		Optional<Gestor> gestorAux = gestorRepository.findById(pena.getGestor().getId());
		if (gestorAux != null) {
			 penaRepository.save(pena);
		}
	}

	public void deletePena(Long id) {
		penaRepository.deleteById(id);

	}

}
