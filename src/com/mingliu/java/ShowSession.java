package com.mingliu.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Servlet implementation class ShowSession
 */
@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Session Tracking Example";
		HttpSession mysession = request.getSession(true);
		String Heading;
		Integer accesscount = (Integer)mysession.getAttribute("accesscount");
		if(accesscount == null){
			accesscount = new Integer(0);
			Heading = "Welcome new comer";
		}else{
			accesscount = new Integer(accesscount.intValue()+1);
			Heading = "Welcome come back";
		}
		mysession.setAttribute("accesscount", accesscount);
		
		out.println("<html><head><title>Session Tracking</title></head>"
				+	"<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=\"CENTER\">"
				+	Heading + "</H1>\n" + "<H2>Information on your session:</H2>\n" 
				+	"<TABLE BORDER=1 ALIGN=\"CENTER\">"
				+	"<TR BGCOLOR=\"#FFAD00\">\n" + "  <TH>Info Type<TH>Value\n"
				+	"<TR>\n" + "   <TD>ID\n" + "  <TD>" + mysession.getId() + "\n"
				+	"<TR>\n" + "   <TD>Creation time" + "  <TD>"
				+	new Date(mysession.getCreationTime()) + "\n" + "<TR>\n"
				+	"   <TD>Time of last access\n" + "   <TD>" 
				+	new Date(mysession.getLastAccessedTime()) + "\n" + "<TR>\n"
				+	"   <TD>Number of access\n" + "   <TD>"
				+	accesscount + "\n" + "</TABLE>\n" + "</BODY></HTML>"
				);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
