package com.example.pma.denpendInjectEx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManufactureConfig {
	
	//the configuration annotation allows you create code to reused later 
	//this is a similar concept to procs in Ruby
	
	@Bean
	public Cars newCar() {
		return new Cars(new Engine(), new Door(), new Tire());
	}
}
