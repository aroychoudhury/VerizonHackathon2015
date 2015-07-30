/* Copyright 2015 Code Avengers */

package org.codeavengers.main.data.jpa;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract implementation of the Persister interface. This class wraps an
 * instance of {@link org.springframework.jdbc.core.JdbcTemplate}, which allows
 * access to utility JDBC methods.
 * 
 * @author abhishek
 * @since 1.0
 * @see org.codeavengers.main.data.db.DatabasePersister
 * @see org.springframework.jdbc.core.JdbcTemplate
 */
public abstract class AbstractJPAPersister<K, V> implements JPAPersister<K, V> {
    protected SessionFactory sessionFactory;

    /**
     * @param sessionFactory
     *            the sessionFactory to set
     * @since 1.0
     * @see SessionFactory
     */
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
