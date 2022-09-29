package com.GestorPenas.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestorPenas.demo.DTO.AddPartido01DTO;
import com.GestorPenas.demo.DTO.AddResultadoDTO;
import com.GestorPenas.demo.Model.Partido;
import com.GestorPenas.demo.service.PartidoService;

@RestController
@RequestMapping(path = "/partido")
public class PartidoController {

	@Autowired
	private final PartidoService partidoService;

	@Autowired
	public PartidoController(PartidoService partidoService) {
		super();
		this.partidoService = partidoService;
	}
	
	@GetMapping(value = "/id/{id}")
	public Optional <Partido> getPartidoById(@PathVariable("id") int id) {
		
		return partidoService.getPartido(id);
	}
	
	@GetMapping(value = "/")
	public List<Partido> getPartidos(){
		
		return partidoService.getPartidos();
	}
	
	@GetMapping(value = "/idPena/{id}")
	public List<Partido> getPartidosByPena(@PathVariable("id") int id){
		
		return partidoService.getPartidosByPena(id);
	}
	
	@PostMapping(value = "/post/{id}/{date}")
	public int setPartido011(@PathVariable int id, @PathVariable String date) {
		
		return partidoService.setPartido01( id, date);
	}
	
	@PostMapping(value = "/posteo/")
	public int setPartido02(@RequestBody AddPartido01DTO addPartido01DTO) {
		
		return partidoService.setPartido02( addPartido01DTO );
	}
	@PutMapping(value = "/update/{id}")
	public int updateResultadoPartido(@PathVariable int id, @RequestBody AddResultadoDTO addresultadoDTO) {
		return partidoService.updarteResultadoEnPartido(addresultadoDTO, id);
	}
}
