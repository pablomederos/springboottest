package com.pgmsoft.profesores.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@EnableAutoConfiguration(exclude={HibernateJpaAutoConfiguration.class})
public class DatabaseConfiguration {

	@Bean
	public LocalSessionFactoryBean sessionFactory () {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("com.pgmsoft.profesores.model");
		sessionFactoryBean.setHibernateProperties(hibernatePorperties());
		
		return sessionFactoryBean;
	}
	
	@Bean
	public DataSource dataSource () {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5433/minterior");
		dataSource.setUsername("postgres");
		dataSource.setPassword("Tspass3951");
		
		return dataSource;
	}
	
	public Properties hibernatePorperties () {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("show_sql", true);
		properties.put("hibernate.jdbc.lob.non_contextual_creation", true);
		properties.put("hibernate.hbm2ddl.auto", "create");
		
		return properties;
	}
	
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager () {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
}
