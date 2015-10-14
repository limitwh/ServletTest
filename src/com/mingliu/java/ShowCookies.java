package com.mingliu.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowCookies
 */
@WebServlet(name="ShowCookies",urlPatterns={"/ShowCookies"})
public class ShowCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String title = "Show Cookies";
		out.println("<HTML><head><title>Show Cookies</title></head>" + "<BODY BGCOLOR=\"#FDF5E6\">\n"
				+	"<H1 ALIGN=\"CENTER\">" + title + "</H1>\n"
				+	"<TABLE BORDER=1 ALIGN=\"CENTER\">\n" + "<TR BGCOLOR=\"#FFA000\">\n"
				+	"<TH>Cookie name\n" + "<TH>Cookie Value"
				);
		Cookie[] cookies =  request.getCookies();
		if(cookies != null)
		{
			Cookie cookie;
			for(int i=0;i<cookies.length;i++)
			{
				cookie=cookies[i];
				out.println("<TR>\n"+"  <TD>"+cookie.getName()+"</TD>\n"+"  <TD>\n"+cookie.getValue()+"</TD></TR>\n");
			}
			out.println("</TABLE></BODY></HTML>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
