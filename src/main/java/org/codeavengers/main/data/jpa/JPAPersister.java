package org.codeavengers.main.data.jpa;

import org.codeavengers.main.data.Persister;

/**
 * This is a Marker interface used to mark all persister classes. It also
 * defines the basic methods of interaction with the data store.
 * 
 * @author abhishek
 * @since 1.0
 */
public interface JPAPersister<K, V> extends Persister {
    /**
     * Adds the element to the Data Store.
     * 
     * @param v
     *            element to be added
     * @return
     * @throws DataLayerFailureException
     * @author abhishek
     * @since 1.0
     */
    V add(V v);

    /**
     * Updates the element to the Data Store.
     * 
     * @param v
     *            element to be updated
     * @return <tt>true</tt> if the element was successfully updated
     * @throws DataLayerFailureException
     * @author abhishek
     * @since 1.0
     */
    V update(V v);

    /**
     * Deletes the requested data from the data store using the id.
     * 
     * @param id
     *            unique identifier for the element to be deleted
     * @return <tt>true</tt> if the element was successfully deleted
     * @throws DataLayerFailureException
     *             {@inheritDoc}
     * @author abhishek
     * @since 1.0
     */
    V delete(K id);

    /**
     * Retrieves the requested data from the data store in question. The id is
     * the unique identifier used to retrieve the data.
     * 
     * @param id
     *            unique identifier for the element to be retrieved
     * @return the returned element
     * @author abhishek
     * @since 1.0
     */
    V retrieve(K id);
}
