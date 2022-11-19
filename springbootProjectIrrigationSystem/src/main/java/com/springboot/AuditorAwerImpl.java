package com.springboot;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwerImpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		
		return Optional.of("MostafaTest");
	}

	
}
