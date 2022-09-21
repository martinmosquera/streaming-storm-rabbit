package com.br.tads.storm;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.tads.storm.model.Alerts;
import com.br.tads.storm.model.AlertsDTO;
import com.br.tads.storm.model.Consulta;
import com.br.tads.storm.model.ConsultaDTO;
import com.br.tads.storm.model.Doctor;
import com.br.tads.storm.model.DoctorDTO;
import com.br.tads.storm.model.ObjectJsonDTO;
import com.br.tads.storm.model.Pasciente;
import com.br.tads.storm.model.PascienteDTO;
import com.br.tads.storm.repository.AlertsRepository;
import com.br.tads.storm.repository.ConsultaRepository;
import com.br.tads.storm.repository.DoctorRepository;
import com.br.tads.storm.repository.ObjectJsonRepository;
import com.br.tads.storm.repository.PascienteRepository;

@Component
public class RabbitHandler {
	
	@Autowired
	RabbitTemplate rabbit;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private AlertsRepository alertR;
	
	@Autowired
	private PascienteRepository pascienteR;
	
	@Autowired
	private DoctorRepository doctorR;
	
	@Autowired
	private ConsultaRepository consultaR;
	
	
	@RabbitListener(queues = "alertUser")
	@Transactional
	public void listen(ObjectJsonDTO in) {
		ObjectJsonDTO aux = in;
		Pasciente pa = pascienteR.getById(aux.getId());
		Consulta co = consultaR.getByIdpasciente(aux.getId());
		Doctor dr = doctorR.getById(co.getIddoctor());
		AlertsDTO a = new AlertsDTO();
		a.setId_doctor(dr.getId());
		a.setId_pasciente(pa.getId());
		a.setTel_doctor(dr.getTelefone());
		a.setTel_pasciente(pa.getTelefone());
		a.setCreated_at(java.time.LocalDateTime.now());
		Alerts abd = modelMapper.map(a, Alerts.class);
		alertR.save(abd);

	}
	 
	 @RabbitListener(queues = "saveDB")
	    public void saveReg(ObjectJsonDTO in) {
		 // queue auxiliar caso seja requrido copiar as entidades em um novo banco
		 
//		 ModelMapper mp = modelMapper();
//		 ObjectJson oj = mp.map(in, ObjectJson.class);
//		 objR.save(oj);
	    }
	 
	 @RabbitListener(queues = "StartMessage")
	    public void choosePath(ObjectJsonDTO in) {
		 if(in.getTotal_UPDRS() > 50) {
			 this.rabbit.convertAndSend("alertUser",in);
		 }
		 this.rabbit.convertAndSend("saveDB",in);
	    }

}
