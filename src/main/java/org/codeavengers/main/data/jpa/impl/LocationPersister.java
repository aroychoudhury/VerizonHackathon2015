/* Copyright 2015 Code Avengers */

package org.codeavengers.main.data.jpa.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.codeavengers.common.dto.entity.LocationMaster;
import org.codeavengers.main.data.jpa.AbstractJPAPersister;
import org.hibernate.Criteria;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Repository;

/**
 * This Class is responsible for all operations on the
 * {@link org.codeavengers.common.dto.entity.LocationMaster} entity. This
 * includes all CRUD operations.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.codeavengers.common.dto.entity.LocationMaster
 * @see org.codeavengers.main.data.jpa.AbstractJPAPersister
 * @see org.springframework.stereotype.Repository
 * @see javax.transaction.Transactional
 */
@Transactional
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
     * @param location
     *            Instance of the
     *            {@link org.codeavengers.common.dto.entity.LocationMaster} to
     *            add/insert
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.jpa.JPAPersister#add(java.lang.Object)
     */
    @Override
    public LocationMaster add(LocationMaster location) {
        if (null == location) {
            throw new InvalidDataAccessApiUsageException("LocationWrapper cannot be NULL");
        }
        this.getSession().persist(location);
        return location;
    }

    /**
     * @param location
     *            Instance of the
     *            {@link org.codeavengers.common.dto.entity.LocationMaster} to
     *            update
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.jpa.JPAPersister#update(java.lang.Object)
     */
    @Override
    public LocationMaster update(LocationMaster location) {
        if (null == location) {
            throw new InvalidDataAccessApiUsageException("LocationWrapper cannot be NULL");
        }
        return (LocationMaster) this.getSession().merge(location);
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.jpa.JPAPersister#delete(java.lang.Object)
     */
    @Override
    public LocationMaster delete(Long id) {
        LocationMaster location = this.retrieve(id);
        if (null == location) {
            throw new DataRetrievalFailureException("No Location found by that ID");
        }
        this.getSession().delete(location);
        return location;
    }

    /**
     * @param id
     *            The unique id by which to fetch the
     *            {@link org.codeavengers.common.dto.entity.LocationMaster}
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.JPAPersister#retrieve(java.io.Serializable)
     */
    @Override
    public LocationMaster retrieve(Long id) {
        return (LocationMaster) this.getSession().get(LocationMaster.class, id);
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.jpa.JPAPersister#retrieveAll()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<LocationMaster> retrieveAll() {
        return this.getSession().createCriteria(LocationMaster.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

}
