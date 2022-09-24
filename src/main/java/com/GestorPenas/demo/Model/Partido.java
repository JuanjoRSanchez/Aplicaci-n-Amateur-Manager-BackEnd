package com.GestorPenas.demo.Model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "partido")
public class Partido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String resultado;
	
	@OneToOne
	private Pena pena;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion = new Date(); 
	
	@OneToMany(mappedBy = "partido")
	@JsonIgnore
	private Set<Equipo> equipos;
	
	public Partido() {
		super();
	}

	public Partido(Long id, String fecha, String resultado, Pena pena, Date fechaCreacion, Set<Equipo> equipos) {
		super();
		this.id = id;
		this.resultado = resultado;
		this.pena = pena;
		this.fechaCreacion = fechaCreacion;
		this.equipos = equipos;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
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



	public Set<Equipo> getEquipos() {
		return equipos;
	}



	public void setEquipos(Set<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Pena getPena() {
		return pena;
	}

	public void setPena(Pena pena) {
		this.pena = pena;
	}

	
	

}
