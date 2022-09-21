package com.br.tads.storm.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.br.tads.storm.model.ObjectJson;

@Repository
public interface ObjectJsonRepository extends JpaRepository<ObjectJson,Integer>{
	
}
