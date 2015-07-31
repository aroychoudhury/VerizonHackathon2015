/* Copyright 2015 Code Avengers */

package org.codeavengers.main.data.jpa.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.codeavengers.common.dto.entity.Category;
import org.codeavengers.main.data.jpa.AbstractJPAPersister;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Repository;

/**
 * This Class is responsible for all operations on the
 * {@link org.codeavengers.common.dto.entity.Category} entity. This includes all
 * CRUD operations.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.codeavengers.common.dto.entity.Category
 * @see org.codeavengers.main.data.jpa.AbstractJPAPersister
 * @see org.springframework.stereotype.Repository
 * @see javax.transaction.Transactional
 */
@Transactional
@Repository("CategoryPersister")
public class CategoryPersister extends AbstractJPAPersister<Long, Category> {
    /**
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.Persister#identify()
     */
    @Override
    public String identify() {
        return CategoryPersister.class.getSimpleName();
    }

    /**
     * @param location
     *            Instance of the
     *            {@link org.codeavengers.common.dto.entity.Category} to
     *            add/insert
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.jpa.JPAPersister#add(java.lang.Object)
     */
    @Override
    public Category add(Category location) {
        if (null == location) {
            throw new InvalidDataAccessApiUsageException("Category cannot be NULL");
        }
        this.getSession().persist(location);
        return location;
    }

    /**
     * @param location
     *            Instance of the
     *            {@link org.codeavengers.common.dto.entity.Category} to update
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.jpa.JPAPersister#update(java.lang.Object)
     */
    @Override
    public Category update(Category location) {
        if (null == location) {
            throw new InvalidDataAccessApiUsageException("Category cannot be NULL");
        }
        return (Category) this.getSession().merge(location);
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.jpa.JPAPersister#delete(java.lang.Object)
     */
    @Override
    public Category delete(Long id) {
        Category location = this.retrieve(id);
        this.getSession().delete(location);
        return location;
    }

    /**
     * @param id
     *            The unique id by which to fetch the
     *            {@link org.codeavengers.common.dto.entity.Category}
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.JPAPersister#retrieve(java.io.Serializable)
     */
    @Override
    public Category retrieve(Long id) {
        return (Category) this.getSession().get(Category.class, id);
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see org.codeavengers.main.data.jpa.JPAPersister#retrieveAll()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Category> retrieveAll() {
        return this.getSession().createCriteria(Category.class).list();
    }

}
