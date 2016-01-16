package com.asiertutorial.liferay.sample.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asiertutorial.liferay.sample.dao.ProjectDao;
import com.asiertutorial.liferay.sample.model.Project;

@Service
public class ProjectService {

	@Autowired
	private ProjectDao projectDao;

	@Transactional(readOnly = true)
	public List<Project> getProjects() {
		return projectDao.findAll();
	}

	@Transactional
	public Project save(long userId, long companyId, long scopeGroupId,
			Project project) {

		Date now = new Date();

		project.setCompanyId(companyId);
		project.setGroupId(scopeGroupId);
		project.setCreateDate(now);
		project.setModifiedDate(now);

		return projectDao.save(project);
	}

}
