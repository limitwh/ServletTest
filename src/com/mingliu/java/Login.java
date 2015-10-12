package com.mingliu.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet(name="Login",urlPatterns={"/Login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		HashMap<String,String> UserInfoMap = new HashMap<String,String>();
		try{
			if(new UserVerify().VerifyPSW(request.getParameter("username"), EncryptionByMD5.getMD5(request.getParameter("psw").getBytes()))){
				String status = new UserInfo().UserInfoItem("status","userview","username",request.getParameter("username"));
					if (status.equals("1")){
					pw.println("<br>");
					pw.println("You are new user, Please complete email verify process in below link :");
					pw.println("</br>");
					pw.println("<br>");
					pw.println("<a href=\"/ServletTest/NewUserVerify.html\">User e-mail Verify</a>");
					pw.println("</br>");
				} else  if(status.equals("2")){
							pw.println("<br>");
							pw.println("Your ID is suspended, Please contact system admin");
							pw.println("</br>");
						} else {
							UserInfoMap = new UserInfo().HashGet(request.getParameter("username"));			
							pw.println("<br>");
							pw.println("Logon succeed");
							pw.println("</br>");
							pw.println("<br>");
							pw.println("User Name:"+UserInfoMap.get("UserName"));
							pw.println("</br>");
							pw.println("<br>");
							pw.println("Mail address:"+UserInfoMap.get("MailAdd"));
							pw.println("</br>");
							pw.println("<br>");
							pw.println("Description:"+UserInfoMap.get("Description"));
							pw.println("</br>");
						}
			} else {
				pw.println("<br>");
				pw.println("Password incorrect!");
				pw.println("</br>");
			}
		} catch (Exception ea){
			ea.printStackTrace();
		}
	}

}
