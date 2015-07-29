/* Copyright 2015 Code Avengers */

package org.codeavengers.main.data.db;

import java.sql.Connection;

import org.codeavengers.common.exception.DataLayerFailureException;

/**
 * Persister class which defines interactions with the Database only.
 * 
 * @author abhishek
 * @since 1.0
 */
public interface DatabasePersister {
    /**
     * Sets up the {@link javax.sql.DataSource} by looking up the JNDI in the
     * server.
     * 
     * @param dataSourceJndi
     *            jndi name which uniquely identifies the
     *            {@link javax.sql.DataSource} on the server
     * @throws DataLayerFailureException
     *             {@inheritDoc}
     * @author abhishek
     * @since 1.0
     * @see java.lang.String
     * @see javax.sql.DataSource
     */
    void setDataSource(String dataSourceJndi) throws DataLayerFailureException;

    /**
     * Retrieves the connection to be used for the operation. Connection is
     * obtained from the {@link javax.sql.DataSource}.
     * 
     * @return the connection obtained
     * @throws DataLayerFailureException
     *             {@inheritDoc}
     * @author abhishek
     * @since 1.0
     * @see java.sql.Connection
     */
    Connection connect() throws DataLayerFailureException;
}
