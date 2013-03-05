package org.thidunnayil;

import java.sql.ResultSet;
import groovy.util.logging.Log;
import org.codehaus.groovy.grails.web.json.JSONObject;
@Log
public class ColumnVisitor {
	
	def visitType=["${java.sql.Types.ARRAY}": "visitArray",
	"${java.sql.Types.BIGINT}":"visitBigInt",
	"${java.sql.Types.BOOLEAN}":"visitBoolean",
	"${java.sql.Types.BLOB}":"visitBlob",
	"${java.sql.Types.DOUBLE}":"visitDouble",
	"${java.sql.Types.FLOAT}":"visitFloat",
	"${java.sql.Types.INTEGER}":"visitInteger",
	"${java.sql.Types.NVARCHAR}":"visitNString",
	"${java.sql.Types.VARCHAR}":"visitString",
	"${java.sql.Types.TINYINT}":"visitTinyInt",
	"${java.sql.Types.SMALLINT}":"visitSmallInt",
	"${java.sql.Types.DATE}":"visitDate",
	"${java.sql.Types.TIMESTAMP}":"visitTimeStamp"
	]
	
	public JSONObject visit(int type,JSONObject obj, String column_name, ResultSet rs)
	
	{
		def visitMethodName=visitType[type]
		
		return "${visitMethodName}"(obj, column_name,rs); 
	}
	
	private static JSONObject visitDefault(JSONObject obj, String column_name, ResultSet rs) {
		obj.put(column_name, rs.getObject(column_name))
	}

	private static visitTimeStamp(JSONObject obj, String column_name, ResultSet rs) {
		obj.put(column_name, rs.getTimestamp(column_name))
	}

	private static visitDate(JSONObject obj, String column_name, ResultSet rs) {
		obj.put(column_name, rs.getDate(column_name))
	}

	private static visitSmallInt(JSONObject obj, String column_name, ResultSet rs) {
		obj.put(column_name, rs.getInt(column_name))
	}

	private static visitTinyInt(JSONObject obj, String column_name, ResultSet rs) {
		obj.put(column_name, rs.getInt(column_name))
	}

	private static visitDouble(JSONObject obj, String column_name, ResultSet rs) {
		obj.put(column_name, rs.getDouble(column_name))
	}

	private static visitInteger(JSONObject obj, String column_name, ResultSet rs) {
		obj.put(column_name, rs.getInt(column_name))
	}

	private static visitFloat(JSONObject obj, String column_name, ResultSet rs) {
		obj.put(column_name, rs.getFloat(column_name))
	}

	private static visitBlob(JSONObject obj, String column_name, ResultSet rs) {
		obj.put(column_name, rs.getBlob(column_name))
	}

	private static visitBoolean(JSONObject obj, String column_name, ResultSet rs) {
		obj.put(column_name, rs.getBoolean(column_name))
	}

	private static visitBigInt(JSONObject obj, String column_name, ResultSet rs) {
		obj.put(column_name, rs.getInt(column_name))
	}

	private static visitArray(JSONObject obj, String column_name, ResultSet rs) {
		obj.put(column_name, rs.getArray(column_name))
	}

	private static visitNString(JSONObject obj, String column_name, ResultSet rs) {
		obj.put(column_name, rs.getNString(column_name))
	}
	private static visitString(JSONObject obj, String column_name, ResultSet rs) {
		obj.put(column_name, rs.getString(column_name))
	}

}
