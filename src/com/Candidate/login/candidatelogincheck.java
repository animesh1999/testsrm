package com.Candidate.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Company.Recruit.savecompdetails;
import com.Connection.setup.RecruitmentConnection;
import com.Register.company.Recruitment;

public class candidatelogincheck {
	
	
	public static int clogincheck(String cd_emailid, String cd_pass) throws SQLException {
		// TODO Auto-generated method stub
		
		String cname = null;
		int csal = 0;
		String jp = null;
	
		Connection con= RecruitmentConnection.getConnect();
	      
			PreparedStatement ps=con.prepareStatement("select * from Candidateunplaced where Email_ID =? and Candidate_Password=?;");//throws sql exception
			ps.setString(1,cd_emailid);
			ps.setString(2, cd_pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()==true)
			{
				
				return 1;
				
			}
			else
			{
				
				
				savecompdetails r  = new savecompdetails();
				PreparedStatement ps2=con.prepareStatement("select * from Candidateplaced where Email_ID =? and Candidate_Password=?;");//throws sql exception
				ps2.setString(1,cd_emailid);
				ps2.setString(2, cd_pass);
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next()==true)
				{
					cname = rs2.getString("Company_Name");
					jp = rs2.getString("Company_Profile");
					csal = Integer.parseInt(rs2.getString("Company_Salary"));
					
					r.setCp_name(cname);
					r.setCp_profile(jp);
					r.setCp_sal(csal);
					
				
				return  2;
				
				}
				else
					return 0;
				}
	}
}
				
			
			

	       
