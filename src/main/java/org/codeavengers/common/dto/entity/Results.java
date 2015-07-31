/* Copyright 2015 Code Avengers */

package org.codeavengers.common.dto.entity;

import java.util.ArrayList;
import java.util.List;

import org.codeavengers.common.dto.DBEntity;

/**
 * This is a wrapper for a list of {@link Result} object.
 * 
 * Each of the {@link Result} does not need to contain the name and type
 * information for the columns, instead it will only wrap the data.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.codeavengers.common.dto.entity.Result
 * @see org.codeavengers.common.dto.DBEntity
 * @see java.util.List
 */
public class Results implements DBEntity {
    private static final long serialVersionUID = -1679135433372626950L;

    /**
     * Contains a list of {@link Result}.
     * 
     * @since 1.0
     * @see List<ResultEntry>
     */
    private List<Result>      entries          = null;

    /**
     * Indicates the sorted by columns. Sort can be on multiple fields hence
     * this is in array.
     * 
     * @since 1.0
     * @see String
     */
    private String[]          sortedBy         = null;

    /**
     * Contains the code/name for the value, as per the same index as
     * <i>entries.get(index).getValues()</i>.
     * 
     * @since 1.0
     * @see String[]
     */
    private String[]          names            = null;

    /**
     * Contains the data type of the value, as per the same index as
     * <i>entries.get(index).getValues()</i>.
     * 
     * @since 1.0
     * @see String[]
     */
    private String[]          types            = null;

    /**
     * Initializes the fields with expected values.
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
     * @see List<Result>
     */
    public List<Result> getEntries() {
        return this.entries;
    }

    /**
     * @param entries
     *            the entries to set
     * @since 1.0
     * @see List<Result>
     */
    public void setEntries(List<Result> entries) {
        if (null == entries)
            return;
        this.entries = entries;
    }

    /**
     * @return the sortedBy
     * @since 1.0
     * @see String[]
     */
    public String[] getSortedBy() {
        return this.sortedBy;
    }

    /**
     * @param sortedBy
     *            the sortedBy to set
     * @since 1.0
     * @see String[]
     */
    public void setSortedBy(String[] sortedBy) {
        if (null == sortedBy)
            return;
        this.sortedBy = sortedBy;
    }

    /**
     * @return the names
     * @since 1.0
     * @see String[]
     */
    public String[] getNames() {
        return this.names;
    }

    /**
     * @param names
     *            the names to set
     * @since 1.0
     * @see String[]
     */
    public void setNames(String[] names) {
        if (null == names)
            return;
        this.names = names;
    }

    /**
     * @return the types
     * @since 1.0
     * @see String[]
     */
    public String[] getTypes() {
        return this.types;
    }

    /**
     * @param types
     *            the types to set
     * @since 1.0
     * @see String[]
     */
    public void setTypes(String[] types) {
        if (null == types)
            return;
        this.types = types;
    }

    /**
     * @author abhishek
     * @since  1.0
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Results - entries : " + entries;
    }
}
