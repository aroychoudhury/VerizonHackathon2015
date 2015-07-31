/* Copyright 2015 Roychoudhury, Abhishek */

package org.codeavengers.common.dto.wrap;

import java.util.ArrayList;
import java.util.List;

import org.codeavengers.common.dto.Rest;
import org.codeavengers.common.dto.entity.Category;
import org.codeavengers.common.dto.entity.LocationCategoryAssn;
import org.codeavengers.common.dto.entity.LocationMaster;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * TODO
 * 
 * @author abhishek
 * @since 1.0
 * @see org.codeavengers.common.dto.Rest
 * @see org.codeavengers.common.dto.entity.Category
 */
@JsonInclude(Include.NON_EMPTY)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class CategoryWrapper extends Category implements Rest {
    private static final long serialVersionUID = 6665582077591986873L;
    private List<LocationWrapper> locns  = null;
    private Long                  assnId = null;
    private String                unit   = null;
    private String                value  = null;

    /**
     * @return the locations
     * @since 1.0
     * @see List<LocationWrapper>
     */
    public List<LocationWrapper> getLocns() {
        return locns;
    }

    /**
     * @param locations
     *            the locations to set
     * @since 1.0
     * @see List<LocationWrapper>
     */
    public void setLocns(List<LocationWrapper> locations) {
        this.locns = locations;
    }

    /**
     * @return the assnId
     * @since 1.0
     * @see Long
     */
    public Long getAssnId() {
        return assnId;
    }

    /**
     * @param assnId
     *            the assnId to set
     * @since 1.0
     * @see Long
     */
    public void setAssnId(Long assnId) {
        this.assnId = assnId;
    }

    /**
     * @return the unit
     * @since 1.0
     * @see String
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit
     *            the unit to set
     * @since 1.0
     * @see String
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return the value
     * @since 1.0
     * @see String
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     * @since 1.0
     * @see String
     */
    public void setValue(String value) {
        this.value = value;
    }

    public static CategoryWrapper liteConvert(Category category) {
        CategoryWrapper wrapper = new CategoryWrapper();
        if (null == category) {
            return wrapper;
        }
        wrapper.setCatId(category.getCatId());
        wrapper.setCatDesc(category.getCatDesc());
        wrapper.setAssns(null); // prevent this turning up in response
        return wrapper;
    }

    public static Category liteRevert(CategoryWrapper wrapper) {
        Category category = new Category();
        if (null == wrapper) {
            return category;
        }
        category.setCatId(wrapper.getCatId());
        category.setCatDesc(wrapper.getCatDesc());
        return category;
    }

    public static CategoryWrapper deepConvert(Category category) {
        CategoryWrapper wrapper = CategoryWrapper.liteConvert(category);

        List<LocationCategoryAssn> associations = category.getAssns();
        if (null != associations && !associations.isEmpty()) {
            List<LocationWrapper> locations = new ArrayList<LocationWrapper>(associations.size());
            for (LocationCategoryAssn association : associations) {
                LocationWrapper locWrapper = LocationWrapper.liteConvert(association.getLocation());
                locWrapper.setUnit(association.getCategoryField());
                locWrapper.setValue(association.getCategoryValue());
                locWrapper.setAssnId(association.getAssnId());

                locations.add(locWrapper);
            }
            wrapper.setLocns(locations);
        }
        return wrapper;
    }

    public static Category deepRevert(CategoryWrapper wrapper) {
        Category category = CategoryWrapper.liteRevert(wrapper);

        List<LocationWrapper> locations = wrapper.getLocns();
        if (null != locations && !locations.isEmpty()) {
            List<LocationCategoryAssn> associations = new ArrayList<LocationCategoryAssn>(locations.size());
            category.setAssns(associations);

            for (LocationWrapper locWrapper : locations) {
                LocationMaster location = LocationWrapper.liteRevert(locWrapper);
                location.setAssns(associations);

                LocationCategoryAssn association = new LocationCategoryAssn();
                association.setCategoryField(locWrapper.getUnit());
                association.setCategoryValue(locWrapper.getValue());
                association.setAssnId(locWrapper.getAssnId());
                association.setCategory(category);
                association.setLocation(location);

                associations.add(association);
            }
        }
        return category;
    }
}
