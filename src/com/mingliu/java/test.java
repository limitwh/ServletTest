package com.mingliu.java;

//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Map.Entry;

public class test {
	public static void main(String args[]) throws Exception{
/* ***START*** */			
//		String test = new UserInfo().UserInfoItem("username","userview","verifycode","348345f52d6a6a188c8d66479ba70271");
//		System.out.println(test);
//		
//		
//		Map<String, String[]> UpdateItem = new HashMap<String, String[]>();
//				UpdateItem.put("verifycode", new String[]{""});
//				UpdateItem.put("status", new String[]{"0"});
//				String SQLmessage = UserDB.UseUpdate("UserTable", "WHERE verifycode = '"+new UserInfo().UserInfoItem("verifycode","userview","verifycode","348345f52d6a6a188c8d66479ba70271")+"'", UpdateItem);
//				System.out.println("SQL CODE : "+SQLmessage);
/* ***END*** */				
/*访问数据库  ***START*** */		
//		boolean flag = new UserVerify().UserVerifyPSW("limitwh", "23123");
//		System.out.print(flag);
//		boolean flag = new UserVerify().UserVerifyName("limit");
//		System.out.print(flag);
/*访问数据库 ***END*** */		
		
/*SQL语句拼接：Insert/Update ***START*** */
//		HashMap<String,String[]> UserInfoMap = new HashMap<String,String[]>();
//		String ItemKey = null;
//		String[] ItemValue = null;
//		String[] ItemValue2 = {"test01"};
//		String[] ItemValue3 = {"111","222"};
//		String[] ItemValue4 = {"limitwh@hotmail.com"};
//		String[] ItemValue5 = {"2"};
//		String[] ItemValue6 = {"space desc"};
//		String ItemList = "";
//		String ExecSQL = "Insert into usertable set ";
//		String SQLend = "";
//		String ExecSQL = "Update usertable set ";
//		String SQLend = " Where UserName = 'test01'";
//		UserInfoMap.put("UserName",ItemValue2);
//		UserInfoMap.put("Password", ItemValue3);
//		UserInfoMap.put("MailAdd", ItemValue4);
//		UserInfoMap.put("Status", ItemValue5);
//		UserInfoMap.put("Description", ItemValue6);
//		
//		Iterator<Entry<String, String[]>> iter = UserInfoMap.entrySet().iterator();
//		while (iter.hasNext()) {
//			Entry<String, String[]> entry = iter.next();
//			ItemKey = entry.getKey();
//			ItemValue = entry.getValue();
//			if(iter.hasNext()){
//				ItemList = ItemKey+"="+"'"+ItemValue[0]+"'"+",";
//			} else {
//				ItemList = ItemKey+"="+"'"+ItemValue[0]+"'";
//			}
//			ExecSQL = ExecSQL + ItemList;
//		}
//		ExecSQL = ExecSQL+SQLend;
//		System.out.println(ExecSQL);
/*SQL语句拼接：Insert/Update ***END*** */		
		
/*遍历HashMap ***START*** */
//		System.out.println(UserInfoMap.get("User Name"));
//		System.out.println(UserInfoMap.get("Mail address"));
//		System.out.println(UserInfoMap.get("Description"));
//		Iterator<Entry<String, String>> iter = UserInfoMap.entrySet().iterator();
//		 while (iter.hasNext()) {
//			 Entry<String, String> entry = iter.next();
//			 System.out.println(entry.getKey()+" "+entry.getValue());
//		 }
/*遍历HashMap ***END*** */		

/*生产MD5码 ***START*** */		
//		String code = VerifyCodeCreate.getCode("a", "b");
//		String code = EncryptionByMD5.getMD5("1qazxsw2".getBytes());
//		System.out.println(code);
/*生产MD5码 ***END*** */

/*SMTP发送邮件 ***START*** */		
//		new MailService().MailNewUser("limitwh@163.com", "123123");
/*SMTP发送邮件 ***END*** */
		
	};
}