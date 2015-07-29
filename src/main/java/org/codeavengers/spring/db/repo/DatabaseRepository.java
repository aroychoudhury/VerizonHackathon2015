/* Copyright 2015 Code Avengers */

package org.codeavengers.spring.db.repo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Repository;

/**
 * TODO
 * @author abhishek
 * @since  1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repository
public @interface DatabaseRepository {

}
