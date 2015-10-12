package com.mingliu.java;

import java.sql.*;

public class SQLTest {
	public static void main(String args[]) throws Exception	{
		Connection conn = null;
		String URL = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			URL = "jdbc:mysql://localhost/userdb";
			conn = DriverManager.getConnection(URL, "useradminH", "123456");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from userpswview");
			while (rs.next()) {
				System.out.println(rs.getString("UserName"));
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
	}
}
