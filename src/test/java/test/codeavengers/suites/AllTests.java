/* Copyright 2015 Roychoudhury, Abhishek */

package test.codeavengers.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.codeavengers.common.dto.TestRestWrapper;
import test.codeavengers.common.dto.wrap.TestCategoryWrapper;
import test.codeavengers.common.dto.wrap.TestLocationWrapper;
import test.codeavengers.main.data.db.extractor.TestResultsExtractor;
import test.codeavengers.main.data.db.impl.TestGenericReadOnlyPersister;
import test.codeavengers.main.data.jpa.impl.TestCategoryPersister;
import test.codeavengers.main.data.jpa.impl.TestLocationPersister;
import test.codeavengers.main.service.impl.TestMapDataServiceImpl;

/**
 * TODO
 * 
 * @author abhishek
 * @since 1.0
 */
@RunWith(Suite.class)
@SuiteClasses({
    TestGenericReadOnlyPersister.class,
    TestMapDataServiceImpl.class,
    TestLocationPersister.class,
    TestCategoryPersister.class,
    TestRestWrapper.class,
    TestCategoryWrapper.class,
    TestLocationWrapper.class,
    TestResultsExtractor.class
})
public class AllTests {

}
