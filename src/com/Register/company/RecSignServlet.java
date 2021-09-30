package com.Register.company;

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
 * Servlet implementation class RecSignServlet
 */
@WebServlet("/RecSignServlet")
public class RecSignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecSignServlet() {
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
		
		
		//Taking input from UI (HTML file)
		int cp_id=Integer.parseInt(request.getParameter("rcp_id"));//getParameter method return type is String
		String cp_name=request.getParameter("rcp_name");
		int cp_sal=Integer.parseInt(request.getParameter("rcp_sal"));
		String cp_profile=request.getParameter("rcp_profile");
		String  cp_pass=request.getParameter("rcp_pass");
		
		
		//Creating object of Model class or bean class
		Recruitment r=new Recruitment();
		
		//setting data or value to the object of customer
		r.setCp_id(cp_id);
		r.setCp_name(cp_name);
		r.setCp_sal(cp_sal);
		r.setCp_profile(cp_profile);
		r.setCp_pass(cp_pass);
		
		
		RecruitmentDAO rdao = new RecruitmentDAO();
	
		
		
		
		int k = 0;
				
					try {
						k = rdao.InsertRegMain(r);
					} catch (ParseException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			
		
	
		
		if(k> 0)
		{
			
			  out.println("<!DOCTYPE html>");
			  out.println("<html>");
			  out.println("<head>");
			  out.println("<meta charset=\"utf-8\">");  // escape the quote marks
			  out.println("<title>Successfull Registration</title>");
			  out.println("<style>");     // start style
			  // enclose style attributes withing the <style> </style> elements
			  out.println("h1 {");        // note leading brace
			  out.println("color:blue;");
			  out.println("background:transparent;");
			  out.println("position: absolute;");
				 out.println("top: calc(80% - 75px);");
				 out.println("left: calc(40% - 50px);");
				 out.println("height: 150px;");
				 out.println("width: 350px;");
				 out.println("padding: 10px;");
				 out.println("z-index: 2;");
			  out.println("}");          // note trailing brace for h1 style
			  
			  out.println("button{");
		       out.println("width: 260px;");
				out.println(" height: 35px;");
				out.println("background: #fff;");
				out.println("border: 1px solid #fff;");
				out.println("cursor: pointer;");
				out.println("border-radius: 2px;");
				out.println("font-family: 'Exo', sans-serif;");
				out.println("font-size: 16px;");
				out.println("font-weight: 400;");
				out.println("padding: 6px;");
				out.println("margin-top: 10px;");
				 out.println("}");
			 
			  out.println("body{");
			
			       out.println("background-image: url(img/regsuccimg.png);");
					out.println(" background-repeat: no-repeat;");
					out.println("background-attachment: fixed;");
					out.println("background-size: 100% 100%;");
					 out.println("}");
			  // add styles for other elements here using similar structure
			  // note that separate lines are used for clarity -
			  // all of the above could be one println
			  out.println("</style>");  // terminate style
			  out.println("</head>");
			  out.println("<body>");
			  out.println("<h1><br><a href=recruitmenthomepage.html><button type=\"button\">Go to Login page</button></a></h1>");
			  out.println("</body>");
			  out.println("</html>");
			
			
		}
		else
		{
			
			//redirecting our web page to next resources
			response.sendRedirect("Recerror.html");
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
