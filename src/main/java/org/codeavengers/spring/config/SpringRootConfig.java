/* Copyright 2015 Code Avengers */

package org.codeavengers.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.codeavengers.common.dto.entity.Category;
import org.codeavengers.common.dto.entity.LocationCategoryAssn;
import org.codeavengers.common.dto.entity.LocationMaster;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Initializes the Spring Root context.
 * 
 * @author abhishek
 * @since 1.0
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({ "org.codeavengers.main" })
public class SpringRootConfig {
	public SpringRootConfig() {
		System.out.println("Spring Root");
	}

	@Autowired
	DataSource dataSource;

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(this.dataSource);
		sessionBuilder.addProperties(this.hibernateProperties());
		sessionBuilder.addAnnotatedClasses(LocationMaster.class, Category.class, LocationCategoryAssn.class);
		return sessionBuilder.buildSessionFactory();
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		properties.put("hibernate.format_sql", "false");
		return properties;
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	// jdbc:hsqldb:mem:testdb
	@Bean
	public DataSource dataSource() {
		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL)
				.addScript("/db/sql/create-tables.sql")
				.addScript("/db/sql/insert-data.sql")
				.build();
		return db;
	}
}
