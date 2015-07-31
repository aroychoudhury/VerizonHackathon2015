/* Copyright 2015 Code Avengers */

package org.codeavengers.main.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller just allows us to check that everything is working on the
 * server. And that the server is respond to a request.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.springframework.web.bind.annotation.RestController
 */
@RestController
public class PingController extends BaseController {
    /**
     * This method is invoked for the URL ending <b>ping-default</b> for a HTTP
     * GET Request. This method is used to check that the server is responding
     * as expected.
     * 
     * @return Returns a {@link org.springframework.http.ResponseEntity} which
     *         encapsulates a String message
     * @author abhishek
     * @since 1.0
     * @see org.springframework.web.bind.annotation.RequestMapping
     * @see org.springframework.web.bind.annotation.RequestMethod
     * @see org.springframework.http.ResponseEntity
     */
    @RequestMapping(value = "/ping-default", method = RequestMethod.GET)
    public ResponseEntity<String> pingDefault() {
        return new ResponseEntity<String>("Ping success", HttpStatus.OK);
    }
}
