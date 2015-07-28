/* Copyright 2015 Roychoudhury, Abhishek */

package org.codeavengers.common.dto;

import java.io.Serializable;

/**
 * All data objects which are to be transferred to the UI/Web Layer has to
 * extend this class.
 * 
 * @author abhishek
 * @since 1.0
 */
public abstract class DataObject implements Serializable {
    private static final long serialVersionUID = 2338760680633594881L;

    private String errCd  = null;
    private String errMsg = null;

    public String getErrCd() {
        return errCd;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setError(String errCd, String errMsg) {
        this.errCd = errCd;
        this.errMsg = errMsg;
    }
}
