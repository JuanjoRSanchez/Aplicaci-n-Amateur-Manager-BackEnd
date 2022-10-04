package com.GestorPenas.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestorPenas.demo.DTO.AddPistaDTO;
import com.GestorPenas.demo.Model.Pena;
import com.GestorPenas.demo.Model.Pista;
import com.GestorPenas.demo.repositories.PistaRepository;


@Service
public class PistaService {

	@Autowired
	public final PistaRepository pistaRepository;
	

	@Autowired
	public final PenaService penaService;
	
	@Autowired
	public PistaService(PistaRepository pistaRepository, PenaService penaService) {
		this.pistaRepository = pistaRepository;
		this.penaService = penaService;
	}
	
	public Optional<Pista> getPistaById(Long id) {
		Optional <Pista> pistaAux = pistaRepository.findPistaById(id);
		
		return pistaAux;
	}
	
	public List<Pista> getPista(){
		List  <Pista>  penaAux = pistaRepository.findAll();	
		
		return penaAux;
	}
	public void setPista(AddPistaDTO addPistaDTO){
		Pista auxPista = new Pista();
		Pena auxPena = new Pena();
		Long idPena = (long) addPistaDTO.getIdPena();

		auxPena = penaService.getPenaById(idPena);

		if (auxPena != null) {
			auxPista.setContacto(addPistaDTO.getContacto());
			auxPista.setDireccion(addPistaDTO.getDireccion());
			auxPista.setNombre(addPistaDTO.getNombre());
			auxPista.setTelefono(addPistaDTO.getTelefono());
			auxPista.setPena(auxPena);
		}
		
		pistaRepository.save(auxPista);
		
	}
}
