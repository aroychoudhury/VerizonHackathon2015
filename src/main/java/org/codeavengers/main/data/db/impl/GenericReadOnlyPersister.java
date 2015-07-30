/* Copyright 2015 Code Avengers */

package org.codeavengers.main.data.db.impl;

import org.codeavengers.common.dto.DataObject;
import org.codeavengers.main.data.db.AbstractPersister;
import org.codeavengers.main.data.db.extractor.ResultsExtractor;
import org.springframework.stereotype.Repository;

/**
 * Class that provides read only operations on the database.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.codeavengers.main.data.db.AbstractPersister
 * @see org.springframework.stereotype.Repository
 */
@Repository("GenericReadOnlyPersister")
public class GenericReadOnlyPersister extends AbstractPersister {
    /**
     * 
     * @author abhishek
     * @since 1.0
     */
    public DataObject query(String query) {
        if (null == query) {
            
        }
        return this.executeQuery("SELECT * FROM users", new ResultsExtractor());
    }

    /**
     * @author abhishek
     * @since  1.0
     * @see org.codeavengers.main.data.Persister#identify()
     */
    @Override
    public String identify() {
        return GenericReadOnlyPersister.class.getSimpleName();
    }
}
