package com.kuniwake.agenda.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.kuniwake.agenda.services.DbService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DbService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	String strategy;

	@Bean
	public boolean instanceDb() {
		if (strategy.equals("create")) {
			this.dbService.instanceDb();
		}
		return false;
	}

}
