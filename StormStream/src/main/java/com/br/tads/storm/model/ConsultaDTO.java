package com.br.tads.storm.model;

import java.io.Serializable;

public class ConsultaDTO implements Serializable{
	
	private Integer uuid;	
	private Integer id_pasciente;
	private Integer id_doctor;

	public ConsultaDTO() {
		super();
	}

	public ConsultaDTO(Integer uuid, Integer id_pasciente, Integer id_doctor) {
		super();
		this.uuid = uuid;
		this.id_pasciente = id_pasciente;
		this.id_doctor = id_doctor;
	}

	public Integer getUuid() {
		return uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public Integer getId_pasciente() {
		return id_pasciente;
	}

	public void setId_pasciente(Integer id_pasciente) {
		this.id_pasciente = id_pasciente;
	}

	public Integer getId_doctor() {
		return id_doctor;
	}

	public void setId_doctor(Integer id_doctor) {
		this.id_doctor = id_doctor;
	}
	
	
}