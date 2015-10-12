package com.mingliu.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewVerify
 */
@WebServlet(name="NewVerify",urlPatterns={"/NewVerify"})
public class NewVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewVerify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		Map<String, String[]> UpdateItem = new HashMap<String, String[]>();
		try{
			if(new UserVerify().VerifyItem("verifycode",request.getParameter("verifycode"))){
				UpdateItem.put("verifycode", new String[]{""});
				UpdateItem.put("status", new String[]{"0"});
				String SQLmessage = UserDB.UseUpdate("UserTable", "where verifycode = '"+request.getParameter("verifycode")+"'", UpdateItem);
				if(SQLmessage.equals("1")){
					pw.println("<br>");
					pw.println("You can login system now : ");
					pw.println("<a href=\"/ServletTest/Login.html\">Login</a>");
					pw.println("</br>");
				} else {
					pw.println("<br>");
					pw.println("Error message:");
					pw.println("</br>");
					pw.println("<br>");
					pw.println(SQLmessage);
					pw.println("</br>");
				}	

			} else {
				pw.println("<br>");
				pw.println("Verify code incorrect");
				pw.println("</br>");
			}
		} catch (Exception ea){
			ea.printStackTrace();
		}
	}

}
