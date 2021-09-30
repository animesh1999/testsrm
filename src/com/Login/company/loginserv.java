package com.Login.company;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginserv
 */
@WebServlet("/loginserv")
public class loginserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   



/**
 * Servlet implementation class loginserv
 */

    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
      response.setContentType("text/html");//Which mime type
		
		PrintWriter out=response.getWriter();// if I want to print on browser then this object can be used
		
		
		int cp_id=Integer.parseInt(request.getParameter("ncp_id"));
		String cp_pass=request.getParameter("ncp_pass");
		
		int m  = companylogincheck.logincheck(cp_id,cp_pass);
				
		if(m>0)
		{
			
			response.sendRedirect("Recwelcome.html");
		}
		else
		{
			out.println("Invalid Credentials");
			out.print("<br><a href=recruitmenthomepage.html><button type=\"button\">Go to Login page</button></a>");
			
		}
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
