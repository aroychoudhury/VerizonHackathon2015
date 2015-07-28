/* Copyright 2015 Roychoudhury, Abhishek */

package org.codeavengers.common.dto.wrap;

import org.codeavengers.common.dto.DataObject;

/**
 * All data objects which are to be transferred to the UI/Web Layer has to
 * extend this class.
 * 
 * @author abhishek
 * @since 1.0
 */
public class RestWrapper extends DataObject {
    private static final long serialVersionUID = 4496991791493407851L;

    private DataObject data = null;

    /**
     * @return the data
     * @since 1.0
     * @see DataObject
     */
    public DataObject getData() {
        return data;
    }

    /**
     * @param data
     *            the data to set
     * @since 1.0
     * @see DataObject
     */
    public void setData(DataObject data) {
        this.data = data;
    }
}
