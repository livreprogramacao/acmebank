package com.acmebank.dao;

import com.acmebank.common.Profiled;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;

@Profiled
@ApplicationScoped
@Stereotype
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dao {
}
