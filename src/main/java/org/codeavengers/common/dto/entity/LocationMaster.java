/**
 * 
 */
package org.codeavengers.common.dto.entity;

import java.io.Serializable;
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

/**
 * This is the JPA Entity for <b>LOCATION_MASTER</b>.
 * 
 * @author abhishek
 * @since 1.0
 */
@Entity
@Table(name = "LOCATION_MASTER")
@SequenceGenerator(name = "locationId", sequenceName = "locationId", allocationSize = 1, initialValue = 1)
public class LocationMaster implements Serializable {
	private static final long serialVersionUID = 5993116595957248610L;
	private Long locationId;
	private Long parentLocationId;
	private String area;
	private String code;
	private String latitude;
	private String longitude;
	private List<LocationCategoryAssn> associations;

	/**
	 * @return the locationId
	 * @author abhishek
	 * @since 1.0
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locationId")
	@Column(name = "locationId", nullable = false)
	public Long getLocationId() {
		return locationId;
	}

	/**
	 * @param locationId
	 *            the locationId to set
	 * @author abhishek
	 * @since 1.0
	 */
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	/**
	 * @return the parentLocationId
	 * @author abhishek
	 * @since 1.0
	 */
	@Column(name = "parentLocationId", nullable = false)
	public Long getParentLocationId() {
		return parentLocationId;
	}

	/**
	 * @param parentLocationId
	 *            the parentLocationId to set
	 * @author abhishek
	 * @since 1.0
	 */
	public void setParentLocationId(Long parentLocationId) {
		this.parentLocationId = parentLocationId;
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
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 * @author abhishek
	 * @since 1.0
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 * @author abhishek
	 * @since 1.0
	 */
	@Column(name = "longitude", nullable = false)
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 * @author abhishek
	 * @since 1.0
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the associations
	 * @author abhishek
	 * @since 1.0
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "location", cascade = CascadeType.ALL)
	public List<LocationCategoryAssn> getAssociations() {
		if (null == this.associations) {
			this.associations = new ArrayList<LocationCategoryAssn>(1);
		}
		return associations;
	}

	/**
	 * @param associations
	 *            the associations to set
	 * @author abhishek
	 * @since 1.0
	 */
	public void setAssociations(List<LocationCategoryAssn> associations) {
		this.associations = associations;
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
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
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
		if (locationId == null) {
			if (other.locationId != null) {
				return false;
			}
		} else if (!locationId.equals(other.locationId)) {
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
		return "LocationMaster [id=" + locationId + " ( " + parentLocationId + " ), area=" + area
				+ " ( " + code + " ) located at [ " + latitude + ", " + longitude + " ]";
	}

	
}
