package test.codeavengers.main.data.db.extractor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.ResultSet;

import org.codeavengers.common.dto.entity.Results;
import org.codeavengers.main.data.db.extractor.ResultsExtractor;
import org.hsqldb.jdbc.JDBCResultSet;
import org.hsqldb.result.Result;
import org.hsqldb.result.ResultMetaData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.codeavengers.config.TestRootConfig;

/**
 * The class <code>TestResultsExtractor</code> contains tests for the class
 * <code>{@link ResultsExtractor}</code>.
 * 
 * @author abhishek
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
    TestRootConfig.class
})
public class TestResultsExtractor {
    /**
     * Run the Results extractDataInternal(ResultSet) method test.
     *
     * @throws Exception
     */
    @Test
    public void testExtractDataInternal() throws Exception {
        ResultsExtractor fixture = new ResultsExtractor();

        ResultSet resultSet = JDBCResultSet.newJDBCResultSet(Result.emptyGeneratedResult, ResultMetaData.emptyParamMetaData);
        Results result = fixture.extractDataInternal(resultSet);

        // add additional test code here
        assertNotNull(result);
        assertEquals("Results - entries : []", result.toString());
    }
}
