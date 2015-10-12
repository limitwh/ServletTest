package com.mingliu.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class UserDB {

	public static String UseInsert(String target, Map<String, String[]> Item) throws Exception {
		return DBchange("INSERT INTO "+target+" set ","",Item);
	}
	public static String UseUpdate(String target, String Where, Map<String, String[]> Item) throws Exception {
		return DBchange("UPDATE "+target+" set ",Where,Item);
	}

	protected static String DBchange(String ExecSQL,String SQLend,Map<String, String[]> InsertItem)  throws Exception {
		Connection conn = null;
		String URL = null;
		Statement stmt = null;
		ResultSet rs = null;
		String ItemKey = null;
		String[] ItemValue = null;
		String ItemList = null;
		String ReturnString = "DataBase Unknow Error!!!";
		int SQLcode;
		try{
			Iterator<Entry<String, String[]>> iter = InsertItem.entrySet().iterator();
			while (iter.hasNext()) {
				Entry<String, String[]> entry = iter.next();
				ItemKey=entry.getKey();
				ItemValue=entry.getValue();
				if(iter.hasNext()){
					ItemList = ItemKey+"="+"'"+ItemValue[0]+"' "+",";
				} else {
					ItemList = ItemKey+"="+"'"+ItemValue[0]+"' ";
				}
				ExecSQL = ExecSQL + ItemList;
			}
			ExecSQL = ExecSQL+SQLend;
//			System.out.println(ExecSQL);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			URL = "jdbc:mysql://localhost/userdb";
			conn = DriverManager.getConnection(URL, "useradminA", "123456");
			stmt = conn.createStatement();
			SQLcode = stmt.executeUpdate(ExecSQL);
			if (SQLcode == 1 ) {
				ReturnString = Integer.toString(SQLcode);
			} else {
				ReturnString = "SQL error/Database error, return SQL code: "+SQLcode;
			}
		} catch (ClassNotFoundException ea){
			ea.printStackTrace();
		} catch (SQLException eb) {
			System.out.println("SQLException" + eb.getMessage());
			System.out.println("SQLState" + eb.getSQLState());
			System.out.println("VendorError: " + eb.getErrorCode());
		} finally {
			try {
				if(rs != null){
					rs.close();
				    rs=null;
				}
				if(stmt != null){
					stmt.close();
				    stmt=null;
				}
				if(conn != null){
					conn.close();
				    conn=null;
				}
			} catch(SQLException e) {
				e.printStackTrace();
				}
		}
		return ReturnString;
		}
}
