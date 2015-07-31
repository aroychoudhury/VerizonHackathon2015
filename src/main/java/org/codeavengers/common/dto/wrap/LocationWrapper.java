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
 */
@JsonInclude(Include.NON_EMPTY)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class LocationWrapper extends LocationMaster implements Rest {
    private static final long serialVersionUID = 771354173420804901L;
    private List<CategoryWrapper> cates  = null;
    private Long                  assnId = null;
    private String                unit   = null;
    private String                value  = null;

    /**
     * @return the categories
     * @since 1.0
     * @see List<CategoryWrapper>
     */
    public List<CategoryWrapper> getCates() {
        return cates;
    }

    /**
     * @param categories
     *            the categories to set
     * @since 1.0
     * @see List<CategoryWrapper>
     */
    public void setCates(List<CategoryWrapper> cates) {
        this.cates = cates;
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

    public static LocationWrapper liteConvert(LocationMaster location) {
        LocationWrapper wrapper = new LocationWrapper();
        if (null == location) {
            return wrapper;
        }
        wrapper.setLocId(location.getLocId());
        wrapper.setArea(location.getArea());
        wrapper.setCode(location.getCode());
        wrapper.setLat(location.getLat());
        wrapper.setLon(location.getLon());
        wrapper.setAssns(null); // prevent this turning up in response
        return wrapper;
    }

    public static LocationMaster liteRevert(LocationWrapper wrapper) {
        LocationMaster location = new LocationMaster();
        if (null == wrapper) {
            return location;
        }
        location.setLocId(wrapper.getLocId());
        location.setArea(wrapper.getArea());
        location.setCode(wrapper.getCode());
        location.setLat(wrapper.getLat());
        location.setLon(wrapper.getLon());
        return location;
    }

    public static LocationWrapper deepConvert(LocationMaster location) {
        LocationWrapper wrapper = LocationWrapper.liteConvert(location);

        List<LocationCategoryAssn> associations = location.getAssns();
        if (null != associations && !associations.isEmpty()) {
            List<CategoryWrapper> categories = new ArrayList<CategoryWrapper>(associations.size());
            for (LocationCategoryAssn association : associations) {
                CategoryWrapper catWrapper = CategoryWrapper.liteConvert(association.getCategory());
                catWrapper.setUnit(association.getCategoryField());
                catWrapper.setValue(association.getCategoryValue());
                catWrapper.setAssnId(association.getAssnId());

                categories.add(catWrapper);
            }
            wrapper.setCates(categories);
        }
        return wrapper;
    }

    public static LocationMaster deepRevert(LocationWrapper wrapper) {
        LocationMaster location = LocationWrapper.liteRevert(wrapper);

        List<CategoryWrapper> categories = wrapper.getCates();
        if (null != categories && !categories.isEmpty()) {
            List<LocationCategoryAssn> associations = new ArrayList<LocationCategoryAssn>(categories.size());
            location.setAssns(associations);

            for (CategoryWrapper catWrapper : categories) {
                Category category = CategoryWrapper.liteRevert(catWrapper);
                category.setAssns(associations);

                LocationCategoryAssn association = new LocationCategoryAssn();
                association.setCategoryField(catWrapper.getUnit());
                association.setCategoryValue(catWrapper.getValue());
                association.setAssnId(catWrapper.getAssnId());
                association.setCategory(category);
                association.setLocation(location);

                associations.add(association);
            }
        }
        return location;
    }
}
