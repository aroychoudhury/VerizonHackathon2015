/* Copyright 2015 Code Avengers */

package org.codeavengers.common.dto.entity;

import java.util.ArrayList;
import java.util.List;

import org.codeavengers.common.dto.DBEntity;

/**
 * This is a wrapper for a {@link java.util.List} of
 * {@link org.codeavengers.common.dto.entity.Result} object.
 * 
 * Each of the {@link org.codeavengers.common.dto.entity.Result} does not need
 * to contain the name and type information for the columns, instead it will
 * only wrap the data. This class provides context to the data by storing name
 * and type information for the columns.
 * 
 * The {@link org.codeavengers.common.dto.DBEntity} interface that it implements
 * indicates that this class participates in Data Access Layer operations.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.codeavengers.common.dto.entity.Result
 * @see org.codeavengers.common.dto.DBEntity
 */
public class Results implements DBEntity {
    private static final long serialVersionUID = 3894034420524234239L;
    private List<Result> entries  = null;
    private String[]     sortedBy = null;
    private String[]     names    = null;
    private String[]     types    = null;

    /**
     * Initializes the fields with expected values. This is done to combat any
     * {@link java.lang.NullPointerException} that might occur during an
     * operation on this bean.
     * 
     * @author abhishek
     * @since 1.0
     */
    public Results() {
        super();
        this.entries = new ArrayList<Result>(1);
        this.names = new String[0];
        this.types = new String[0];
    }

    /**
     * @return the entries
     * @since 1.0
     * @see java.util.List
     * @see org.codeavengers.common.dto.entity.Result
     */
    public List<Result> getEntries() {
        return this.entries;
    }

    /**
     * @param entries
     *            the entries to set
     * @since 1.0
     * @see java.util.List
     * @see org.codeavengers.common.dto.entity.Result
     */
    public void setEntries(List<Result> entries) {
        if (null == entries)
            return;
        this.entries = entries;
    }

    /**
     * Gives the sorted by columns. The array return type supports multiple sort
     * fields.
     * 
     * @return the array of sorted by column names
     * @since 1.0
     * @see java.lang.String
     */
    public String[] getSortedBy() {
        return this.sortedBy;
    }

    /**
     * @param sortedBy
     *            the sortedBy to set
     * @since 1.0
     * @see java.lang.String
     */
    public void setSortedBy(String[] sortedBy) {
        if (null == sortedBy)
            return;
        this.sortedBy = sortedBy;
    }

    /**
     * Contains the name for the value, as per the same index as
     * <i>entries.get(index).getValues()</i>. This is usually the column name of
     * the data.
     * 
     * @return the names
     * @since 1.0
     * @see java.lang.String
     */
    public String[] getNames() {
        return this.names;
    }

    /**
     * @param names
     *            the names to set
     * @since 1.0
     * @see java.lang.String
     */
    public void setNames(String[] names) {
        if (null == names)
            return;
        this.names = names;
    }

    /**
     * Contains the data type of the value, as per the same index as
     * <i>entries.get(index).getValues()</i>. The type here indicates the
     * database column datatype.
     * 
     * @return the types
     * @since 1.0
     * @see java.lang.String
     */
    public String[] getTypes() {
        return this.types;
    }

    /**
     * @param types
     *            the types to set
     * @since 1.0
     * @see java.lang.String
     */
    public void setTypes(String[] types) {
        if (null == types)
            return;
        this.types = types;
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Results - entries : " + entries;
    }
}
