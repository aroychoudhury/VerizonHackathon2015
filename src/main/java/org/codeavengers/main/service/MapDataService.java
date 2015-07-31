/* Copyright 2015 Roychoudhury, Abhishek */

package org.codeavengers.main.service;

import java.util.List;

import org.codeavengers.common.dto.wrap.CategoryWrapper;
import org.codeavengers.common.dto.wrap.LocationWrapper;

/**
 * TODO
 * @author abhishek
 * @since  1.0
 */
public interface MapDataService {

    List<CategoryWrapper> getCategories();

    CategoryWrapper getCategory(Long categoryId);

    CategoryWrapper addCategory(CategoryWrapper wrapper);

    CategoryWrapper removeCategory(Long categoryId);

    List<LocationWrapper> getLocations();

    LocationWrapper getLocation(Long locationId);

    LocationWrapper addLocation(LocationWrapper wrapper);

    LocationWrapper removeLocation(Long locationId);

}
