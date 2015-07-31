/* Copyright 2015 Code Avengers */

package org.codeavengers.main.web;

import org.codeavengers.common.dto.entity.LocationCategoryAssn;
import org.codeavengers.common.dto.entity.LocationMaster;
import org.codeavengers.main.data.db.DatabasePersister;
import org.codeavengers.main.data.jpa.JPAPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    private DatabasePersister persister = null;

    @Autowired
	@Qualifier("LocationPersister")
	private JPAPersister<Long, LocationMaster> locationPersister = null;

    @RequestMapping(value = "/ping-default", method = RequestMethod.GET)
    public ResponseEntity<String> pingDefault() {
        System.out.println("Ping Default reached");
        System.out.println(persister.query(""));
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }

    @RequestMapping(value = "/location", method = RequestMethod.GET)
    @ResponseBody
    public LocationMaster getLocation() {
		LocationMaster location = locationPersister.retrieve(1L);
		System.out.println("location -> " + location);
		LocationCategoryAssn assn = location.getAssns().get(0);
		System.out.println("assn -> " + assn);
		System.out.println("Category -> " + assn.getCategory());
		return location;
	
    }
}
