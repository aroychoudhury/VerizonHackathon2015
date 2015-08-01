/* Copyright 2015 Code Avengers */

package org.codeavengers.main.data.db.impl;

import javax.transaction.Transactional;

import org.codeavengers.common.dto.DBEntity;
import org.codeavengers.main.data.db.AbstractPersister;
import org.codeavengers.main.data.db.extractor.ResultsExtractor;
import org.springframework.stereotype.Repository;

/**
 * Class that provides generic read only operations on the database.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.codeavengers.main.data.db.AbstractPersister
 * @see org.springframework.stereotype.Repository
 * @see javax.transaction.Transactional
 */
@Transactional
@Repository("GenericReadOnlyPersister")
public class GenericReadOnlyPersister extends AbstractPersister {
    /**
     * 
     * @author abhishek
     * @since 1.0
     */
    @Override
    public DBEntity query(String query) {
        if (null == query || "".equals(query.trim())) {
            throw new IllegalArgumentException();
        }
        return this.executeQuery(query, new ResultsExtractor());
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.Persister#identify()
     */
    @Override
    public String identify() {
        return GenericReadOnlyPersister.class.getSimpleName();
    }
}
