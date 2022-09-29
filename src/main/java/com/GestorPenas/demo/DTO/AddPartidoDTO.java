package com.GestorPenas.demo.DTO;

public class AddPartidoDTO {

	private int IdPena;

	private String fechaPartido;
	
	public AddPartidoDTO() {
		super();
	}

	public AddPartidoDTO(int IdPena, String fechaPartido) {
		super();
		this.IdPena = IdPena;
		this.fechaPartido = fechaPartido;
	}

	public int getIdPena() {
		return IdPena;
	}

	public void setIdPena(int IdPena) {
		this.IdPena = IdPena;
	}

	public String getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(String fechaPartido) {
		this.fechaPartido = fechaPartido;
	}
	

}
