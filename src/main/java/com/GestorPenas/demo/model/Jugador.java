package com.GestorPenas.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "jugador")
public class Jugador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String edad;
	
	@Column
	private String direccion;
	
	@Column
	private String telefono;
	
	@Column
	private String pass;
	
	@OneToOne
	@JsonIgnore
	private Pena pena;
	
	public Jugador() {
		super();
	}

	public Jugador(Long id, String nombre, String edad, String direccion, String telefono, String pass, Pena pena) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.telefono = telefono;
		this.pass = pass;
		this.pena = pena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id_jugador) {
		this.id = id_jugador;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEdad() {
		return edad;
	}
	
	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}

	public Pena getPena() {
		return pena;
	}

	public void setPena(Pena pena) {
		this.pena = pena;
	}
	
}
