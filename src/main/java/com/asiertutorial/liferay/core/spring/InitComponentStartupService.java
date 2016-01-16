package com.asiertutorial.liferay.core.spring;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.web.context.ServletContextAware;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceComponentLocalServiceUtil;

public class InitComponentStartupService implements ServletContextAware {

	private static final Logger LOG = Logger
			.getLogger(InitComponentStartupService.class);

	public void initServiceComponent() {
		
		File servicePropertiesFile = new File(
				servletContext
						.getRealPath("WEB-INF/classes/service.properties"));
		if (!servicePropertiesFile.exists()) {
			return;
		}
		Properties serviceProperties = new Properties();
		try {
			serviceProperties.load(new FileInputStream(servicePropertiesFile));
		} catch (Exception e) {
			LOG.error("Error initializing component", e);
		}

		if (serviceProperties.size() == 0) {
			return;
		}

		String buildNamespace = GetterUtil.getString(serviceProperties
				.getProperty("build.namespace"));
		long buildNumber = GetterUtil.getLong(serviceProperties
				.getProperty("build.number"));
		long buildDate = GetterUtil.getLong(serviceProperties
				.getProperty("build.date"));
		boolean buildAutoUpgrade = GetterUtil.getBoolean(
				serviceProperties.getProperty("build.auto.upgrade"), true);

		if (LOG.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("Build info [namespace: ");
			sb.append(buildNamespace);
			sb.append(", number: ");
			sb.append(buildNumber);
			sb.append(", date: ");
			sb.append(buildDate);
			sb.append(", auto upgrade: ");
			sb.append(buildAutoUpgrade);
			sb.append("]");
			LOG.debug(sb.toString());
		}

		if (Validator.isNull(buildNamespace)) {
			return;
		}

		try {
			if (PortalBeanLocatorUtil.getBeanLocator() != null) {
				ServiceComponentLocalServiceUtil.initServiceComponent(
						this.servletContext, this.getClass().getClassLoader(),
						buildNamespace, buildNumber, buildDate,
						buildAutoUpgrade);
			}
		} catch (Exception e) {
			LOG.error("Error initializing component", e);
		}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	private ServletContext servletContext;
}
