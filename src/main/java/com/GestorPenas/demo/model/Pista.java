package com.GestorPenas.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pista")
public class Pista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String direccion;
	
	@Column
	private String telefono;
	
	@Column
	private String contacto;
	
	@OneToOne
	private Pena pena;
	
	public Pista() {
		super();
	}

	public Pista(Long id_pista, String nombre, String direccion, String telefono, String contacto, Pena pena) {
		super();
		this.id = id_pista;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.contacto = contacto;
		this.pena = pena; 
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
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
	
}
