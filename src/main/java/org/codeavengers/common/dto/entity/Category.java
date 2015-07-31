/**
 * 
 */
package org.codeavengers.common.dto.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codeavengers.common.dto.DBEntity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * This is the JPA DBEntity for <b>REPORT_CATEGORY</b>.
 * 
 * @author abhishek
 * @since 1.0
 */
@Entity
@Table(name = "REPORT_CATEGORY")
@SequenceGenerator(name = "categoryId", sequenceName = "categoryId", allocationSize = 1, initialValue = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Category implements DBEntity {
    private static final long serialVersionUID = -7428117920763750085L;
    private Long                       catId;
    private String                     catDesc;
    private List<LocationCategoryAssn> assns;

    /**
     * @return the categoryId
     * @author abhishek
     * @since 1.0
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryId")
    @Column(name = "categoryId", nullable = false)
    public Long getCatId() {
        return catId;
    }

    /**
     * @param categoryId
     *            the categoryId to set
     * @author abhishek
     * @since 1.0
     */
    public void setCatId(Long categoryId) {
        this.catId = categoryId;
    }

    /**
     * @return the catDesc
     * @author abhishek
     * @since 1.0
     */
    @Column(name = "reportCategory", nullable = false)
    public String getCatDesc() {
        return catDesc;
    }

    /**
     * @param reportCategory
     *            the reportCategory to set
     * @author abhishek
     * @since 1.0
     */
    public void setCatDesc(String reportCategory) {
        this.catDesc = reportCategory;
    }

    /**
     * @return the associations
     * @author abhishek
     * @since 1.0
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    public List<LocationCategoryAssn> getAssns() {
        if (null == this.assns) {
            this.assns = new ArrayList<LocationCategoryAssn>(1);
        }
        return assns;
    }

    /**
     * @param associations
     *            the associations to set
     * @author abhishek
     * @since 1.0
     */
    public void setAssns(List<LocationCategoryAssn> associations) {
        this.assns = associations;
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((catId == null) ? 0 : catId.hashCode());
        return result;
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Category)) {
            return false;
        }
        Category other = (Category) obj;
        if (catId == null) {
            if (other.catId != null) {
                return false;
            }
        } else if (!catId.equals(other.catId)) {
            return false;
        }
        return true;
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Category [id=" + catId + ", description=" + catDesc + "]";
    }
}
