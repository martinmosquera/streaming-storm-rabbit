package com.br.tads.storm.spout;

import java.util.List;
import java.util.Map;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.tads.storm.HandlerTopology;
import com.br.tads.storm.MainTopology;
import com.br.tads.storm.repository.PascienteRepository;

@Component
public class HandlerTuplaSpout extends BaseRichSpout {
	
	private SpoutOutputCollector outputCollector;
	private int index = 0;
	
	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		this.outputCollector = collector;
	}
	
	@Override
	public void nextTuple() {
		if(index == 0) {
			System.out.println("Inicio do Processso -> "+ java.time.LocalDateTime.now());
		}
	if(this.index < HandlerTopology.lista.size()) {
		this.outputCollector.emit(new Values(HandlerTopology.lista.get(index)));
		this.index++;
		}
	}
	
	
	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("obj"));
		
	}


	
	
}
