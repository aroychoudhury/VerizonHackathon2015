/* Copyright 2015 Code Avengers */

package org.codeavengers.main.data.db.extractor;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.codeavengers.common.dto.impl.Result;
import org.codeavengers.common.dto.impl.Results;
import org.codeavengers.common.exception.DataLayerFailureException;

/**
 * TODO
 * 
 * @author abhishek
 * @since 1.0
 */
public class ResultsExtractor extends AbstractExtractor<Results> {
    /**
     * @author abhishek
     * @since 1.0
     * @see org.springframework.jdbc.core.ResultSetExtractor#extractData(java.sql.ResultSet)
     */
    @Override
    public Results extractDataInternal(ResultSet resultSet) throws DataLayerFailureException {
        Results results = new Results();

        if (null == resultSet) {
            return results;
        }

        try {
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

            List<Result> entries = new ArrayList<Result>(20);
            while (resultSet.next()) {
                String[] values = new String[count];
                for (int index = 0; index < count; index++) {
                    values[index] = this.resolveObject(resultSet, tmpTypes[index], (index + 1));
                }
                entries.add(new Result(values));
            }

            results.setNames(names);
            results.setTypes(types);

            if (0 != entries.size()) {
                results.setEntries(entries);
            }
        } catch (SQLException e) {
            throw new DataLayerFailureException(e);
        }

        return results;
    }

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
                throw new DataLayerFailureException("Unsupported Data Type Exception");
        }
    }

    private String resolveObject(ResultSet resultSet, int dbType, int colnIndex) throws SQLException {
        String resolvedValue = null;
        switch (dbType) {
            case Types.NUMERIC:
                resolvedValue = resultSet.getBigDecimal(colnIndex).toString();
            case Types.TINYINT:
                resolvedValue = Byte.toString(resultSet.getByte(colnIndex));
            case Types.SMALLINT:
                resolvedValue = Short.toString(resultSet.getShort(colnIndex));
            case Types.INTEGER:
                resolvedValue = Integer.toString(resultSet.getInt(colnIndex));
            case Types.BIGINT:
                resolvedValue = Long.toString(resultSet.getLong(colnIndex));
            case Types.DECIMAL:
                resolvedValue = resultSet.getBigDecimal(colnIndex).toString();
            case Types.REAL:
                resolvedValue = Float.toString(resultSet.getFloat(colnIndex));
            case Types.FLOAT:
                resolvedValue = Double.toString(resultSet.getDouble(colnIndex));
            case Types.DOUBLE:
                resolvedValue = Double.toString(resultSet.getDouble(colnIndex));
            case Types.CHAR:
                resolvedValue = resultSet.getString(colnIndex);
            case Types.VARCHAR:
                resolvedValue = resultSet.getString(colnIndex);
            case Types.LONGVARCHAR:
                resolvedValue = resultSet.getString(colnIndex);
            case Types.DATE:
                resolvedValue = resultSet.getDate(colnIndex).toString();
            case Types.TIME:
                resolvedValue = resultSet.getTime(colnIndex).toString();
            case Types.TIMESTAMP:
                resolvedValue = resultSet.getTimestamp(colnIndex).toString();
            case Types.BOOLEAN:
                resolvedValue = Boolean.toString(resultSet.getBoolean(colnIndex));
            default:
                resolvedValue = "";
        }
        return resolvedValue;
    }
}
