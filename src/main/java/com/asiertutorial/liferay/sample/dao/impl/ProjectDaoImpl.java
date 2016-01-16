package com.asiertutorial.liferay.sample.dao.impl;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.asiertutorial.liferay.core.hibernate.BaseDaoImpl;
import com.asiertutorial.liferay.sample.dao.ProjectDao;
import com.asiertutorial.liferay.sample.model.Project;

@Repository
public class ProjectDaoImpl extends BaseDaoImpl<Project> implements ProjectDao {

	@Override
	protected Class<? extends Project> getEntityClass() {
		return Project.class;
	}

	@Override
	protected Order getDefaultOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
