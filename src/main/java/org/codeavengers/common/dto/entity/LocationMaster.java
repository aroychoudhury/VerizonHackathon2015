/**
 * 
 */
package org.codeavengers.common.dto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codeavengers.common.dto.DataObject;

/**
 * This is the JPA Entity for <b>LOCATION_MASTER</b>.
 * 
 * @author abhishek
 * @since 1.0
 */
@Entity
@Table(name = "LOCATION_MASTER")
@SequenceGenerator(name = "locationId", sequenceName = "locationId")
public class LocationMaster extends DataObject implements Serializable {
    private static final long serialVersionUID = -6580838413207923482L;
    private Long locationId;
	private String area;
	private String code;
	private Long parentLocationId;
	private LocationDetails locationDetails;
	private List<LocationCategoryAssn> assn;

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
	 * @return the locationDetails
	 * @author abhishek
	 * @since 1.0
	 */
	@OneToOne(cascade = CascadeType.ALL, optional = true)
	public LocationDetails getLocationDetails() {
		return locationDetails;
	}

	/**
	 * @param locationDetails
	 *            the locationDetails to set
	 * @author abhishek
	 * @since 1.0
	 */
	public void setLocationDetails(LocationDetails locationDetails) {
		this.locationDetails = locationDetails;
	}

	/**
	 * @return the assn
	 * @author abhishek
	 * @since 1.0
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "location", cascade = CascadeType.ALL)
	public List<LocationCategoryAssn> getAssn() {
		return assn;
	}

	/**
	 * @param assn
	 *            the assn to set
	 * @author abhishek
	 * @since 1.0
	 */
	public void setAssn(List<LocationCategoryAssn> assn) {
		this.assn = assn;
	}
}
