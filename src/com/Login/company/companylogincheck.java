package com.Login.company;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Company.Recruit.savecompdetails;
import com.Connection.setup.RecruitmentConnection;
import com.Register.company.Recruitment;


public class companylogincheck {
	

		public static int logincheck(int cp_id, String cp_pass) {
			// TODO Auto-generated method stub
			

			int cid = 0;
			String cname = null;
			int csal = 0;
			String cprofile = null;
			
			savecompdetails r = new savecompdetails();
			Connection con= RecruitmentConnection.getConnect();
		       try {
				PreparedStatement ps=con.prepareStatement("select * from RegisterMain where Company_ID =? and Company_Password=?");//throws sql exception
				ps.setInt(1,cp_id);
				ps.setString(2, cp_pass);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					cid = rs.getInt("Company_ID");
					cname = rs.getString("Company_Name");
					csal = rs.getInt("Company_Salary");
					cprofile  = rs.getString("Company_Profile");
					
					
					r.setCp_profile(cprofile);
					r.setCp_id(cid);
					r.setCp_name(cname);
					r.setCp_sal(csal);
					
					return 1;
					
				}
				else
				{
					return 0;
				}
				
		       }
		       catch(Exception e)
		       {
		    	   System.out.println(e);
		       }
			return 0;
		}
		
	
		
		




		
	}

