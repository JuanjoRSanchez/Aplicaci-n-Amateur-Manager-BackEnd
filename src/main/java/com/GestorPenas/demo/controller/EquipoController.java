package com.GestorPenas.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

import com.GestorPenas.demo.Model.Equipo;
import com.GestorPenas.demo.service.EquipoService;

@Controller
public class EquipoController {

	@Autowired
	private final EquipoService equipoService;

	@Autowired
	public EquipoController(EquipoService equipoService) {
		super();
		this.equipoService = equipoService;
	}
	
	@GetMapping(value = "/")
	public List<Equipo> getListPena(){
		List<Equipo> aux = equipoService.getEquipos();
		return aux;
	}
	/*
	@PostMapping(value = "/add")
	public setEquipo() {
		
	}
	*/
}
