package com.GestorPenas.demo.Model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "partido_id", nullable = false)
	private Partido partido;

	public Equipo() {
		super();
	}

	public Equipo(Long id, String color, List<Jugador> jugadores) {
		super();
		this.id = id;
		this.color = color;
		this.jugadores = jugadores;
	}

	public Long getId() {
		return id;
	}

	public void setId_equipo(Long id) {
		this.id = id;
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

}
