/* Copyright 2015 Code Avengers */

package org.codeavengers.main.data.db.impl;

import java.io.Serializable;

import org.codeavengers.common.dto.DataObject;
import org.codeavengers.common.exception.DataLayerFailureException;
import org.codeavengers.main.data.AbstractPersister;
import org.springframework.stereotype.Repository;

/**
 * Class that provides read only operations on the database.
 * 
 * @author abhishek
 * @since 1.0
 */
@Repository("LocationPersister")
public class LocationPersister extends AbstractPersister {
	/**
	 * @author abhishek
	 * @since 1.0
	 * @see org.codeavengers.main.data.Persister#identify()
	 */
	@Override
	public String identify() throws DataLayerFailureException {
		return LocationPersister.class.getSimpleName();
	}

	/**
	 * @author abhishek
	 * @since 1.0
	 * @see @see org.codeavengers.main.data.Persister#add(java.lang.Object)
	 */
	@Override
	public <E> boolean add(E e) throws DataLayerFailureException {
		return false;
	}

	/**
	 * @author abhishek
	 * @since 1.0
	 * @see @see org.codeavengers.main.data.Persister#update(java.lang.Object)
	 */
	@Override
	public <E> boolean update(E e) throws DataLayerFailureException {
		return false;
	}

	/**
	 * @author abhishek
	 * @since 1.0
	 * @see @see org.codeavengers.main.data.Persister#delete(java.lang.Object)
	 */
	@Override
	public <K> boolean delete(K id) throws DataLayerFailureException {
		return false;
	}

	/**
	 * @author abhishek
	 * @since 1.0
	 * @see @see
	 *      org.codeavengers.main.data.Persister#retrieve(java.io.Serializable)
	 */
	@Override
	public DataObject retrieve(Serializable id) throws DataLayerFailureException {
		return null;
	}
}
