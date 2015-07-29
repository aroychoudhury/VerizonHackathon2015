/* Copyright 2015 Code Avengers */

package org.codeavengers.spring.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.codeavengers.common.exception.DataLayerFailureException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 * TODO
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

    protected abstract T extractDataInternal(ResultSet resultSet) throws DataLayerFailureException;
}
