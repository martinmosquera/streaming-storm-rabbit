package com.br.tads.storm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.tads.storm.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Integer>{
	
	public Consulta getByIdpasciente(Integer id);
}