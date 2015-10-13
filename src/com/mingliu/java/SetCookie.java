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
 * Servlet implementation class SetCookie
 */
@WebServlet(name="SetCookie",urlPatterns={"/SetCookie"})
public class SetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SetCookie() {
        super();
        // TODO Auto-generated constructor stub
    }
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for(int i = 0;i<3;i++){
			Cookie cookie = new Cookie("Session-Cookie-"+i,"Cookie-Value-S"+i);
			response.addCookie(cookie);
			cookie = new Cookie("Persistent-Cookie-"+i, "Persistent-Value-"+i);
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		}
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String title = "Setting Cookie";
		out.println("<html><head><title>Setting Cookie</title></head>"
				+	"<H1 ALIGN=\"CENTER\">" + title + "</H1>\n"
				+	"Save 6 cookies from this page.\n"
				+	"See cookie info in here:\n" 
				+	"<A HREF=\"ShowCookies\"\n>"
				+	"<CODE>ShowCookies</CODE> servlet</A>.\n"
				+	"<html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

}
