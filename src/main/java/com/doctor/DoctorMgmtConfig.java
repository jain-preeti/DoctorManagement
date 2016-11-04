package com.doctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
public class DoctorMgmtConfig {
 

   	
    @Value("${datasource.doctor.driverClassName}")
	private String className;
	@Value("${datasource.doctor.url}")
	private String url;
	@Value("${datasource.doctor.username}")
	private String username;
	@Value("${datasource.doctor.password}")
	private String password;
	
		@Bean
	public DataSource getDataSource() {
	
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(className);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
	
		return new JdbcTemplate(getDataSource());
		
	}
    
}
