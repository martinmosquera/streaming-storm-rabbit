package com.br.tads.storm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="consulta")
public class Consulta implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uuid;
	
	@Column(name="idpasciente")	
	private Integer idpasciente;
	
	@Column(name="iddoctor")
	private Integer iddoctor;

	public Consulta() {
		super();
	}

	public Consulta(Integer uuid, Integer id_pasciente, Integer id_doctor) {
		super();
		this.uuid = uuid;
		this.idpasciente = id_pasciente;
		this.iddoctor = id_doctor;
	}

	public Integer getUuid() {
		return uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public Integer getIdpasciente() {
		return idpasciente;
	}

	public void setIdpasciente(Integer id_pasciente) {
		this.idpasciente = id_pasciente;
	}

	public Integer getIddoctor() {
		return iddoctor;
	}

	public void setIddoctor(Integer id_doctor) {
		this.iddoctor = id_doctor;
	}
	
	
}