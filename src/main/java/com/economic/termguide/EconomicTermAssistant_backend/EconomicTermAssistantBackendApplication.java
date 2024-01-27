package com.economic.termguide.EconomicTermAssistant_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class EconomicTermAssistantBackendApplication extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(EconomicTermAssistantBackendApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EconomicTermAssistantBackendApplication.class);
	}

}
