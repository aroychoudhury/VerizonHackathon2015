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

/**
 * This is the JPA DBEntity for <b>LOCATION_MASTER</b>.
 * 
 * @author abhishek
 * @since 1.0
 */
@Entity
@Table(name = "LOCATION_MASTER")
@SequenceGenerator(name = "locationId", sequenceName = "locationId", allocationSize = 1, initialValue = 1)
public class LocationMaster implements DBEntity {
    private static final long serialVersionUID = -5484290121775187900L;
    private Long                       locId;
    private Long                       parentLocId;
    private String                     area;
    private String                     code;
    private String                     lat;
    private String                     lon;
    private List<LocationCategoryAssn> assns;

    /**
     * @return the locId
     * @author abhishek
     * @since 1.0
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locationId")
    @Column(name = "locationId", nullable = false)
    public Long getLocId() {
        return locId;
    }

    /**
     * @param locationId
     *            the locationId to set
     * @author abhishek
     * @since 1.0
     */
    public void setLocId(Long locationId) {
        this.locId = locationId;
    }

    /**
     * @return the parentLocationId
     * @author abhishek
     * @since 1.0
     */
    @Column(name = "parentLocationId", nullable = true)
    public Long getParentLocId() {
        return parentLocId;
    }

    /**
     * @param parentLocId
     *            the parentLocId to set
     * @author abhishek
     * @since 1.0
     */
    public void setParentLocId(Long parentLocationId) {
        this.parentLocId = parentLocationId;
    }

    /**
     * @return the area
     * @author abhishek
     * @since 1.0
     */
    @Column(name = "area", nullable = false)
    public String getArea() {
        return area;
    }

    /**
     * @param area
     *            the area to set
     * @author abhishek
     * @since 1.0
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the code
     * @author abhishek
     * @since 1.0
     */
    @Column(name = "code", nullable = false)
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     * @author abhishek
     * @since 1.0
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the latitude
     * @author abhishek
     * @since 1.0
     */
    @Column(name = "latitude", nullable = false)
    public String getLat() {
        return lat;
    }

    /**
     * @param latitude
     *            the latitude to set
     * @author abhishek
     * @since 1.0
     */
    public void setLat(String latitude) {
        this.lat = latitude;
    }

    /**
     * @return the longitude
     * @author abhishek
     * @since 1.0
     */
    @Column(name = "longitude", nullable = false)
    public String getLon() {
        return lon;
    }

    /**
     * @param longitude
     *            the longitude to set
     * @author abhishek
     * @since 1.0
     */
    public void setLon(String longitude) {
        this.lon = longitude;
    }

    /**
     * @return the associations
     * @author abhishek
     * @since 1.0
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "location", cascade = CascadeType.ALL)
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
        result = prime * result + ((locId == null) ? 0 : locId.hashCode());
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
        if (!(obj instanceof LocationMaster)) {
            return false;
        }
        LocationMaster other = (LocationMaster) obj;
        if (locId == null) {
            if (other.locId != null) {
                return false;
            }
        } else if (!locId.equals(other.locId)) {
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
        return "LocationWrapper [id=" + locId + " ( " + parentLocId + " ), area=" + area + " ( " + code + " ) located at [ " + lat + ", " + lon + " ]";
    }

}
