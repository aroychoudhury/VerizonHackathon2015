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
 * This class wraps the {@link org.codeavengers.common.dto.entity.Category}
 * database entity.
 * 
 * The {@link org.codeavengers.common.dto.Rest} interface that it implements
 * indicates that this class participates in REST End-point operations.
 * 
 * Further the {@link com.fasterxml.jackson.annotation.JsonInclude} annotation
 * indicates that the generated JSON will not contain any <i>Empty</i> (e.g.
 * {@link java.util.List}) or <i>Null</i> data.
 * 
 * The {@link com.fasterxml.jackson.annotation.JsonIdentityInfo} is added to
 * prevent against recursive object tree.
 * 
 * This class also defines utility methods to convert between the REST-side
 * implementations and the DB-side ones.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.codeavengers.common.dto.Rest
 * @see org.codeavengers.common.dto.entity.Category
 */
@JsonInclude(Include.NON_EMPTY)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class CategoryWrapper extends Category implements Rest {
    private static final long serialVersionUID = -138260273061832039L;
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

    /**
     * This method is used as an utility to convert the DB-side entities to
     * wrapper REST implementations; it however does not convert any
     * relationships defined and hence named <i>liteConvert</i>.
     * 
     * @param category
     *            {@link org.codeavengers.common.dto.entity.Category} to be
     *            converted
     * @return an instance of the
     *         {@link org.codeavengers.common.dto.wrap.CategoryWrapper}
     * @author abhishek
     * @since 1.0
     */
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

    /**
     * This method is used as an utility to revert the REST implementation to
     * the DB-side entity; it however does not convert any relationships defined
     * and hence named <i>liteRevert</i>.
     * 
     * @param wrapper
     *            {@link org.codeavengers.common.dto.wrap.CategoryWrapper} to be
     *            converted
     * @return an instance of the
     *         {@link org.codeavengers.common.dto.entity.Category}
     * @author abhishek
     * @since 1.0
     */
    public static Category liteRevert(CategoryWrapper wrapper) {
        Category category = new Category();
        if (null == wrapper) {
            return category;
        }
        category.setCatId(wrapper.getCatId());
        category.setCatDesc(wrapper.getCatDesc());
        return category;
    }

    /**
     * Same as
     * {@link org.codeavengers.common.dto.wrap.CategoryWrapper#liteConvert}; it
     * converts all relationships defined and hence named <i>deepConvert</i>.
     * 
     * @param category
     *            {@link org.codeavengers.common.dto.entity.Category} to be
     *            converted
     * @return an instance of the
     *         {@link org.codeavengers.common.dto.wrap.CategoryWrapper}
     * @author abhishek
     * @since 1.0
     */
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

    /**
     * Same as
     * {@link org.codeavengers.common.dto.wrap.CategoryWrapper#liteRevert}; it
     * converts all relationships defined and hence named <i>deepRevert</i>.
     * 
     * @param wrapper
     *            {@link org.codeavengers.common.dto.wrap.CategoryWrapper} to be
     *            converted
     * @return an instance of the
     *         {@link org.codeavengers.common.dto.entity.Category}
     * @author abhishek
     * @since 1.0
     */
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

    /**
     * @author abhishek
     * @since 1.0
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CategoryWrapper [category=" + this.getCatDesc() + " (" + this.getCatId() + "), " + ", value=" + value + " " + unit + "]";
    }

}
