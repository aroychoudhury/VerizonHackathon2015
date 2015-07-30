package org.codeavengers.main.data;


/**
 * This is a Marker interface used to mark all persister classes. It also
 * defines the basic methods of interaction with the data store.
 * 
 * @author abhishek
 * @since 1.0
 */
public interface Persister {
    /**
     * Identifies this JPAPersister information uniquely.
     * 
     * @return a {@link String} containing values to uniquely identify the
     *         JPAPersister implementation
     * @throws DataLayerFailureException
     * @author abhishek
     * @since 1.0
     */
    String identify();
}
