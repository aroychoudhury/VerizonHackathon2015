package test.codeavengers.main.data.db.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.codeavengers.common.dto.entity.Results;
import org.codeavengers.main.data.db.DatabasePersister;
import org.codeavengers.main.data.db.impl.GenericReadOnlyPersister;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.codeavengers.config.TestRootConfig;

/**
 * The class <code>TestGenericReadOnlyPersister</code> contains tests for the
 * class <code>{@link GenericReadOnlyPersister}</code>.
 *
 * @author abhishek
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
    TestRootConfig.class
})
public class TestGenericReadOnlyPersister {
    @Autowired
    @Qualifier("GenericReadOnlyPersister")
    private DatabasePersister persister;

    @Test
    public void testIdentify() throws Exception {
        // add additional test code here
        assertEquals(GenericReadOnlyPersister.class.getSimpleName(), persister.identify());
    }

    @Test
    public void testQuery() {
        Results result = (Results) persister.query("SELECT * FROM users");

        // add additional test code here
        // An unexpected exception was thrown in user code while executing this
        // test:
        // java.lang.IllegalArgumentException
        // at
        // org.codeavengers.main.data.db.impl.GenericReadOnlyPersister.query(GenericReadOnlyPersister.java:32)
        assertNotNull(result);
        assertNotNull(result.getNames());
        assertNotNull(result.getTypes());
        assertNotNull(result.getEntries());
        assertFalse(result.getEntries().isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQueryIllegalArgument() {
        persister.query("");
    }

    @Test(expected = DataAccessException.class)
    public void testQueryDataAccess() {
        persister.query("SELECT * FROM customer");
    }
}
