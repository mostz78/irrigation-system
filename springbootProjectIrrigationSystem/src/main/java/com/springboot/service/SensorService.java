package com.springboot.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.springboot.dao.LandDAO;
import com.springboot.dao.SensorDAO;
import com.springboot.model.Sensor;

@Service
public class SensorService {

	@Autowired
	private SensorDAO sensorDAO;
	@Autowired
	private LandDAO landDAO;
	
	
	public List<Sensor> getAllSensor(){
		return sensorDAO.findAll();	
	}
	
	public Sensor findById(int id) {
		return sensorDAO.findById(id).get();
	}
	
	public Sensor add(Sensor sensor) {
		LocalDateTime start = LocalDateTime.now(); 
		LocalDateTime finish =start.plusHours(6);
		sensor.setWorkStartDate(start);
		sensor.setWorkFinishDate(finish);
		sensor.setActive(true);
		sensor.getLand().setStatus("New (don't need irrigate)");
		return sensorDAO.save(sensor);
	}
	
	public void delete(int id) {
		sensorDAO.deleteById(id);
	}
	
	public Sensor Update(Sensor sensor) {
		LocalDateTime start = LocalDateTime.now(); 
		LocalDateTime finish =start.plusHours(6);
		sensor.setWorkStartDate(start);
		sensor.setWorkFinishDate(finish);
		sensor.setActive(true);
		sensor.getLand().setStatus("New (don't need irrigate)");
		return sensorDAO.save(sensor);
	}
	  @Scheduled(fixedRate = 600000)
	  public void execute() {
		  LocalDateTime start = LocalDateTime.now(); 
		  List<Sensor> sensors=sensorDAO.findAllWithFinishnDateTimeBefore();
		  int size=sensors.size();
		  if(size>0) {
			  LocalDateTime target = LocalDateTime.now().plusHours(2);  
		  for(int i=0;i<size;i++) {
			  if(sensors.get(i).getWorkFinishDate().isBefore(target))   
				  sensors.get(i).getLand().setStatus("Urgent (need urgent irrigation)");
			  else 
				  sensors.get(i).getLand().setStatus("Inprogress (need irrigation)"); 
			  sensors.get(i).setLastLandWorked("Mostafa");
			  sensorDAO.save(sensors.get(i));
			  landDAO.save(sensors.get(i).getLand());
		  }
		  }
		 // land.setStatus("New (don't need irrigate)");
	    // some logic that will be executed on a schedule
	    System.out.println("Code is being executed..."+size);
	  }
}
