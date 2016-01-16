package com.asiertutorial.liferay.sample.aop;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asiertutorial.liferay.sample.annotations.LogSampleMethod;
import com.asiertutorial.liferay.sample.model.Action;
import com.asiertutorial.liferay.sample.model.Base;
import com.asiertutorial.liferay.sample.service.ActionService;

/**
 * This class create an action log using reflection with annotations and AOP
 * 
 * @author asier.garcia
 * 
 */

@Aspect
@Component
public class LogSampleActionAspect {

	private static final Logger LOG = Logger
			.getLogger(LogSampleActionAspect.class);

	@Autowired
	private ActionService actionService;

	@Around("execution(@com.asiertutorial.liferay.sample.annotations.LogSampleMethod * com.asiertutorial.liferay.sample.dao.impl.*.*(..))")
	public Object logDAOAction(ProceedingJoinPoint joinPoint) throws Throwable {

		Object result = null;

		result = joinPoint.proceed();

		Signature signature = joinPoint.getSignature();
		Method method = ((MethodSignature) signature).getMethod();

		for (Object obj : joinPoint.getArgs()) {

			Method objectMethod = null;
			try {
				objectMethod = joinPoint.getTarget().getClass()
						.getMethod(method.getName(), obj.getClass());
			} catch (NoSuchMethodException nsme) {
				// If we are working with superclass, we will check it
				objectMethod = joinPoint
						.getTarget()
						.getClass()
						.getMethod(method.getName(),
								obj.getClass().getSuperclass());
			}

			if (objectMethod != null) {

				LogSampleMethod limited = objectMethod
						.getAnnotation(LogSampleMethod.class);
				LogSampleMethod.Action actionParam = limited.action();

				Long entityId = null;

				// search by GET method
				for (Method entityMethod : obj.getClass().getMethods()) {
					if (entityMethod
							.isAnnotationPresent(javax.persistence.Id.class)) {
						entityId = (Long) entityMethod.invoke(obj,
								new Object[] {});
					}
				}

				// search by attribute
				for (Field entityField : obj.getClass().getFields()) {
					if (entityField
							.isAnnotationPresent(javax.persistence.Id.class)) {
						entityId = (Long) entityField.get(obj);
					}
				}

				Action action = new Action();
				action.setType(actionParam.toString());
				action.setModel(obj.getClass().getName());
				action.setResourceId(entityId);
				action.setActionDate(new Date());

				if (Base.class.equals(obj.getClass().getSuperclass())
						|| Base.class.equals(obj.getClass().getSuperclass()
								.getSuperclass())) {
					action.setUserId(((Base) obj).getUserModifierId());
				}

				actionService.save(action);

				if (LOG.isDebugEnabled()) {
					LOG.debug("Logging action: " + action.toString());
				}
			} else {
				LOG.error(
						"There was an error getting method in Log Aspect, objectMethod is null ",
						null);
			}
		}

		return result;
	}
}
