package com.asiertutorial.liferay.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asiertutorial.liferay.sample.dao.ActionDao;
import com.asiertutorial.liferay.sample.model.Action;


@Service
public class ActionService {

	@Autowired
	private ActionDao actionDAO;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void save(Action action) {
		actionDAO.save(action);
	}

}
