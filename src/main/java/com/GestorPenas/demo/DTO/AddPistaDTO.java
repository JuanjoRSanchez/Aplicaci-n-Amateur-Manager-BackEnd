package com.GestorPenas.demo.DTO;



public class AddPistaDTO {

	
	private String nombre;
	
	private String direccion;
	
	private String telefono;
	
	private String contacto;
	
	private int idPena;

	public AddPistaDTO(String nombre, String direccion, String telefono, String contacto, int idPena) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.contacto = contacto;
		this.idPena = idPena;
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

	public int getIdPena() {
		return idPena;
	}

	public void setIdPena(int idPena) {
		this.idPena = idPena;
	}

	
	

	
	
}
