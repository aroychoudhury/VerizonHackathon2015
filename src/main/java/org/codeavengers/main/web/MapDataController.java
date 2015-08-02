/* Copyright 2015 Roychoudhury, Abhishek */

package org.codeavengers.main.web;

import org.codeavengers.common.dto.RestWrapper;
import org.codeavengers.main.service.MapDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the REST End-point for all the Map Data. This class interacts with
 * the Service Layer to receive data.
 * 
 * It also defines effective URL mappings for accessing the Service resources.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.springframework.web.bind.annotation.RestController
 * @see org.codeavengers.main.web.BaseController
 */
@RestController
public class MapDataController extends BaseController {
    @Autowired
    @Qualifier("MapDataService")
    private MapDataService mapData = null;

    /**
     * Defines the REST access to retrieving all the <b>Categories</b>; HTTP
     * Access Type is GET and the URL is <b>categories</b>.
     * 
     * This method returns a JSON response.
     * 
     * Internally invokes the
     * {@link org.codeavengers.main.service.MapDataService#getCategories()}.
     * 
     * @return an instance of the
     *         {@link org.codeavengers.common.dto.RestWrapper}
     * @author abhishek
     * @since 1.0
     */
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ResponseBody
    public RestWrapper getCategories() {
        RestWrapper wrapper = new RestWrapper();
        try {
            wrapper.setDataList(mapData.getCategories());
        } catch (Exception e) {
            wrapper.setErrStack(this.getStackTrace(e));
            wrapper.setError(e.getClass().getSimpleName(), e.getMessage());
        }
        return wrapper;
    }

    /**
     * Defines the REST access to retrieving all the <b>Categories</b>; HTTP
     * Access Type is GET and the URL is <b>categories/{id}</b> where {id}
     * indicates a dynamic request path parameter.
     * 
     * This method returns a JSON response.
     * 
     * Internally invokes the
     * {@link org.codeavengers.main.service.MapDataService#getCategory(java.lang.Long)}
     * .
     * 
     * @return an instance of the
     *         {@link org.codeavengers.common.dto.RestWrapper}
     * @param id
     * @return
     * @author abhishek
     * @since 1.0
     */
    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestWrapper getCategory(@PathVariable Long id) {
        RestWrapper wrapper = new RestWrapper();
        try {
            wrapper.setData(mapData.getCategory(id));
        } catch (Exception e) {
            wrapper.setErrStack(this.getStackTrace(e));
            wrapper.setError(e.getClass().getSimpleName(), e.getMessage());
        }
        return wrapper;
    }
}
