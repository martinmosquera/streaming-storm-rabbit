package com.br.tads.storm.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Id;

public class AlertsDTO implements Serializable{

	private Integer id_alert;	
	private Integer id_pasciente;
	private Integer id_doctor;
	private String tel_pasciente;
	private String tel_doctor;
	private LocalDateTime created_at;

	public AlertsDTO() {
		super();
	}

	public AlertsDTO(Integer id_alert, Integer id_pasciente, Integer id_doctor, String tel_pasciente, String tel_doctor,
			LocalDateTime created_at) {
		super();
		this.id_alert = id_alert;
		this.id_pasciente = id_pasciente;
		this.id_doctor = id_doctor;
		this.tel_pasciente = tel_pasciente;
		this.tel_doctor = tel_doctor;
		this.created_at = created_at;
	}

	public Integer getId_alert() {
		return id_alert;
	}

	public void setId_alert(Integer id_alert) {
		this.id_alert = id_alert;
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

	public String getTel_pasciente() {
		return tel_pasciente;
	}

	public void setTel_pasciente(String tel_pasciente) {
		this.tel_pasciente = tel_pasciente;
	}

	public String getTel_doctor() {
		return tel_doctor;
	}

	public void setTel_doctor(String tel_doctor) {
		this.tel_doctor = tel_doctor;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

}
