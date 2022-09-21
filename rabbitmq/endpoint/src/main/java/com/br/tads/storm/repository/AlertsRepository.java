package com.br.tads.storm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.tads.storm.model.Alerts;

@Repository
public interface AlertsRepository extends JpaRepository<Alerts,Integer>{

}