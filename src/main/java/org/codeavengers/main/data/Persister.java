package org.codeavengers.main.data;

/**
 * This is a Marker interface used to mark all persister classes. It also
 * defines the base methods required to qualify as a Persister.
 * 
 * @author abhishek
 * @since 1.0
 */
public interface Persister {
    /**
     * Identifies this Persister uniquely.
     * 
     * @return a {@link java.lang.String} containing values to uniquely identify
     *         the Persister implementation
     * @throws DataLayerFailureException
     * @author abhishek
     * @since 1.0
     */
    String identify();
}
