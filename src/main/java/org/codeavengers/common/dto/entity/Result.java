/* Copyright 2015 Code Avengers */

package org.codeavengers.common.dto.entity;

import org.codeavengers.common.dto.DBEntity;

/**
 * This class is a wrapper for data in a simple {@link java.sql.ResultSet} table
 * row. This class however does not wrap any of the column information
 * associated with these values.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.codeavengers.common.dto.DBEntity
 * @see java.sql.ResultSet
 */
public class Result implements DBEntity {
    private static final long serialVersionUID = -4836894188003928870L;
    private String[]          values           = null;

    /**
     * Initializes the fields with expected values. This is done to combat any
     * {@link java.lang.NullPointerException} that might occur during an
     * operation on this bean.
     * 
     * @author abhishek
     * @since 1.0
     */
    public Result() {
        super();
        this.values = new String[1];
    }

    /**
     * Overridden constructor to default initialize the properties. This is done
     * to combat any {@link java.lang.NullPointerException} that might occur
     * during an operation on this bean.
     * 
     * @param values
     * @author abhishek
     * @since 1.0
     */
    public Result(String[] values) {
        super();
        this.setValues(values);
    }

    /**
     * @return the values
     * @since 1.0
     * @see java.lang.String
     */
    public String[] getValues() {
        return this.values;
    }

    /**
     * @param values
     *            the values to set
     * @since 1.0
     * @see java.lang.String
     */
    public void setValues(String[] values) {
        if (null == values)
            return;
        this.values = values;
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.values[0];
    }
}
