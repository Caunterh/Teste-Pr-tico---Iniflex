package com.caunter;

import java.time.LocalDate;


/** 
 * @author CauaSouzaCorrea
 * **/

public class Pessoa {

	private String nome; 
	private LocalDate dtNascimento;
	
	public Pessoa(String nome, LocalDate dtNascimento) {
		this.nome = nome;
		this.dtNascimento = dtNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

}
