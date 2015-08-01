package test.codeavengers.common.dto.wrap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.codeavengers.common.dto.entity.Category;
import org.codeavengers.common.dto.wrap.CategoryWrapper;
import org.codeavengers.common.dto.wrap.LocationWrapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.codeavengers.config.TestRootConfig;
import test.codeavengers.util.ObjectMockingUtility;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
    TestRootConfig.class
})
public class TestCategoryWrapper extends ObjectMockingUtility {
    private CategoryWrapper wrapper  = null;
    private Category        category = null;

    @Before
    public void setUp() throws Exception {
        wrapper = this.createCategoryWrapperDeep();
        wrapper.setAssnId(new Long(301L));
        category = this.createCategoryDeep();
    }

    @Test
    public void testToString() {
        assertNotNull(wrapper.toString());
    }

    @Test
    public void testGetLocns() {
        assertNotNull(wrapper.getLocns());
    }

    @Test
    public void testSetLocns() {
        LocationWrapper locWrapper = new LocationWrapper();
        locWrapper.setLocId(101L);
        List<LocationWrapper> locWrappers = new ArrayList<LocationWrapper>(1);
        locWrappers.add(locWrapper);

        wrapper.setLocns(locWrappers);

        assertNotNull(wrapper.getLocns());
        assertEquals(new Long(101L), wrapper.getLocns().get(0).getLocId());
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
        CategoryWrapper categoryWrapper = CategoryWrapper.liteConvert(category);
        assertNotNull(categoryWrapper);
        assertNotNull(categoryWrapper.getCatDesc());
    }

    @Test
    public void testLiteRevert() {
        Category categoryEnt = CategoryWrapper.liteRevert(wrapper);
        assertNotNull(categoryEnt);
        assertNotNull(categoryEnt.getCatDesc());
    }

    @Test
    public void testDeepConvert() {
        CategoryWrapper categoryWrapper = CategoryWrapper.deepConvert(category);
        assertNotNull(categoryWrapper);
        assertNotNull(categoryWrapper.getCatDesc());
    }

    @Test
    public void testDeepRevert() {
        Category categoryEnt = CategoryWrapper.deepRevert(wrapper);
        assertNotNull(categoryEnt);
        assertNotNull(categoryEnt.getCatDesc());
    }

}
