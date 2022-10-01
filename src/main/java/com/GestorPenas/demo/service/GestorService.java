package com.GestorPenas.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestorPenas.demo.DTO.LoginGestorDTO;
import com.GestorPenas.demo.model.Gestor;
import com.GestorPenas.demo.repositories.GestorRepository;

@Service
public class GestorService {

	@Autowired
	public final GestorRepository gestorRepository;

	@Autowired
	public GestorService(GestorRepository gestorRepository) {
		super();
		this.gestorRepository = gestorRepository;
	}

	public Gestor getGestorById(Long id) {
		Optional<Gestor> gestorAux = gestorRepository.findById(id);

		return gestorAux.get();
	}

	public Long getLogin(LoginGestorDTO loginGestorDTO) {
		Long salida = 0L; 
		
		Optional <Gestor> gestor = gestorRepository.findByPass(loginGestorDTO.getPass());
		if(gestor.isPresent()) {
			salida = gestor.get().getId();
		}
		
		return salida;
	}
	
	public Long getLogin01(LoginGestorDTO loginGestorDTO) {
		Long salida = 0L;
		
		Optional <Gestor> gestorByName = gestorRepository.findByNombre(loginGestorDTO.getName());
		Optional<Gestor> gestorByPass = gestorRepository.findByPass(loginGestorDTO.getPass());
		if(gestorByName.isPresent() && gestorByPass.isPresent()) {
			salida = gestorByName.get().getId() ;
		}
		return salida ;
	}
	
	public List<Gestor> getGestores() {
		List<Gestor> gestorAux = gestorRepository.findAll();

		return gestorAux;
	}

	public Long setGestor(Gestor gestor) {
		Long salida = 0L;
		gestorRepository.save(gestor);
		Optional <Gestor> gestorAux = gestorRepository.findByTelefono(gestor.getTelefono());
		if ( gestorAux.isPresent()) {
			salida = gestorAux.get().getId();
		}
		return salida;
	}

	public void deleteGestor(Long id) {
		gestorRepository.deleteById(id);

	}
}
