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
 * This is the JPA Entity for <b>REPORT_CATEGORY</b>.
 * 
 * @author abhishek
 * @since 1.0
 */
@Entity
@Table(name = "REPORT_CATEGORY")
@SequenceGenerator(name = "categoryId", sequenceName = "categoryId", allocationSize = 1, initialValue = 1)
public class Category implements Serializable {
	private static final long serialVersionUID = -6123840752981875041L;
	private Long categoryId;
	private String reportCategory;
	private List<LocationCategoryAssn> associations;

	/**
	 * @return the categoryId
	 * @author abhishek
	 * @since 1.0
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryId")
	@Column(name = "categoryId", nullable = false)
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 * @author abhishek
	 * @since 1.0
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the reportCategory
	 * @author abhishek
	 * @since 1.0
	 */
	@Column(name = "reportCategory", nullable = false)
	public String getReportCategory() {
		return reportCategory;
	}

	/**
	 * @param reportCategory
	 *            the reportCategory to set
	 * @author abhishek
	 * @since 1.0
	 */
	public void setReportCategory(String reportCategory) {
		this.reportCategory = reportCategory;
	}

	/**
	 * @return the associations
	 * @author abhishek
	 * @since 1.0
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
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
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
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
		if (categoryId == null) {
			if (other.categoryId != null) {
				return false;
			}
		} else if (!categoryId.equals(other.categoryId)) {
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
		return "Category [id=" + categoryId + ", reportCategory=" + reportCategory + "]";
	}
}
