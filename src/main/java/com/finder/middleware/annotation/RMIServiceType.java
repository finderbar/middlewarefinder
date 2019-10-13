package com.finder.middleware.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author JamesLwin
 * @createdAt Oct 13, 2019
 */

@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD })
public @interface RMIServiceType { 
	
	String requestUrl();

	Class serviceInterface();

	String name() default "";
	
}
