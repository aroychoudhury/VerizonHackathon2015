/**
 * 
 */
package org.codeavengers.common.dto.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * This is the JPA Entity for <b>REPORT_ASSOCIATION</b>.
 * 
 * @author abhishek
 * @since 1.0
 */
@Entity
@Table(name = "REPORT_ASSOCIATION")
@SequenceGenerator(name = "reportId", sequenceName = "reportId", allocationSize = 1, initialValue = 1)
public class LocationCategoryAssn implements Serializable {
	private static final long serialVersionUID = -9215521694003691234L;
	private Long assnId;
	private String categoryField;
	private String categoryValue;
	private Category category;
	private LocationMaster location;

	/**
	 * @return the assnId
	 * @author abhishek
	 * @since 1.0
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reportId")
	@Column(name = "reportId", nullable = false)
	public Long getAssnId() {
		return assnId;
	}

	/**
	 * @param assnId
	 *            the assnId to set
	 * @author abhishek
	 * @since 1.0
	 */
	public void setAssnId(Long assnId) {
		this.assnId = assnId;
	}

	/**
	 * @return the categoryField
	 * @author abhishek
	 * @since 1.0
	 */
	@Column(name = "categoryField", nullable = false)
	public String getCategoryField() {
		return categoryField;
	}

	/**
	 * @param categoryField
	 *            the categoryField to set
	 * @author abhishek
	 * @since 1.0
	 */
	public void setCategoryField(String categoryField) {
		this.categoryField = categoryField;
	}

	/**
	 * @return the categoryValue
	 * @author abhishek
	 * @since 1.0
	 */
	@Column(name = "categoryValue", nullable = false)
	public String getCategoryValue() {
		return categoryValue;
	}

	/**
	 * @param categoryValue
	 *            the categoryValue to set
	 * @author abhishek
	 * @since 1.0
	 */
	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}

	/**
	 * @return the category
	 * @author abhishek
	 * @since 1.0
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryId", nullable = false)
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 * @author abhishek
	 * @since 1.0
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the location
	 * @author abhishek
	 * @since 1.0
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "locationId", nullable = false)
	public LocationMaster getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 * @author abhishek
	 * @since 1.0
	 */
	public void setLocation(LocationMaster location) {
		this.location = location;
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
		result = prime * result + ((assnId == null) ? 0 : assnId.hashCode());
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
		if (!(obj instanceof LocationCategoryAssn)) {
			return false;
		}
		LocationCategoryAssn other = (LocationCategoryAssn) obj;
		if (assnId == null) {
			if (other.assnId != null) {
				return false;
			}
		} else if (!assnId.equals(other.assnId)) {
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
		return "LocationCategoryAssn [id=" + assnId + ", value=" + categoryField + " : " + categoryValue + "]";
	}
}
