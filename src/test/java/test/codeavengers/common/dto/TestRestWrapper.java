package test.codeavengers.common.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.codeavengers.common.dto.RestWrapper;
import org.codeavengers.common.dto.wrap.CategoryWrapper;
import org.junit.Before;
import org.junit.Test;

import test.codeavengers.util.ObjectMockingUtility;

public class TestRestWrapper extends ObjectMockingUtility {
    private RestWrapper wrapper = null;

    @Before
    public void setup() {
        wrapper = this.createCategoryRest();
    }

    @Test
    public void testGetData() {
        assertNotNull(wrapper.getData());
    }

    @Test
    public void testSetData() {
        wrapper.setData(new CategoryWrapper());
        assertNotNull(wrapper.getData());
    }

    @Test
    public void testGetDataList() {
        assertNotNull(wrapper.getDataList());
        assertNotNull(wrapper.getDataList().get(0));
    }

    @Test
    public void testSetDataList() {
        List<CategoryWrapper> categories = new ArrayList<CategoryWrapper>(1);
        categories.add(new CategoryWrapper());
        wrapper.setDataList(categories);
        assertNotNull(wrapper.getDataList());
        assertNotNull(wrapper.getDataList().get(0));
    }

    @Test
    public void testGetErrCd() {
        assertNotNull(wrapper.getErrCd());
        assertEquals("Code", wrapper.getErrCd());
    }

    @Test
    public void testGetErrMsg() {
        assertNotNull(wrapper.getErrMsg());
        assertEquals("Message", wrapper.getErrMsg());
    }

    @Test
    public void testSetError() {
        wrapper.setError("Code", "Message");
        assertNotNull(wrapper.getErrCd());
        assertEquals("Code", wrapper.getErrCd());
        assertNotNull(wrapper.getErrMsg());
        assertEquals("Message", wrapper.getErrMsg());
    }

    @Test
    public void testGetErrStack() {
        assertNotNull(wrapper.getErrStack());
        assertEquals("Exception", wrapper.getErrStack());
    }

    @Test
    public void testSetErrStack() {
        wrapper.setErrStack("Exception");
        assertNotNull(wrapper.getErrStack());
        assertEquals("Exception", wrapper.getErrStack());
    }

}
