package com.br.tads.storm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.tads.storm.model.Pasciente;


@Repository
public interface PascienteRepository extends JpaRepository<Pasciente,Integer>{
	
	public Pasciente getById(Integer id);
}