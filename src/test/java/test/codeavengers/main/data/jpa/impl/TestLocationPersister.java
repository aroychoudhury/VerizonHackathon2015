package test.codeavengers.main.data.jpa.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.codeavengers.common.dto.entity.LocationCategoryAssn;
import org.codeavengers.common.dto.entity.LocationMaster;
import org.codeavengers.main.data.jpa.JPAPersister;
import org.codeavengers.main.data.jpa.impl.LocationPersister;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.codeavengers.config.TestRootConfig;
import test.codeavengers.util.ObjectMockingUtility;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
    TestRootConfig.class
})
public class TestLocationPersister extends ObjectMockingUtility {
    @Autowired
    @Qualifier("LocationPersister")
    private JPAPersister<Long, LocationMaster> persister;

    @Test
    public void testIdentify() {
        assertNotNull(persister);
        assertEquals(LocationPersister.class.getSimpleName(), persister.identify());
    }

    @Rollback(true)
    @Test
    public void testAdd() {
        LocationMaster returnedLocation = persister.add(this.createLocationDeep());
        assertNotNull(returnedLocation);
        assertNotNull(returnedLocation.getLocId());
    }

    @Rollback(true)
    @Test
    public void testUpdate() {
        LocationMaster location = persister.retrieve(212L);
        assertNotNull(location);

        location.setArea("Kolkata");
        location.setCode("KOL");

        LocationMaster returnedLocation = persister.update(location);
        assertNotNull(returnedLocation);
        assertEquals("Kolkata", returnedLocation.getArea());
        assertEquals("KOL", returnedLocation.getCode());
    }

    @Rollback(true)
    @Test
    public void testDelete() {
        LocationMaster returnedLocation = persister.delete(12L);
        assertNotNull(returnedLocation);
    }

    @Test
    public void testRetrieve() {
        LocationMaster location = persister.retrieve(101L);
        assertNotNull(location);
        LocationCategoryAssn assn = location.getAssns().get(0);
        assertNotNull(assn);
        assertNotNull(assn.getCategory());
        assertEquals(101L, location.getLocId().longValue());
    }

    @Test
    public void testRetrieveAll() {
        List<LocationMaster> locations = persister.retrieveAll();
        assertNotNull(locations);
        assertFalse(locations.isEmpty());
    }

}
