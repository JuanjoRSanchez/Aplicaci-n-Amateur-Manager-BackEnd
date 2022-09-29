package com.GestorPenas.demo.DTO;

public class AddResultadoDTO {

	private String resultadoBlanco;
	
	private String resultadoNegro;

	public AddResultadoDTO(String resultadoBlanco, String resultadoNegro) {
		super();
		this.resultadoBlanco = resultadoBlanco;
		this.resultadoNegro = resultadoNegro;
	}

	public String getResultadoBlanco() {
		return resultadoBlanco;
	}

	public void setResultadoBlanco(String resultadoBlanco) {
		this.resultadoBlanco = resultadoBlanco;
	}

	public String getResultadoNegro() {
		return resultadoNegro;
	}

	public void setResultadoNegro(String resultadoNegro) {
		this.resultadoNegro = resultadoNegro;
	}
	
	
}
