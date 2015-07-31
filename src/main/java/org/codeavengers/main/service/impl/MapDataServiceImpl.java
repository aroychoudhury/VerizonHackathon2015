/* Copyright 2015 Roychoudhury, Abhishek */

package org.codeavengers.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.codeavengers.common.dto.entity.Category;
import org.codeavengers.common.dto.entity.LocationMaster;
import org.codeavengers.common.dto.wrap.CategoryWrapper;
import org.codeavengers.common.dto.wrap.LocationWrapper;
import org.codeavengers.main.data.jpa.JPAPersister;
import org.codeavengers.main.service.MapDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * TODO
 * 
 * @author abhishek
 * @since 1.0
 */
@Transactional
@Service("MapDataService")
public class MapDataServiceImpl implements MapDataService {
    @Autowired
    @Qualifier("CategoryPersister")
    private JPAPersister<Long, Category>       categoryPersister = null;

    @Autowired
    @Qualifier("LocationPersister")
    private JPAPersister<Long, LocationMaster> locationPersister = null;

    /**
     * @author abhishek
     * @since  1.0
     * @see org.codeavengers.main.service.MapDataService#getCategories()
     */
    @Override
    public List<CategoryWrapper> getCategories() {
        List<Category> categories = categoryPersister.retrieveAll();
        if (null != categories && !categories.isEmpty()) {
            List<CategoryWrapper> wrappers = new ArrayList<CategoryWrapper>(categories.size());
            for (Category category : categories) {
               wrappers.add(CategoryWrapper.liteConvert(category)); 
            }
            return wrappers;
        }
        return new ArrayList<CategoryWrapper>(1);
    }

    /**
     * @author abhishek
     * @since  1.0
     * @see org.codeavengers.main.service.MapDataService#getCategory(java.lang.Long)
     */
    @Override
    public CategoryWrapper getCategory(Long categoryId) {
        if (null == categoryId || 0L == categoryId.longValue()) {
            throw new IllegalArgumentException("Category ID cannot be empty");
        }
        return CategoryWrapper.deepConvert(categoryPersister.retrieve(categoryId));
    }

    /**
     * @author abhishek
     * @since  1.0
     * @see org.codeavengers.main.service.MapDataService#addCategory(org.codeavengers.common.dto.wrap.CategoryWrapper)
     */
    @Override
    public CategoryWrapper addCategory(CategoryWrapper wrapper) {
        if (null == wrapper) {
            throw new IllegalArgumentException("Category cannot be empty");
        }
        Long categoryId = wrapper.getCatId();
        if (null != categoryId && 0L != categoryId.longValue()) {
            return CategoryWrapper.deepConvert(categoryPersister.update(CategoryWrapper.deepRevert(wrapper)));
        }
        return CategoryWrapper.deepConvert(categoryPersister.add(CategoryWrapper.deepRevert(wrapper)));
    }

    /**
     * @author abhishek
     * @since  1.0
     * @see org.codeavengers.main.service.MapDataService#removeCategory(java.lang.Long)
     */
    @Override
    public CategoryWrapper removeCategory(Long categoryId) {
        if (null == categoryId || 0L == categoryId.longValue()) {
            throw new IllegalArgumentException("Category ID cannot be empty");
        }
        return CategoryWrapper.deepConvert(categoryPersister.delete(categoryId));
    }

    /**
     * @author abhishek
     * @since  1.0
     * @see org.codeavengers.main.service.MapDataService#getLocations()
     */
    @Override
    public List<LocationWrapper> getLocations() {
        List<LocationMaster> locations = locationPersister.retrieveAll();
        if (null != locations && !locations.isEmpty()) {
            List<LocationWrapper> wrappers = new ArrayList<LocationWrapper>(locations.size());
            for (LocationMaster location : locations) {
               wrappers.add(LocationWrapper.liteConvert(location)); 
            }
            return wrappers;
        }
        return new ArrayList<LocationWrapper>(1);
    }

    /**
     * @author abhishek
     * @since  1.0
     * @see org.codeavengers.main.service.MapDataService#getLocation(java.lang.Long)
     */
    @Override
    public LocationWrapper getLocation(Long locationId) {
        if (null == locationId || 0L == locationId.longValue()) {
            throw new IllegalArgumentException("Location ID cannot be empty");
        }
        return LocationWrapper.deepConvert(locationPersister.retrieve(locationId));
    }

    /**
     * @author abhishek
     * @since  1.0
     * @see org.codeavengers.main.service.MapDataService#addLocation(org.codeavengers.common.dto.wrap.LocationWrapper)
     */
    @Override
    public LocationWrapper addLocation(LocationWrapper wrapper) {
        if (null == wrapper) {
            throw new IllegalArgumentException("Location cannot be empty");
        }
        Long locationId = wrapper.getLocId();
        if (null != locationId && 0L != locationId.longValue()) {
            return LocationWrapper.deepConvert(locationPersister.update(LocationWrapper.deepRevert(wrapper)));
        }
        return LocationWrapper.deepConvert(locationPersister.add(LocationWrapper.deepRevert(wrapper)));
    }

    /**
     * @author abhishek
     * @since  1.0
     * @see org.codeavengers.main.service.MapDataService#removeLocation(java.lang.Long)
     */
    @Override
    public LocationWrapper removeLocation(Long locationId) {
        if (null == locationId || 0L == locationId.longValue()) {
            throw new IllegalArgumentException("Location ID cannot be empty");
        }
        return LocationWrapper.deepConvert(locationPersister.delete(locationId));
    }
}
