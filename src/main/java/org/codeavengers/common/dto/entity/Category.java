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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codeavengers.common.dto.DataObject;

/**
 * This is the JPA Entity for <b>REPORT_CATEGORY</b>.
 * 
 * @author abhishek
 * @since 1.0
 */
@Entity
@Table(name = "REPORT_CATEGORY")
@SequenceGenerator(name = "reportId", sequenceName = "reportId")
public class Category extends DataObject implements Serializable {
    private static final long serialVersionUID = 752861092185673487L;
    private Long categoryId;
	private String reportCategory;
	private List<LocationCategoryAssn> assn;

	/**
	 * @return the categoryId
	 * @author abhishek
	 * @since 1.0
	 */
	@Id
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
	 * @return the assn
	 * @author abhishek
	 * @since 1.0
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
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
