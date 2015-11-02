<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.mingliu.javabean.TestBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Jsp Bean</title>
</head>
<body>
	<jsp:useBean id="FristBean" class="com.mingliu.javabean.TestBean"></jsp:useBean>
	<jsp:setProperty name="FristBean" property="user" value="jack" />
	<jsp:getProperty name="FristBean" property="user" />
<br><jsp:setProperty name="FristBean" property="age" param="nianling"/>
	<jsp:getProperty name="FristBean" property="age" />
</body>
</html>