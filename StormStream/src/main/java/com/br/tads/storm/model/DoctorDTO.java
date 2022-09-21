package com.br.tads.storm.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class DoctorDTO implements Serializable{

	private Integer uuid;
	
	private Integer id;
	
	private String nome;
	
	private String telefone;

	public DoctorDTO() {
		super();
	}

	public DoctorDTO(Integer uuid, Integer id_doctor, String nome, String telefone) {
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

	public void setId(Integer id_doctor) {
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
