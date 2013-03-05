package org.thidunnayil

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.codehaus.groovy.grails.web.json.JSONArray;
import org.codehaus.groovy.grails.web.json.JSONException;
import org.codehaus.groovy.grails.web.json.JSONObject;

class ResultSetJsonExtractor {
	static def columnVisitor = new ColumnVisitor()

	public static JSONArray convert( ResultSet rs )
	throws SQLException, JSONException
  {
	JSONArray json = new JSONArray();
	ResultSetMetaData rsmd = rs.getMetaData();

	while(rs.next()) {
	  int numColumns = rsmd.getColumnCount();
	  JSONObject obj = new JSONObject();

	  for (int i=1; i<numColumns+1; i++) {
		String column_name = rsmd.getColumnName(i);
		int column_type=rsmd.getColumnType(i)
		  obj =columnVisitor.visit(column_type,obj, column_name, rs);
	  }

	  json.put(obj);
	}

	return json;
  }

	
}
