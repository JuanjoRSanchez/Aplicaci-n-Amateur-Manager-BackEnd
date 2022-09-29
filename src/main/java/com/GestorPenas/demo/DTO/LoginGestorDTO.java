package com.GestorPenas.demo.DTO;

public class LoginGestorDTO {

	String pass;
	
	String name;
	
	String email;

	public LoginGestorDTO(String pass, String email, String name) {
		super();
		this.pass = pass;
		this.email = email;
		this.name = name;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
