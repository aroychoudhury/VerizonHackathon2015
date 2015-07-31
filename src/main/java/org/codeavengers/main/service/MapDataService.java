/* Copyright 2015 Roychoudhury, Abhishek */

package org.codeavengers.main.service;

import java.util.List;

import org.codeavengers.common.dto.wrap.CategoryWrapper;
import org.codeavengers.common.dto.wrap.LocationWrapper;

/**
 * Gateway to all the Map Data, this class is responsible for manipulation,
 * retreival and removal. It allows access to the internal data through either
 * {@link org.codeavengers.common.dto.entity.LocationMaster} or
 * {@link org.codeavengers.common.dto.entity.Category} database entities.
 * 
 * It however does not directly expose the data access layer entities but works
 * with the REST wrappers instead.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.codeavengers.common.dto.wrap.CategoryWrapper
 * @see org.codeavengers.common.dto.wrap.LocationWrapper
 */
public interface MapDataService {

    /**
     * Retrieves all <b>Categories</b> irrespective of any filters.
     * 
     * @return a {@link java.util.List} of all
     *         {@link org.codeavengers.common.dto.wrap.CategoryWrapper}
     * @author abhishek
     * @since 1.0
     */
    List<CategoryWrapper> getCategories();

    /**
     * Retrieves <b>Category</b> information by id. This method gives a more
     * indepth data for the <b>Category</b> along with all the relationships
     * defined.
     * 
     * @param categoryId
     *            Category ID to be used for the retrieval
     * @return an instance of
     *         {@link org.codeavengers.common.dto.wrap.CategoryWrapper} reteived
     *         by id
     * @author abhishek
     * @since 1.0
     */
    CategoryWrapper getCategory(Long categoryId);

    /**
     * This method allows adding a new <b>Category</b> or updating an existing
     * one. This decision is taken based on whether the Category ID is a valid
     * number.
     * 
     * @param wrapper
     *            {@link org.codeavengers.common.dto.wrap.CategoryWrapper} to be
     *            added as a
     *            {@link org.codeavengers.common.dto.entity.Category}
     * @return
     * @author abhishek
     * @since 1.0
     */
    CategoryWrapper addCategory(CategoryWrapper wrapper);

    /**
     * This method deletes an existing <b>Category</b> from the database.
     * 
     * @param categoryId
     *            Category ID to be used for the removal
     * @return the deleted non-persitent instance of the Category
     * @author abhishek
     * @since 1.0
     */
    CategoryWrapper removeCategory(Long categoryId);

    /**
     * Retrieves all <b>LocationMasters</b> irrespective of any filters.
     * 
     * @return a {@link java.util.List} of all
     *         {@link org.codeavengers.common.dto.wrap.LocationWrapper}
     * @author abhishek
     * @since 1.0
     */
    List<LocationWrapper> getLocations();

    /**
     * Retrieves <b>LocationMaster</b> information by id. This method gives a
     * more indepth data for the <b>LocationMaster</b> with all the
     * relationships defined.
     * 
     * @param locationId
     *            Location ID to be used for the retrieval
     * @return an instance of
     *         {@link org.codeavengers.common.dto.wrap.LocationWrapper} reteived
     *         by id
     * @author abhishek
     * @since 1.0
     */
    LocationWrapper getLocation(Long locationId);

    /**
     * This method allows adding a new <b>LocationMaster</b> or updating an
     * existing one. This decision is taken based on whether the Location ID is
     * a valid number.
     * 
     * @param wrapper
     *            {@link org.codeavengers.common.dto.wrap.LocationWrapper} to be
     *            added as a
     *            {@link org.codeavengers.common.dto.entity.LocationMaster}
     * @return
     * @author abhishek
     * @since 1.0
     */
    LocationWrapper addLocation(LocationWrapper wrapper);

    /**
     * This method deletes an existing <b>LocationMaster</b> from the database.
     * 
     * @param locationId
     *            Location ID to be used for the removal
     * @return the deleted non-persitent instance of the Category
     * @author abhishek
     * @since 1.0
     */
    LocationWrapper removeLocation(Long locationId);

}
