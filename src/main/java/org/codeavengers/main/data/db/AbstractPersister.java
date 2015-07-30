/* Copyright 2015 Code Avengers */

package org.codeavengers.main.data.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 * Abstract implementation of the Persister interface. This class wraps an
 * instance of {@link org.springframework.jdbc.core.JdbcTemplate}, which allows
 * access to utility JDBC methods.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.codeavengers.main.data.db.DatabasePersister
 * @see org.springframework.jdbc.core.JdbcTemplate
 */
public abstract class AbstractPersister implements DatabasePersister {
    protected JdbcTemplate template = null;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    protected <T> T executeQuery(String query, ResultSetExtractor<T> extractor) {
        return this.template.query(query, extractor);
    }
}
