package com.asiertutorial.liferay.sample.dao.impl;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asiertutorial.liferay.core.hibernate.BaseDaoImpl;
import com.asiertutorial.liferay.sample.dao.ActionDao;
import com.asiertutorial.liferay.sample.model.Action;

@Component
// @Repository("actionDao")
@Transactional(propagation = Propagation.MANDATORY)
public class ActionDAOImpl extends BaseDaoImpl<Action> implements ActionDao {

	private static final Order DEFAULT_ORDER = Order.asc("id");

	@Override
	protected Class<? extends Action> getEntityClass() {
		return Action.class;
	}

	@Override
	protected Order getDefaultOrder() {
		return DEFAULT_ORDER;
	}

}
