/* Copyright 2015 Code Avengers */

package org.codeavengers.main.data.db.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

/**
 * TODO
 * 
 * @author abhishek
 * @since 1.0
 */
@Repository
public class JdbcExecuter {
    private JdbcTemplate template = null;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public <T> T test(String query, ResultSetExtractor<T> extractor) {
        return this.template.query(query, extractor);
    }
}
