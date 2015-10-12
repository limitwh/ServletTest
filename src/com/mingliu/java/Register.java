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
 * Servlet implementation class Register
 */
@WebServlet(name="Register",urlPatterns={"/Register"})
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		Map<String, String[]> RegisterItem = new HashMap<String, String[]>();
		String VerifyCode = null;
		String[] psw=request.getParameterValues("password");
		if(psw[0].equals(psw[1])){
			try{
				if(new UserVerify().VerifyItem("username",request.getParameter("username"))){
					pw.println("<br>");
					pw.println("User Name is exist");
					pw.println("</br>");
				} else { if(new UserVerify().VerifyItem("mailadd",request.getParameter("mailadd"))){
						 pw.println("<br>");
						 pw.println("User mail is exist");
						 pw.println("</br>");
						 } else { 
							 RegisterItem=new HashMap<String,String[]>(request.getParameterMap());
							 VerifyCode = VerifyCodeCreate.getCode(request.getParameter("username"),request.getParameter("mailadd"));
							 RegisterItem.put("Status",new String[]{"1"});
							 RegisterItem.put("VerifyCode",new String[]{VerifyCode});
							 RegisterItem.put("password", new String[]{EncryptionByMD5.getMD5(request.getParameter("password").getBytes())});
							 String SQLmessage = UserDB.UseInsert("UserTable", RegisterItem);
							 if(SQLmessage.equals("1")){
								new MailService().MailNewUser(request.getParameter("mailadd"), VerifyCode);
								pw.println("<br>");
								pw.println("Please check you e-mail and enter the VerifyCode to below link: ");
								pw.println("</br>");
								pw.println("<br>");
								pw.println("<a href=\"/ServletTest/NewUserVerify.html\">User e-mail Verify</a>");
								pw.println("</br>");
							} else {
								pw.println("<br>");
								pw.println("Error message:");
								pw.println("</br>");
								pw.println("<br>");
								pw.println(SQLmessage);
								pw.println("</br>");
							}					
						 }
				}
			} catch (Exception ea){
				ea.printStackTrace();
			}
		} else {
			pw.println("<br>");
			pw.println("Password must same");
			pw.println("</br>");
		}
	}

}
