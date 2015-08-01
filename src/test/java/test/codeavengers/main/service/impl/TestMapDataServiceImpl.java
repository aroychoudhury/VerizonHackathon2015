package test.codeavengers.main.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.codeavengers.common.dto.wrap.CategoryWrapper;
import org.codeavengers.common.dto.wrap.LocationWrapper;
import org.codeavengers.main.service.MapDataService;
import org.codeavengers.main.service.impl.MapDataServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.codeavengers.config.TestRootConfig;
import test.codeavengers.util.ObjectMockingUtility;

/**
 * The class <code>TestMapDataServiceImpl</code> contains tests for the class
 * <code>{@link MapDataServiceImpl}</code>.
 *
 * @author abhishek
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
    TestRootConfig.class
})
public class TestMapDataServiceImpl extends ObjectMockingUtility {
    @Autowired
    @Qualifier("MapDataService")
    private MapDataService service;

    @Rollback(true)
    @Test
    public void testAddCategory() throws Exception {
        CategoryWrapper wrapper = service.addCategory(this.createCategoryWrapperDeep());
        assertNotNull(wrapper);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCategoryIllegalArgument() throws Exception {
        service.addCategory(null);
    }

    @Rollback(true)
    @Test
    public void testAddLocation() throws Exception {
        LocationWrapper wrapper = service.addLocation(this.createLocationWrapperDeep());
        assertNotNull(wrapper);
    }

    @Rollback(true)
    @Test(expected = IllegalArgumentException.class)
    public void testAddLocationIllegalArgument() throws Exception {
        service.addLocation(null);
    }

    @Test
    public void testGetCategories() throws Exception {
        List<CategoryWrapper> wrappers = service.getCategories();
        assertNotNull(wrappers);
        assertFalse(wrappers.isEmpty());
    }

    @Test
    public void testGetCategory() throws Exception {
        CategoryWrapper wrapper = service.getCategory(new Long(101L));
        assertNotNull(wrapper);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCategoryIllegalArgument() throws Exception {
        service.getCategory(new Long(0L));
    }

    @Test
    public void testGetLocation() throws Exception {
        LocationWrapper wrapper = service.getLocation(new Long(101L));
        assertNotNull(wrapper);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetLocationIllegalArgument() throws Exception {
        service.getLocation(new Long(0L));
    }

    @Test
    public void testGetLocations() throws Exception {
        List<LocationWrapper> wrappers = service.getLocations();
        assertNotNull(wrappers);
        assertFalse(wrappers.isEmpty());
    }

    @Rollback(true)
    @Test
    public void testRemoveCategory() throws Exception {
        CategoryWrapper wrapper = service.removeCategory(new Long(13L));
        assertNotNull(wrapper);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCategoryIllegalArgument() throws Exception {
        service.removeCategory(new Long(0L));
    }

    @Rollback(true)
    @Test
    public void testRemoveLocation() throws Exception {
        LocationWrapper wrapper = service.removeLocation(new Long(14L));
        assertNotNull(wrapper);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveLocationIllegalArgument() throws Exception {
        service.removeLocation(new Long(0L));
    }
}
