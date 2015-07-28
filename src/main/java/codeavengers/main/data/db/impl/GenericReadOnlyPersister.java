/* Copyright 2015 Roychoudhury, Abhishek */

package org.codeavengers.main.data.db.impl;

import java.io.Serializable;

import org.codeavengers.common.dto.DataObject;
import org.codeavengers.common.exception.DataLayerFailureException;
import org.codeavengers.main.data.AbstractReadOnlyPersister;
import org.codeavengers.main.data.db.extractor.ResultsExtractor;
import org.springframework.stereotype.Repository;

/**
 * Class that provides read only operations on the database.
 * 
 * @author abhishek
 * @since 1.0
 */
@Repository("GenericReadOnlyPersister")
public class GenericReadOnlyPersister extends AbstractReadOnlyPersister {
    /**
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.Persister#retrieve(java.lang.Object)
     */
    @Override
    public DataObject retrieve(Serializable id) throws DataLayerFailureException {
        return this.test("SELECT * FROM users", new ResultsExtractor());
    }

    /**
     * @author abhishek
     * @since  1.0
     * @see org.codeavengers.main.data.Persister#identify()
     */
    @Override
    public String identify() throws DataLayerFailureException {
        return GenericReadOnlyPersister.class.getSimpleName();
    }
}
