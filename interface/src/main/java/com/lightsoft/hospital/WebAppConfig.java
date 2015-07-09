package com.lightsoft.hospital;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Profile("web")
public class WebAppConfig {
	
	@Autowired
	private EmbeddedWebApplicationContext server;
	
	@Autowired
	private Environment environment;

	@Bean
	public ServerProperties serverProperties(){
		ServerProperties serverProperties = new ServerProperties();
		serverProperties.setPort(8088);
		ServletContext servletContext = server.getServletContext();
		String[] strs = environment.getActiveProfiles();
		return serverProperties;
	}
	
	@Bean
	public FilterRegistrationBean registration(MyFilter myFilter) {
	    FilterRegistrationBean registration = new FilterRegistrationBean(myFilter);
	    return registration;
	}
}
