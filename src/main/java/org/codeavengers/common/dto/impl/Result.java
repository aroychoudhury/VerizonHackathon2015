/* Copyright 2015 Code Avengers */

package org.codeavengers.common.dto.impl;

import org.codeavengers.common.dto.DataObject;

/**
 * This is a wrapper for values/data in a simple {@link ResultSet} data row.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.codeavengers.common.dto.DataObject
 * @see java.sql.ResultSet
 */
public class Result extends DataObject {
    private static final long serialVersionUID = -1545023356490777880L;

    /**
     * Contains the value as per the data row.
     * 
     * @since 1.0
     * @see String[]
     */
    private String[]          values           = null;

    /**
     * Initializes the fields with expected values.
     * 
     * @author abhishek
     * @since 1.0
     */
    public Result() {
        super();
        this.values = new String[1];
    }

    /**
     * Overridden constructor to default initialize the properties.
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
     * @see String[]
     */
    public String[] getValues() {
        return this.values;
    }

    /**
     * @param values
     *            the values to set
     * @since 1.0
     * @see String[]
     */
    public void setValues(String[] values) {
        if (null == values)
            return;
        this.values = values;
    }

    /**
     * @author abhishek
     * @since  1.0
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.values[0];
    }
}
