package com.lightsoft.hospital;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JackConfig {

	/**
	 * @return
	 */
	@Bean
	public Jackson2ObjectMapperBuilder jacksonMapperBuilder(){
		Jackson2ObjectMapperBuilder jacksonBuilder = Jackson2ObjectMapperBuilder.xml();
		return jacksonBuilder;
	}
	
}
