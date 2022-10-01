package com.GestorPenas.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.GestorPenas.demo.DTO.AddPistaDTO;
import com.GestorPenas.demo.model.Pista;
import com.GestorPenas.demo.service.PistaService;

@Controller
@RequestMapping(path = "/pista")

public class PistaController {

	@Autowired
	public final PistaService pistaService;


	@Autowired
	public PistaController(PistaService pistaService) {
		super();
		this.pistaService = pistaService;
	}

	@GetMapping(value = "/")
	public List<Pista> getListPena() {
		List<Pista> aux = pistaService.getPista();
		return aux;
	}

	@GetMapping(value = "/{id}")
	public Optional<Pista> getPena(@PathVariable("id") Long id) {
		return pistaService.getPistaById(id);
	}

	@PostMapping(value = "/add")
	public void setPista(@RequestBody AddPistaDTO addPistaDTO) {
		pistaService.setPista(addPistaDTO);
	}

}