package com.br.tads.storm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctores")
public class Doctor implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uuid;
	
	@Column(name="id")	
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="telefone")
	private String telefone;

	public Doctor() {
		super();
	}

	public Doctor(Integer uuid, Integer id_doctor, String nome, String telefone) {
		super();
		this.uuid = uuid;
		this.id = id_doctor;
		this.nome = nome;
		this.telefone = telefone;
	}

	public Integer getUuid() {
		return uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public Integer getId() {
		return id;
	}

	public void setIddoctor(Integer id_doctor) {
		this.id = id_doctor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
			

}
