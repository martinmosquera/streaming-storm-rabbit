package com.br.tads.storm;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.scheduler.Topologies;
import org.apache.storm.scheduler.TopologyDetails;
import org.apache.storm.topology.TopologyBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.tads.storm.bolt.HandlerTuplaBolt;
import com.br.tads.storm.repository.AlertsRepository;
import com.br.tads.storm.repository.ConsultaRepository;
import com.br.tads.storm.repository.DoctorRepository;
import com.br.tads.storm.repository.ObjectJsonRepository;
import com.br.tads.storm.repository.PascienteRepository;
import com.br.tads.storm.spout.HandlerTuplaSpout;
import com.br.tads.storm.model.Consulta;
import com.br.tads.storm.model.Doctor;
import com.br.tads.storm.model.ObjectJson;
import com.br.tads.storm.model.Pasciente;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

@Component
public class HandlerTopology{

	@Autowired
	private ObjectJsonRepository objR;
	
	@Autowired
	private AlertsRepository alertR;
	
	@Autowired
	private PascienteRepository pascienteR;
	
	@Autowired
	private DoctorRepository doctorR;
	
	@Autowired
	private ConsultaRepository consultaR;
	
	public static List<ObjectJson> lista;
	public static List<Pasciente> listaPascientes;
	public static List<Doctor> listaDoctores;
	public static List<Consulta> listaDocPasc;

	
	@PostConstruct
	public void runTopology() {
		lista = this.objR.findAll();
		
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("startSpout", new HandlerTuplaSpout());
		builder.setBolt("endBolt", new HandlerTuplaBolt()).shuffleGrouping("startSpout");
		Config config = new Config();
		config.setClasspath("pR");
		config.setDebug(false);
		LocalCluster cluster = new LocalCluster();
		try {
		Thread.sleep(1000);
		cluster.submitTopology("StreamingTopology", config, builder.createTopology());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	}
