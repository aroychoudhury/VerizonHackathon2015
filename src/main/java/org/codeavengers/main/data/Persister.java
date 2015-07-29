package org.codeavengers.main.data;

import java.io.Serializable;

import org.codeavengers.common.dto.DataObject;
import org.codeavengers.common.exception.DataLayerFailureException;

/**
 * This is a Marker interface used to mark all persister classes. It also
 * defines the basic methods of interaction with the data store.
 * 
 * @author abhishek
 * @since 1.0
 */
public interface Persister {
    /**
     * Identifies this Persister information uniquely.
     * 
     * @return a {@link String} containing values to uniquely identify the
     *         Persister implementation
     * @throws DataLayerFailureException
     * @author abhishek
     * @since 1.0
     */
    String identify() throws DataLayerFailureException;

    /**
     * Adds the element to the Data Store.
     * 
     * @param e
     *            element to be added
     * @return
     * @throws DataLayerFailureException
     * @author abhishek
     * @since 1.0
     */
    <E> boolean add(E e) throws DataLayerFailureException;

    /**
     * Updates the element to the Data Store.
     * 
     * @param e
     *            element to be updated
     * @return <tt>true</tt> if the element was successfully updated
     * @throws DataLayerFailureException
     * @author abhishek
     * @since 1.0
     */
    <E> boolean update(E e) throws DataLayerFailureException;

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
    <K> boolean delete(K id) throws DataLayerFailureException;

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
    DataObject retrieve(Serializable id) throws DataLayerFailureException;
}
