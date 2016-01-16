package com.asiertutorial.liferay.sample.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to log the action in the database and it should be
 * used in the custom dao methods
 * 
 * @author asier.garcia
 * 
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogSampleMethod {

	public enum Action {
		VIEW, SAVE, CREATE, UPDATE, DELETE;
	}

	public Action action() default Action.VIEW;

}
