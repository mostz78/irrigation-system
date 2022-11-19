package com.springboot.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.model.Sensor;

@Repository
public interface SensorDAO extends JpaRepository<Sensor,Integer>{
	@Query("select s from Sensor s where s.workFinishDate < current_date()")
    List<Sensor> findAllWithFinishnDateTimeBefore();

}
