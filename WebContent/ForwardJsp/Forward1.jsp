<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Forward 1 page</title>
</head>
<body bgcolor="white">>
	here is forward 1 page
	<jsp:forward page="ForwardPink.jsp">
	<jsp:param value='<%=request.getParameter("color") %>' name="color"/>
	<jsp:param value="1 Page" name="ForwardPage"/>
	</jsp:forward>
</body>
</html>