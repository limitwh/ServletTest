<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Expression</title>
</head>
<body>
	<H2>JSP Expression</H2>
	<UL>
		<LI>Current time :<%= new Date() %></LI>
		<LI>Your IP :<%=request.getRemoteHost() %></LI>
		<LI>Your session ID :<%=session.getId() %></LI>
		<LI>The <CODE>testParm</CODE> from parameter:<%=request.getParameter("testParm") %></LI>
	</UL>
</body>
</html>