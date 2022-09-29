package com.GestorPenas.demo.Model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "equipo")
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String color;

	@OneToMany
	@JsonIgnore
	private List<Jugador> jugadores;
	
	@OneToOne
	@JsonIgnore
	private Partido partido;
	
	public Equipo() {
		super();
	}

	

	public Equipo(Long id, String color, List<Jugador> jugadores, Partido partido) {
		super();
		this.id = id;
		this.color = color;
		this.jugadores = jugadores;
		this.partido = partido;
	}



	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Long getId() {
		return id;
	}

}
