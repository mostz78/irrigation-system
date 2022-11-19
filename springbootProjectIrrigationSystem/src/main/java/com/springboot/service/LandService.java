package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.LandDAO;
import com.springboot.model.Land;

@Service
public class LandService {

	@Autowired
	private LandDAO landDAO;
	
	public List<Land> getAllLand(){
		return landDAO.findAll();	
	}
	
	public Land findById(int id) {
		return landDAO.findById(id).get();
	}
	
	public Land add(Land land) {
		land.setStatus("New (don't need irrigate)");
		return landDAO.save(land);
	}
	
	public void delete(int id) {
		landDAO.deleteById(id);
		
	}
	
	
	public Land Update(Land land) {
		return landDAO.save(land);
	}
}
