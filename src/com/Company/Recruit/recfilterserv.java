package com.Company.Recruit;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Candidate.elements.Candidate;

/**
 * Servlet implementation class recfilterserv
 */
@WebServlet("/recfilterserv")
public class recfilterserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recfilterserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    
		String skillreq=request.getParameter("skillreq");
		String yoereq=request.getParameter("yoereq");
		
		
		  out.println("<!DOCTYPE html>");
		  out.println("<html>");
		  out.println("<head>");
		  out.println("<meta charset=\"utf-8\">");  // escape the quote marks
		  out.println("<title>Successfull Registration</title>");
		  out.println("<style>");     // start style
		  // enclose style attributes withing the <style> </style> elements
		           // note trailing brace for h1 style
		  
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
		
		       out.println("background-image: url(img/BI_OFFICE_Gavett-FEATURE.jpg);");
				out.println(" background-repeat: no-repeat;");
				out.println("background-attachment: fixed;");
				out.println("background-size: 100% 100%;");
				 out.println("}");
				 out.println("table {border-spacing: 1;border-collapse: collapse;background: white;border-radius: 10px;overflow: hidden;width: 100%;margin: 0 auto;position: relative;}table * {position: relative;}table td, table th {padding-left: 8px;}"+"table thead tr {height: 60px;background: #36304a;}table tbody tr {height: 50px;}table tbody tr:last-child {border: 0;}table td, table th { text-align: left;}table td.l, table th.l {text-align: right;}table td.c, table th.c {text-align: center;}table td.r, table th.r {text-align: center;}");
		  // add styles for other elements here using similar structure
		  // note that separate lines are used for clarity -
		  // all of the above could be one println
				out.println(" a:link, a:visited {background-color: gray;color: white; padding: 15px 25px;text-align: center; text-decoration: none;display: inline-block;a:hover, a:active {background-color: red;}");


					
				 
		  out.println("</style>");  // terminate style
		  out.println("</head>");
		  out.println("<body>");
		 out.println("<h1>Eligible Candidates</h1>");
		 
		 
		    recfilterfunc rff=new recfilterfunc();
		    List<Candidate> list_candidates = null;
			try {
				list_candidates = rff.displaycand(skillreq,yoereq);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				out.print("<table border='1' width='100%'>");
				out.print("<tr  background-color:'gray'><th style='background-color:#AAAAAA'>Candidate Name</th><th style='background-color:#AAAAAA'>Candidate Skill</th><th style='background-color:#AAAAAA'>Year of Experience</th><th style='background-color:#AAAAAA'>DOB</th><th style='background-color:#AAAAAA'>Email ID</th><th style='background-color:#AAAAAA'>Click to Recruit</th></tr>");
				
				for(Candidate cand: list_candidates)
				{
					
					
					
					
					out.print("<tr><td style='background-color:#DDDDDD'>"+cand.getCd_name()+"</td><td style='background-color:#DDDDDD'>"+cand.getCd_skill()+"</td><td style='background-color:#DDDDDD'>"+cand.getCd_yoe()+"</td><td style='background-color:#DDDDDD'>"+cand.getCd_dob()+"</td><td style='background-color:#DDDDDD'>"+cand.getCd_emailid()+"</td><td style='background-color:#DDDDDD'><a href='successrecruit?t1="+cand.getCd_emailid()+"'>Recruit</td></tr>");  
					
				}
				
				out.print("</table>");
				
				
				out.print("<br><a href=\"index.html\"><button type=\"button\">Log out</button></a>");
				
				
				
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
