<%@ page language="java" contentType="text/html"
    pageEncoding="gb2312"%>
<%@ page errorPage="ErrPage.jsp"%>
<%
	String s = "123plus";
	int i = Integer.parseInt(s);
	out.print("s="+s+" i="+i);
%>