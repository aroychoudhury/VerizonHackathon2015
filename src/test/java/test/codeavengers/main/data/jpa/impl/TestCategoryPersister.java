/* Copyright 2015 Roychoudhury, Abhishek */

package test.codeavengers.main.data.jpa.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.codeavengers.common.dto.entity.Category;
import org.codeavengers.common.dto.entity.LocationCategoryAssn;
import org.codeavengers.main.data.jpa.JPAPersister;
import org.codeavengers.main.data.jpa.impl.CategoryPersister;
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
public class TestCategoryPersister extends ObjectMockingUtility {
    @Autowired
    @Qualifier("CategoryPersister")
    private JPAPersister<Long, Category> persister;

    @Test
    public void testIdentify() {
        assertNotNull(persister);
        assertEquals(CategoryPersister.class.getSimpleName(), persister.identify());
    }

    @Rollback(true)
    @Test
    public void testAdd() {
        Category returnedLocation = persister.add(this.createCategoryDeep());
        assertNotNull(returnedLocation);
        assertNotNull(returnedLocation.getCatId());
    }

    @Rollback(true)
    @Test
    public void testUpdate() {
        Category category = persister.retrieve(211L);
        assertNotNull(category);

        category.setCatDesc("Rainfall");

        Category returnedCategory = persister.update(category);
        assertNotNull(returnedCategory);
        assertEquals("Rainfall", returnedCategory.getCatDesc());
    }

    @Rollback(true)
    @Test
    public void testDelete() {
        Category returnedCategory = persister.delete(11L);
        assertNotNull(returnedCategory);
    }

    @Test
    public void testRetrieve() {
        Category category = persister.retrieve(101L);
        assertNotNull(category);
        LocationCategoryAssn assn = category.getAssns().get(0);
        assertNotNull(assn);
        assertNotNull(assn.getLocation());
        assertEquals(101L, category.getCatId().longValue());
    }

    @Test
    public void testRetrieveAll() {
        List<Category> categories = persister.retrieveAll();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
    }

}
