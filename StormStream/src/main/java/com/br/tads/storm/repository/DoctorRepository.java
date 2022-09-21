package com.br.tads.storm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.tads.storm.model.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer>{
	
	public Doctor getById(Integer id);
}
