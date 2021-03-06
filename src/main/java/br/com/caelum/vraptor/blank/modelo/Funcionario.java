package br.com.caelum.vraptor.blank.modelo;

import java.util.Date;

public class Funcionario {
	
	private Integer matricula;
	private String nome;
	private Date dataNascimento;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome, Integer matricula, Date dataNascimento) {
		this.nome = nome;
		this.matricula = matricula;
		this.dataNascimento = dataNascimento;
	}
	
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
