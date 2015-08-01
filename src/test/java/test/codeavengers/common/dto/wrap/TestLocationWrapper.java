package test.codeavengers.common.dto.wrap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.codeavengers.common.dto.entity.LocationMaster;
import org.codeavengers.common.dto.wrap.CategoryWrapper;
import org.codeavengers.common.dto.wrap.LocationWrapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import test.codeavengers.util.ObjectMockingUtility;

@Configuration
@EnableTransactionManagement
@ComponentScan({
    "org.codeavengers.main"
})
public class TestLocationWrapper extends ObjectMockingUtility {
    private LocationWrapper wrapper  = null;
    private LocationMaster  location = null;

    @Before
    public void setUp() throws Exception {
        wrapper = this.createLocationWrapperDeep();
        wrapper.setAssnId(new Long(301L));
        location = this.createLocationDeep();
    }

    @Test
    public void testToString() {
        assertNotNull(wrapper.toString());
    }

    @Test
    public void testGetCates() {
        assertNotNull(wrapper.getCates());
    }

    @Test
    public void testSetCates() {
        CategoryWrapper catWrapper = new CategoryWrapper();
        catWrapper.setCatId(101L);
        List<CategoryWrapper> catWrappers = new ArrayList<CategoryWrapper>(1);
        catWrappers.add(catWrapper);

        wrapper.setCates(catWrappers);

        assertNotNull(wrapper.getCates());
        assertEquals(new Long(101L), wrapper.getCates().get(0).getCatId());
    }

    @Test
    public void testGetAssnId() {
        assertNotNull(wrapper.getAssnId());
    }

    @Test
    public void testSetAssnId() {
        wrapper.setAssnId(new Long(201L));
        assertEquals(new Long(201L), wrapper.getAssnId());
    }

    @Test
    public void testGetUnit() {
        assertNotNull(wrapper.getUnit());
    }

    @Test
    public void testSetUnit() {
        wrapper.setUnit("ml/yr");
        assertEquals("ml/yr", wrapper.getUnit());
    }

    @Test
    public void testGetValue() {
        assertNotNull(wrapper.getValue());
    }

    @Test
    public void testSetValue() {
        wrapper.setValue("12312");
        assertEquals("12312", wrapper.getValue());
    }

    @Test
    public void testLiteConvert() {
        LocationWrapper locWrapper = LocationWrapper.liteConvert(location);
        assertNotNull(locWrapper);
        assertNotNull(locWrapper.getArea());
    }

    @Test
    public void testLiteRevert() {
        LocationMaster locationEnt = LocationWrapper.liteRevert(wrapper);
        assertNotNull(locationEnt);
        assertNotNull(locationEnt.getArea());
    }

    @Test
    public void testDeepConvert() {
        LocationWrapper locWrapper = LocationWrapper.deepConvert(location);
        assertNotNull(locWrapper);
        assertNotNull(locWrapper.getArea());
    }

    @Test
    public void testDeepRevert() {
        LocationMaster locationEnt = LocationWrapper.deepRevert(wrapper);
        assertNotNull(locationEnt);
        assertNotNull(locationEnt.getArea());
    }

}
