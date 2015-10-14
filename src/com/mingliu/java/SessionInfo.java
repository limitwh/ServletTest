package com.mingliu.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionInfo
 */
@WebServlet("/SessionInfo")
public class SessionInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession mySession = request.getSession(true);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Session Information Servlet</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<H3>Session Information</H3>");
		out.println("New Session");
		out.println("<BR>Session ID: "+mySession.isNew());
		out.println("<BR>Session Creation Time: "+ new java.util.Date(mySession.getCreationTime()));
		out.println("<BR>Session last access time: "+ new java.util.Date(mySession.getLastAccessedTime()));
		out.println("<H3>Request Information</H3>");
		out.println("<BR>Session ID from Request: "+ request.getRequestedSessionId());
		out.println("<BR>Session ID via Cookie: "+ request.isRequestedSessionIdFromCookie());
		out.println("<BR>Session ID via rewritten URL: "+ request.isRequestedSessionIdFromURL());
		out.println("<BR>Valid Session ID: "+ request.isRequestedSessionIdValid());
		out.println("<BR><a href="+response.encodeRedirectURL("SessionInfo")+">refresh</a>");
		out.println("</BODY></HTML>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

}
