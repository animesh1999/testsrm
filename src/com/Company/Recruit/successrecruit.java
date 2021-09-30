package com.Company.Recruit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class successrecruit
 */
@WebServlet("/successrecruit")
public class successrecruit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public successrecruit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		    PrintWriter out=response.getWriter();
		
		recfilterfunc rff = new recfilterfunc();

		
		int k = 0;
		
		String cpemail = request.getParameter("t1");
		
		
		
	



try {
	if(rff.Moverecord(cpemail))
	{
		//out.println("Customer Registered Sucessfully");
	response.sendRedirect("successrecruit.html");
	}
	else 
	{	
		//redirecting our web page to next resources
	
		response.sendRedirect("failedrecruit.html");
	}
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
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
