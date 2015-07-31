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
 */
@RestController
public class PingController extends BaseController {
    @RequestMapping(value = "/ping-default", method = RequestMethod.GET)
    public ResponseEntity<String> pingDefault() {
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }
}
