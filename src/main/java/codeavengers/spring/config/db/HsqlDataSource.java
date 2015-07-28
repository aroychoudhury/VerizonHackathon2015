/* Copyright 2015 Roychoudhury, Abhishek */

package org.codeavengers.spring.config.db;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Spring Bean Configuration class to create embedded database.
 * 
 * @author abhishek
 * @since 1.0
 */
@Primary
@Configuration
public class HsqlDataSource {

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
