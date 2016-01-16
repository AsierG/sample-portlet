package com.asiertutorial.liferay.core.hibernate;

import java.io.Serializable;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.SequenceGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

public class LiferayCounterGenerator extends SequenceGenerator {

	private static final Logger LOG = LoggerFactory
			.getLogger(LiferayCounterGenerator.class);

	@Override
	public Serializable generate(SessionImplementor session, Object obj) {
		Long id = null;
		try {
			id = CounterLocalServiceUtil.increment(obj.getClass().getName());
		} catch (SystemException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("Error retrieving counter for class "
						+ obj.getClass().getName(), e);
			}
		}
		return id;
	}
}
