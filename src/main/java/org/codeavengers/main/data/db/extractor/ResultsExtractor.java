/* Copyright 2015 Code Avengers */

package org.codeavengers.main.data.db.extractor;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.codeavengers.common.dto.entity.Result;
import org.codeavengers.common.dto.entity.Results;
import org.codeavengers.main.data.db.AbstractExtractor;
import org.springframework.dao.DataRetrievalFailureException;

/**
 * This is a generic implementation of
 * {@link org.springframework.jdbc.core.ResultSetExtractor} which allows
 * capturing any database query output in generic java beans.
 * 
 * A combination of the {@link org.codeavengers.common.dto.entity.Result} and
 * {@link org.codeavengers.common.dto.entity.Results} entities are leveraged to
 * achieve a generic mapping.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.springframework.jdbc.core.ResultSetExtractor
 * @see org.codeavengers.common.dto.entity.Result
 * @see org.codeavengers.common.dto.entity.Results
 */
public class ResultsExtractor extends AbstractExtractor<Results> {
    /**
     * @author abhishek
     * @since 1.0
     * @see org.springframework.jdbc.core.ResultSetExtractor#extractData(java.sql.ResultSet)
     */
    @Override
    public Results extractDataInternal(ResultSet resultSet) {
        if (null == resultSet) {
            return new Results();
        }
        return this.process(resultSet);
    }

    private Results process(ResultSet resultSet) {
        Results results = new Results();
        try {
            int[] tmpTypes = this.processMetadata(results, resultSet);

            List<Result> entries = this.processData(resultSet, tmpTypes);

            /* set if the entries have some valid values */
            results.setEntries(entries.isEmpty() ? results.getEntries() : entries);
        } catch (SQLException e) {
            throw new DataRetrievalFailureException("ResultSet parsing failed", e);
        }
        return results;
    }

    private List<Result> processData(ResultSet resultSet, int[] tmpTypes) throws SQLException {
        int count = tmpTypes.length;
        List<Result> entries = new ArrayList<Result>(20);
        while (resultSet.next()) {
            String[] values = new String[count];
            for (int index = 0; index < count; index++) {
                values[index] = this.resolveObject(resultSet, tmpTypes[index], (index + 1));
            }
            entries.add(new Result(values));
        }
        return entries;
    }

    private int[] processMetadata(Results results, ResultSet resultSet) throws SQLException {
        /* ResultSetMetaData processing. Metadata follows index from 1. */
        ResultSetMetaData metadata;
        metadata = resultSet.getMetaData();
        int count = metadata.getColumnCount();
        int[] tmpTypes = new int[count];
        String[] names = new String[count];
        String[] types = new String[count];
        for (int index = 0; index < count; index++) {
            names[index] = metadata.getColumnName(index + 1);
            tmpTypes[index] = metadata.getColumnType(index + 1);
            types[index] = this.resolveType(tmpTypes[index]);
        }
        results.setNames(names);
        results.setTypes(types);
        return tmpTypes;
    }

    /**
     * Resolves the Database data-type information and returns a understandable
     * String.
     * 
     * @param dbType
     *            database column data-type as defined by {@link java.sql.Types}
     * @return string column name to be displayed on the GUI
     * @author abhishek
     * @since 1.0
     * @see java.sql.Types
     */
    private String resolveType(int dbType) {
        switch (dbType) {
            case Types.NUMERIC:
                return "NUMBER";
            case Types.TINYINT:
                return "NUMBER";
            case Types.SMALLINT:
                return "NUMBER";
            case Types.INTEGER:
                return "NUMBER";
            case Types.BIGINT:
                return "NUMBER";
            case Types.DECIMAL:
                return "DECIMAL";
            case Types.REAL:
                return "DECIMAL";
            case Types.FLOAT:
                return "DECIMAL";
            case Types.DOUBLE:
                return "DECIMAL";
            case Types.CHAR:
                return "STRING";
            case Types.VARCHAR:
                return "STRING";
            case Types.NCHAR:
                return "STRING";
            case Types.NVARCHAR:
                return "STRING";
            case Types.LONGNVARCHAR:
                return "STRING";
            case Types.LONGVARCHAR:
                return "STRING";
            case Types.NULL:
                return "STRING";
            case Types.DATE:
                return "DATE";
            case Types.TIME:
                return "TIME";
            case Types.TIMESTAMP:
                return "TIME";
            case Types.BOOLEAN:
                return "BOOLEAN";
            default:
                throw new UnsupportedOperationException("Unsupported Data Type Exception");
        }
    }

    /**
     * @param resultSet
     *            {@link java.sql.ResultSet} to be parsed
     * @param dbType
     *            database column data-type as defined by {@link java.sql.Types}
     * @param colnIndex
     *            the column index
     * @return string value to be displayed on the GUI
     * @throws SQLException
     * @author abhishek
     * @since 1.0
     * @see java.sql.ResultSet
     */
    private String resolveObject(ResultSet resultSet, int dbType, int colnIndex) throws SQLException {
        String resolvedValue = null;
        switch (dbType) {
            case Types.NUMERIC:
                resolvedValue = resultSet.getBigDecimal(colnIndex).toString();
                break;
            case Types.TINYINT:
                resolvedValue = Byte.toString(resultSet.getByte(colnIndex));
                break;
            case Types.SMALLINT:
                resolvedValue = Short.toString(resultSet.getShort(colnIndex));
                break;
            case Types.INTEGER:
                resolvedValue = Integer.toString(resultSet.getInt(colnIndex));
                break;
            case Types.BIGINT:
                resolvedValue = Long.toString(resultSet.getLong(colnIndex));
                break;
            case Types.DECIMAL:
                resolvedValue = resultSet.getBigDecimal(colnIndex).toString();
                break;
            case Types.REAL:
                resolvedValue = Float.toString(resultSet.getFloat(colnIndex));
                break;
            case Types.FLOAT:
                resolvedValue = Double.toString(resultSet.getDouble(colnIndex));
                break;
            case Types.DOUBLE:
                resolvedValue = Double.toString(resultSet.getDouble(colnIndex));
                break;
            case Types.CHAR:
                resolvedValue = resultSet.getString(colnIndex);
                break;
            case Types.VARCHAR:
                resolvedValue = resultSet.getString(colnIndex);
                break;
            case Types.LONGVARCHAR:
                resolvedValue = resultSet.getString(colnIndex);
                break;
            case Types.DATE:
                resolvedValue = resultSet.getDate(colnIndex).toString();
                break;
            case Types.TIME:
                resolvedValue = resultSet.getTime(colnIndex).toString();
                break;
            case Types.TIMESTAMP:
                resolvedValue = resultSet.getTimestamp(colnIndex).toString();
                break;
            case Types.BOOLEAN:
                resolvedValue = Boolean.toString(resultSet.getBoolean(colnIndex));
                break;
            default:
                resolvedValue = "";
                break;
        }
        return resolvedValue;
    }
}
