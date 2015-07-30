/**
 * 
 */
package org.codeavengers.common.dto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codeavengers.common.dto.DataObject;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * This is the JPA Entity for <b>LOCATION_DETAILS</b>.
 * 
 * @author abhishek
 * @since 1.0
 */
@Entity
@Table(name = "LOCATION_DETAILS")
public class LocationDetails extends DataObject implements Serializable {
    private static final long serialVersionUID = 2598211405698541998L;
    private Long locationId;
	private String latitude;
	private String longitude;
	private LocationMaster locationMaster;

	/**
	 * @return the locationId
	 * @author abhishek
	 * @since 1.0
	 */
	@Id
	@Column(name = "locationId")
	//@GeneratedValue(generator = "gen")
	//@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "locationMaster") )
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
	 * @return the latitude
	 * @author abhishek
	 * @since 1.0
	 */
	@Column(name = "latitude")
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
	@Column(name = "longitude")
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
	 * @return the locationMaster
	 * @author abhishek
	 * @since 1.0
	 */
	//@OneToOne(mappedBy = "locationDetails")
    //@PrimaryKeyJoinColumn
	@Transient
	public LocationMaster getLocationMaster() {
		return locationMaster;
	}

	/**
	 * @param locationMaster
	 *            the locationMaster to set
	 * @author abhishek
	 * @since 1.0
	 */
	public void setLocationMaster(LocationMaster locationMaster) {
		this.locationMaster = locationMaster;
	}

}
