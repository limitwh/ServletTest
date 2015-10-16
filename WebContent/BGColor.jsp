<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Parameter Test</title>
</head>

<%
	String bgColor = request.getParameter("bgColor");
	boolean hasExpColor;
	if (bgColor !=null )
	{
		hasExpColor = true;
	}else{
		hasExpColor = false;
		bgColor = "WHITE";
	}

%>
	<body BGCOLOR="<%= bgColor %>">
	<H2 ALIGN="CENTER">Color Test</H2>
<%
	if(hasExpColor){
		out.println("You choice color is :"+ bgColor);
	}else{
		out.println("When you didn't choice color, the bgColor is white.");
	}
%>



</body>
</html>