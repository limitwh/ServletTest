package com.mingliu.java;

import java.sql.*;

public class UserVerify {
	Connection conn = null;
	String URL = null;
	Statement stmt = null;
	ResultSet rs = null;
	String SQLstr = null;
	
	protected boolean VerifyPSW(String username, String psw) throws Exception {

		String SQLstr = "select Password from userpswview where UserName = '" + username + "'";
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			URL = "jdbc:mysql://localhost/userdb";
			conn = DriverManager.getConnection(URL, "useradminH", "123456");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQLstr);
			while (rs.next()) {
				if(rs.getString("Password").equals(psw))
				{
					flag = true;
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
		return flag;
	}
	
	public boolean VerifyItem(String select, String value) throws Exception {
		boolean flag = false;
		try{
			flag = new UserInfo().UserInfoItem(select,"userview",select,value).equals(value);
		}  catch (Exception ea){
			ea.printStackTrace();
		}
		return flag;
	}
}
