/* Copyright 2015 Code Avengers */

package org.codeavengers.main.data.db;

import org.codeavengers.common.dto.DBEntity;
import org.codeavengers.main.data.Persister;

/**
 * DatabasePersister class which defines interactions with the Database over
 * JDBC only. For queries or direct database manipulations this class should be
 * used.
 * 
 * @author abhishek
 * @since 1.0
 */
public interface DatabasePersister extends Persister {
    /**
     * This method simply allows the execution of a query without any additional
     * query parameters or extractors for data processing.
     * 
     * @param query
     *            Query to be executed
     * @return The DB Entity to be populated with the query results
     * @author abhishek
     * @since 1.0
     */
    DBEntity query(String query);
}
