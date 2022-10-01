package com.GestorPenas.demo.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "partido")
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private int marcadorBlanco;

	@Column
	private int marcadorNegro;

	@OneToOne
	private Pena pena;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion = new Date();

	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime fechaPartido;
	
	public Partido() {
		super();
	}

	public Partido(Long id, int marcadorBlanco, int marcadorNegro, Pena pena, Date fechaCreacion, LocalDateTime fechaPartido) {
		super();
		this.id = id;
		this.marcadorBlanco = marcadorBlanco;
		this.marcadorNegro = marcadorNegro;
		this.pena = pena;
		this.fechaCreacion = fechaCreacion;
		this.fechaPartido = fechaPartido;
	}

	public LocalDateTime getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(LocalDateTime fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Long getId_partido() {
		return id;
	}

	public void setId_partido(Long id_gestor) {
		this.id = id_gestor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pena getPena() {
		return pena;
	}

	public void setPena(Pena pena) {
		this.pena = pena;
	}

	public int getMarcadorBlanco() {
		return marcadorBlanco;
	}

	public void setMarcadorBlanco(int marcadorBlanco) {
		this.marcadorBlanco = marcadorBlanco;
	}

	public int getMarcadorNegro() {
		return marcadorNegro;
	}

	public void setMarcadorNegro(int marcadorNegro) {
		this.marcadorNegro = marcadorNegro;
	}


	
	
}
