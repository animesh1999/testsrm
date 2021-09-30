package com.Candidate.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Company.Recruit.savecompdetails;
import com.Login.company.companylogincheck;
import com.Register.company.Recruitment;

/**
 * Servlet implementation class canchecklogin
 */
@WebServlet("/canchecklogin")
public class canchecklogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public canchecklogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
response.setContentType("text/html");//Which mime type
		
		PrintWriter out=response.getWriter();// if I want to print on browser then this object can be used
		
		
		String cd_emailid=request.getParameter("ncd_emailid");
		String cd_pass=request.getParameter("ncd_pass");
		
		
		
			
			int m=0;
			try {
				m = candidatelogincheck.clogincheck(cd_emailid, cd_pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(m==1)
			{
				response.sendRedirect("Canwelcome.html");
			}
		
			else if(m==2)
			{
				String cname = savecompdetails.getCp_name();
				String cprofile = savecompdetails.getCp_profile();
				int csal = savecompdetails.getCp_sal();
				
				
				  out.println("<!DOCTYPE html>");
				  out.println("<html>");
				  out.println("<head>");
				  out.println("<meta charset=\"utf-8\">");  // escape the quote marks
				  out.println("<title>Congratulations</title>");
				  out.println("<style>");     // start style
				  // enclose style attributes withing the <style> </style> elements
				  out.println("h1{"); // note leading brace
				  out.println("font-family:Bookman;");
				  out.println("color:gray;");
				  out.println("background:transparent;");
				  out.println("position: absolute;");
					 out.println("top: calc(50% - 75px);");
					 out.println("left: calc(40% - 50px);");
					 out.println("height: 150px;");
					 out.println("width: 600px;");
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
				
				       out.println("background-image: url(img/congratsimg.png);");
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
				  out.println("<h1>You're hired by <br> "+cname+" <br> for job profile <br> "+cprofile+" <br> for a offer salary  of <br>  "+csal+" per month");
				  out.println("<br><a href=index.html><button type=\"button\">Log out</button></a></h1>");
				  out.println("</body>");
				  out.println("</html>");
				
			     }
			else
			{
				out.println("Invalid Credentials");
				out.print("<br><a href=candidatehomepage.html><button type=\"button\">Go to Login page</button></a>");
				
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
