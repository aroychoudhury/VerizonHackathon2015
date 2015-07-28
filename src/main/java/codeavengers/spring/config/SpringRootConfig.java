/* Copyright 2015 Roychoudhury, Abhishek */

package org.codeavengers.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Initializes the Spring Root context.
 * 
 * @author abhishek
 * @since 1.0
 */
@ComponentScan({
    "org.codeavengers"
})
@Configuration
public class SpringRootConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

}
