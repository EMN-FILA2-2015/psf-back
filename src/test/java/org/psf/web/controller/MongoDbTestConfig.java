package org.psf.web.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;

@Profile("test")
@Configuration
@EnableMongoRepositories
public class MongoDbTestConfig extends AbstractMongoConfiguration {

	public static final String databaseName = "fongo_test_database";
	
	@Override
	public Mongo mongo() throws Exception {
		return new Fongo(databaseName).getMongo();
	}

	@Override
	protected String getDatabaseName() {
		return databaseName;
	}
	
	@Override
	protected String getMappingBasePackage() {
		return "org.psf.domain";
	}
}

