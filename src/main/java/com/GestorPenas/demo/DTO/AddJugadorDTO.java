package com.GestorPenas.demo.DTO;


public class AddJugadorDTO {


	private String nombre;
	
	private String edad;
	
	private String direccion;
	
	private String telefono;
	
	private String pass;
	
	private int idPena;

	public AddJugadorDTO(String nombre, String edad, String direccion, String telefono, String pass, int idPena) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.telefono = telefono;
		this.pass = pass;
		this.idPena = idPena;
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

	public int getIdPena() {
		return idPena;
	}

	public void setIdPena(int idPena) {
		this.idPena = idPena;
	}
	
	


}
