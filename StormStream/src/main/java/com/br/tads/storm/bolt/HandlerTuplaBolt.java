package com.br.tads.storm.bolt;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.tads.storm.HandlerTopology;
import com.br.tads.storm.model.Alerts;
import com.br.tads.storm.model.AlertsDTO;
import com.br.tads.storm.model.Consulta;
import com.br.tads.storm.model.Doctor;
import com.br.tads.storm.model.ObjectJson;
import com.br.tads.storm.model.ObjectJsonDTO;
import com.br.tads.storm.model.Pasciente;
import com.br.tads.storm.repository.AlertsRepository;
import com.br.tads.storm.repository.ConsultaRepository;
import com.br.tads.storm.repository.DoctorRepository;
import com.br.tads.storm.repository.PascienteRepository;



@Component
public class HandlerTuplaBolt extends BaseBasicBolt {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	@Override
	public void execute(Tuple input, BasicOutputCollector collector) {
		ModelMapper mapper = new ModelMapper();
		Object val = input.getValueByField("obj");
		ObjectJson obj = mapper.map(val,ObjectJson.class);
		if(obj.getTotal_UPDRS() > 50) {
			System.out.println("Alert to User -> Pasciente Id "+obj.getId()+" UPDRS -> "+obj.getTotal_UPDRS()+" tempo atual : "+java.time.LocalDateTime.now());
		}
		collector.emit(new Values(val));
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("obj"));
		
	}
	
	
	
	//			Consulta co = ht.getConsultaR().getByIdpasciente(obj.getId());
//	Doctor dr = ht.getDoctorR().getById(co.getIddoctor());
//	AlertsDTO a = new AlertsDTO();
//	a.setId_doctor(dr.getId());
//	a.setId_pasciente(pa.getId());
//	a.setTel_doctor(dr.getTelefone());
//	a.setTel_pasciente(pa.getTelefone());
//	a.setCreated_at(java.time.LocalDateTime.now());
//	Alerts abd = mapper.map(a, Alerts.class);
//	ht.getAlertR().save(abd);
}
