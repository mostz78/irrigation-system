package com.springboot.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Sensor;
import com.springboot.service.SensorService;

@RestController
@RequestMapping("/sensor")
public class SensorController {

	@Autowired	
	private SensorService sensorService;
	
	@GetMapping("/sensors")
	public List<Sensor> getAllsensor() {
				
		return sensorService.getAllSensor();		
	}
	@GetMapping("/sensor/{id}")
	public Sensor getAllsensor(@PathVariable int id) {
				
		return sensorService.findById(id);		
	}
	@PostMapping("/add")
	public Sensor addsensor(@RequestBody Sensor sensor) {
	
		return sensorService.add(sensor);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletesensor(@PathVariable int id) {
		sensorService.delete(id);
	}
	
	@PutMapping("/edit")  
	private Sensor update(@RequestBody Sensor sensor)   
	{  
	return sensor;  
	}  
}
