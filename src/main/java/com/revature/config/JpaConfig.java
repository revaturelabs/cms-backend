package com.revature.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.revature.repository")
public class JpaConfig {

	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(System.getenv("SPRING_URL"));
		ds.setUsername(System.getenv("SPRING_USERNAME"));
		ds.setPassword(System.getenv("SPRING_PASSWORD"));
		ds.setDriverClassName("org.postgresql.Driver");
		return ds;
	}
}
