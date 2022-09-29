package com.GestorPenas.demo.DTO;

public class AddPenaDTO {

	private String nombre;
	
	private int idGestor;

	public AddPenaDTO(String nombre, int idGestor) {
		super();
		this.nombre = nombre;
		this.idGestor = idGestor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdGestor() {
		return idGestor;
	}

	public void setIdGestor(int idGestor) {
		this.idGestor = idGestor;
	}
	
	
}
