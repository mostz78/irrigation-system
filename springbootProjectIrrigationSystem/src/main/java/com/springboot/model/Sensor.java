package com.springboot.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Sensor {

	@Id
	@GeneratedValue
	private int id;	
	
	private String name;
	
	@Column(name = "isactive", nullable = false, columnDefinition = "boolean default true") 
	private boolean active;
	
	private LocalDateTime workStartDate;
	
	private LocalDateTime workFinishDate;
	
	private String lastLandWorked;
	
	@OneToOne(targetEntity = Land.class)
	private Land land;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getWorkStartDate() {
		return workStartDate;
	}

	public void setWorkStartDate(LocalDateTime workStartDate) {
		this.workStartDate = workStartDate;
	}

	public LocalDateTime getWorkFinishDate() {
		return workFinishDate;
	}

	public void setWorkFinishDate(LocalDateTime workFinishDate) {
		this.workFinishDate = workFinishDate;
	}

	public String getLastLandWorked() {
		return lastLandWorked;
	}

	public void setLastLandWorked(String lastLandWorked) {
		this.lastLandWorked = lastLandWorked;
	}

	public Land getLand() {
		return land;
	}

	public void setLand(Land land) {
		this.land = land;
	}

	public Sensor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
