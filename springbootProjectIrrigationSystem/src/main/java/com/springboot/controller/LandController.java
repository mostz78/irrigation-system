package com.springboot.controller;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Land;
import com.springboot.service.LandService;

@RestController
@RequestMapping("/land")
public class LandController {
	@Autowired	
	private LandService landService;
	
	@GetMapping("/lands")
	public List<Land> getAllLand() {
				
		return landService.getAllLand();		
	}
	@GetMapping("/land/{id}")
	public Land getAllLand(@PathVariable int id) {
				
		return landService.findById(id);		
	}
	@PostMapping("/add")
	public Land addLand(@RequestBody Land land) {	
		return landService.add(land);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteLand(@PathVariable int id) {
		landService.delete(id);
	}
	
	@PutMapping("/edit")  
	private Land update(@RequestBody Land Land)   
	{  
		landService.Update(Land);  
	return Land;  
	}  
	
}
