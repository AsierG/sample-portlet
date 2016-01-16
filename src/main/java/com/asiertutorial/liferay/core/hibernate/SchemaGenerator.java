package com.asiertutorial.liferay.core.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class SchemaGenerator {

	private static void createSchema() {

		Configuration configuration = new Configuration()
				.configure("hibernate.cfg.xml");
		configuration.buildMappings();

		AuditConfiguration.getFor(configuration);

		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.setDelimiter(";");
		// schemaExport.setFormat(true);
		schemaExport.setOutputFile(String.format(
				"src/main/resources/sql/%s.%s", "create-schema", "sql"));

		boolean consolePrint = true;
		boolean exportInDatabase = false;
		schemaExport.create(consolePrint, exportInDatabase);

	}

	public static void main(String[] args) {
		createSchema();
	}

}
