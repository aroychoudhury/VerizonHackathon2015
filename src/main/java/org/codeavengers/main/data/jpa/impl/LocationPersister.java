/* Copyright 2015 Code Avengers */

package org.codeavengers.main.data.jpa.impl;

import org.codeavengers.common.dto.entity.LocationMaster;
import org.codeavengers.main.data.jpa.AbstractJPAPersister;
import org.springframework.stereotype.Repository;

/**
 * Class that provides read only operations on the database.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.codeavengers.main.data.jpa.AbstractJPAPersister
 * @see org.springframework.stereotype.Repository
 */
@Repository("LocationPersister")
public class LocationPersister extends AbstractJPAPersister<Long, LocationMaster> {
	/**
	 * @author abhishek
	 * @since 1.0
	 * @see org.codeavengers.main.data.Persister#identify()
	 */
	@Override
	public String identify() {
		return LocationPersister.class.getSimpleName();
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.JPAPersister#add(org.codeavengers.common.dto.DataObject)
     */
    @Override
    public boolean add(LocationMaster e) {
        return false;
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.Persister#update(org.codeavengers.common.dto.DataObject)
     */
    @Override
    public boolean update(LocationMaster e) {
        return false;
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.JPAPersister#delete(java.io.Serializable)
     */
    @Override
    public boolean delete(Long id) {
        return false;
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.JPAPersister#retrieve(java.io.Serializable)
     */
    @Override
    public LocationMaster retrieve(Long id) {
        return null;
    }

}
