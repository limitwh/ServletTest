<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Test Bar</title>
</head>
<body>
	<table>
		<tr><TD><% out.println("HI "+request.getParameter("name")); %></TD></tr>
	</table>
</body>
</html>