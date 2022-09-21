package com.br.tads.storm.model;

import java.io.Serializable;

public class PascienteDTO implements Serializable{

	private Integer id;
	private String nome;
	private String endereco;
	private String telefone;

	public PascienteDTO() {
		super();
	}

	public PascienteDTO(Integer id_pasciente, String nome, String endereco, String telefone) {
		super();
		this.id = id_pasciente;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Integer getId_pasciente() {
		return id;
	}

	public void setId_pasciente(Integer id_pasciente) {
		this.id = id_pasciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

}
