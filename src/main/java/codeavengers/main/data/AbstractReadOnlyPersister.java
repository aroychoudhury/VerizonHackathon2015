/* Copyright 2015 Roychoudhury, Abhishek */

package org.codeavengers.main.data;

import org.codeavengers.common.exception.DataLayerFailureException;
import org.codeavengers.spring.db.utils.JdbcExecuter;

/**
 * Read-only implementation of the Persister interface. This class implements
 * the data manipulation methods defined in the interface and enables access to
 * only the read-only methods.
 * 
 * @author abhishek
 * @since 1.0
 */
public abstract class AbstractReadOnlyPersister extends JdbcExecuter implements Persister {
    /**
     * @throws DataLayerFailureException
     *             {@inheritDoc}
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.Persister#add(java.lang.Object)
     */
    @Override
    public final <E> boolean add(E e) throws DataLayerFailureException {
        throw new DataLayerFailureException(new UnsupportedOperationException());
    }

    /**
     * @throws DataLayerFailureException
     *             {@inheritDoc}
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.Persister#update(java.lang.Object)
     */
    @Override
    public <E> boolean update(E e) throws DataLayerFailureException {
        throw new DataLayerFailureException(new UnsupportedOperationException());
    }

    /**
     * @throws DataLayerFailureException
     *             {@inheritDoc}
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.Persister#delete(java.lang.Object)
     */
    @Override
    public <K> boolean delete(K id) throws DataLayerFailureException {
        throw new DataLayerFailureException(new UnsupportedOperationException());
    }
}
