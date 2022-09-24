package com.GestorPenas.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestorPenas.demo.Model.Gestor;
import com.GestorPenas.demo.Repositories.GestorRepository;

@Service
public class GestorService {

	@Autowired
	public final GestorRepository gestorRepository;
	
	
	@Autowired
	public GestorService(GestorRepository gestorRepository) {
		super();
		this.gestorRepository = gestorRepository;
	}
	
	public Gestor getGestorById(Long id){
		Optional  <Gestor>  gestorAux = gestorRepository.findById(id);	
		
		return gestorAux.get();
	}
	
	public List<Gestor> getGestores(){
		List  <Gestor>  gestorAux = gestorRepository.findAll();	
		
		return gestorAux;
	}
	public void setGestor(Gestor gestor){
		
		
		gestorRepository.save(gestor);
		
	}
	
	public void deleteGestor(Long id){
		gestorRepository.deleteById(id);
		
	}
}
