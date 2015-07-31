/* Copyright 2015 Code Avengers */

package org.codeavengers.main.data.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 * Abstract implementation of Spring's
 * {@link org.springframework.jdbc.core.ResultSetExtractor} which simplifies the
 * extractor implementation.
 * 
 * Extractor works directly with the {@link java.sql.ResultSet} object; an
 * instance of this class is passed to the
 * {@link org.springframework.jdbc.core.JdbcTemplate} which controls the JDBC
 * operations.
 * 
 * @author abhishek
 * @since 1.0
 */
public abstract class AbstractExtractor<T> implements ResultSetExtractor<T> {
    /**
     * @author abhishek
     * @since 1.0
     * @see org.springframework.jdbc.core.ResultSetExtractor#extractData(java.sql.ResultSet)
     */
    @Override
    public T extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        return this.extractDataInternal(resultSet);
    }

    /**
     * This method simplifies the extractor implementation by doing away with
     * the exception declaration in the original overridden method
     * {@link org.springframework.jdbc.core.ResultSetExtractor#extractData(java.sql.ResultSet)}
     * .
     * 
     * @param resultSet
     *            The database {@link java.sql.ResultSet} to be processed
     * @return an wrapped instance of the parsed data
     * @author abhishek
     * @se java.sql.ResultSet
     * @since 1.0
     */
    protected abstract T extractDataInternal(ResultSet resultSet);
}
