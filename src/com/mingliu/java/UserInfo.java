package com.mingliu.java;

import java.sql.*;
import java.util.HashMap;

public class UserInfo {
	Connection conn = null;
	String URL = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public HashMap<String,String> HashGet(String username)  throws Exception {
	HashMap<String,String> UserInf = new HashMap<String,String>();
	String SQLstr = "select * from UserView where UserName = '" + username + "'";
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		URL = "jdbc:mysql://localhost/userdb";
		conn = DriverManager.getConnection(URL, "useradminH", "123456");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(SQLstr);
		while (rs.next()) {
			for (int i = 1; i < rs.getMetaData().getColumnCount()+1; i++) {
				UserInf.put(rs.getMetaData().getColumnName(i), rs.getString(rs.getMetaData().getColumnName(i)));
			}
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
	return UserInf;
	}
	
	public String UserInfoItem(String select, String table,String where, String value) throws Exception {

		String SQLstr = "select "+select+" from "+table+" where "+where+" = '"+value+"'";
		String returnValue = "";
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			URL = "jdbc:mysql://localhost/userdb";
			conn = DriverManager.getConnection(URL, "useradminH", "123456");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQLstr);
			while (rs.next()) {
				returnValue = rs.getString(select);
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
		return returnValue;
	}
	
}
