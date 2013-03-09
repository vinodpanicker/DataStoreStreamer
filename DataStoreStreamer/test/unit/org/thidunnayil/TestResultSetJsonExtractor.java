package org.thidunnayil;

import static org.junit.Assert.*;

import org.codehaus.groovy.grails.web.json.JSONArray;
import org.junit.Test;

public class TestResultSetJsonExtractor {
	String USER_HOME= System.getProperty("user.home");

	@Test
	public void testResultSetJsonExtractor() {
		String tablename = "files";
		String connectionName = "testmysqlconnection";
		new MySQLConnector(connectionName).openConnection().fetchResultSet(tablename);
		
	}
	
	@Test
	public void testResultSetJsonExtractorForFileConnector() {
		String directory = USER_HOME+"/.m2";
		String connectionName = "testfileconnection";
		assertNotNull(new FileSystemConnector(connectionName).openConnection().fetchJson(directory));
		
	}
	
	@Test
	public void testResultSetJsonExtractorUsingAggregator() {
		String directory = USER_HOME+"/.m2";
		String connectionName = "testfileconnection";
		JSONArray result = new FileSystemConnector(connectionName).openConnection().fetch(directory);
		assertNotNull(result);
		int actual=new FileConnectorTestHelper().getFileCount(directory);
		assertEquals(actual,result.length());
	}

}
