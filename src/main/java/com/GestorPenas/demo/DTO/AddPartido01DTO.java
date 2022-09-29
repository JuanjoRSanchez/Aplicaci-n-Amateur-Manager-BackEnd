package com.GestorPenas.demo.DTO;

public class AddPartido01DTO {

	private int IdPena;
	
	private int idPartido;

	private String fechaPartido;
	
	private String marcadorBlanco;
	
	private String marcadorNegro;
	
	public AddPartido01DTO() {
		super();
	}
	
	public AddPartido01DTO(int idPena, int idPartido, String fechaPartido, String marcadorBlanco,
			String marcadorNegro) {
		super();
		IdPena = idPena;
		this.idPartido = idPartido;
		this.fechaPartido = fechaPartido;
		this.marcadorBlanco = marcadorBlanco;
		this.marcadorNegro = marcadorNegro;
	}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public String getMarcadorBlanco() {
		return marcadorBlanco;
	}

	public void setMarcadorBlanco(String marcadorBlanco) {
		this.marcadorBlanco = marcadorBlanco;
	}

	public String getMarcadorNegro() {
		return marcadorNegro;
	}

	public void setMarcadorNegro(String marcadorNegro) {
		this.marcadorNegro = marcadorNegro;
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
