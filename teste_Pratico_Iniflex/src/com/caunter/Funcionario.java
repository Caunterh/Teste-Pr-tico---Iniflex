package com.caunter;

import java.math.BigDecimal;
import java.time.LocalDate;


/** 
 * @author CauaSouzaCorrea
 * **/

public class Funcionario extends Pessoa{

	private BigDecimal salario;
	private String funcao;
	
	public Funcionario (String nome, LocalDate dtNascimento, BigDecimal salario, String funcao) {
		super(nome, dtNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
}
