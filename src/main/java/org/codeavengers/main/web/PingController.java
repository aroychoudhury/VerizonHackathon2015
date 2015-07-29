/* Copyright 2015 Code Avengers */

package org.codeavengers.main.web;

import org.codeavengers.main.data.db.impl.GenericReadOnlyPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class PingController {
    @Autowired
    @Qualifier("GenericReadOnlyPersister")
    private GenericReadOnlyPersister persister = null;

    @RequestMapping(value = "/ping-default", method = RequestMethod.GET)
    public ResponseEntity<String> pingDefault() {
        System.out.println("Ping Default reached");
        System.out.println(persister.retrieve(new Long(1L)));
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }
}