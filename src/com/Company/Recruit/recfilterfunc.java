package com.Company.Recruit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.Candidate.elements.Candidate;
import com.Connection.setup.RecruitmentConnection;
import com.Login.company.companylogincheck;
import com.Register.company.Recruitment;

public class recfilterfunc {
	
	public List<Candidate> displaycand(String skillreq,	String yoereq) throws ParseException
	{
		Connection con= RecruitmentConnection.getConnect();
		List<Candidate> pcl = new ArrayList<>();
		
		try{
		PreparedStatement ps = con.prepareStatement("select * from TestMain.candidateunplaced where Candidate_Skill=? and Year_of_Experience>=? ;");
		ps.setString(1,skillreq);
		ps.setInt(2,Integer.parseInt(yoereq));
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			
			Candidate cand = new Candidate();
			cand.setCd_emailid(rs.getString("Email_ID"));
			cand.setCd_name(rs.getString("Candidate_Name"));
			cand.setCd_skill(rs.getString("Candidate_Skill"));
		    cand.setCd_dob(rs.getString("DOB"));
			cand.setCd_yoe(rs.getInt("Year_of_Experience"));
			
			pcl.add(cand);
			
		}
		
		
		}
		
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		
		return pcl;
	}
	
	
	
	
	
	public static void createplacedcantable()
	{
		Connection con= RecruitmentConnection.getConnect();
	       try {
			PreparedStatement ps=con.prepareStatement("CREATE  TABLE IF NOT EXISTS TestMain.Candidateplaced(Candidate_Name VARCHAR(20),Candidate_Skill VARCHAR(20) NOT NULL,Year_of_Experience VARCHAR(8) NOT NULL,Email_ID VARCHAR(20),DOB DATE,Candidate_Password VARCHAR(20),Company_ID INT ,Company_Name VARCHAR(20),Company_Salary VARCHAR(8) NOT NULL,Company_Profile VARCHAR(30));");//throws sql exception
			ps.execute(); 
			//insert/update/delete int--1 /0
	       }
	       catch(Exception e)
	       {
	    	   System.out.println(e);
	       }
	}

	
	
	
	
	public boolean Moverecord(String email) throws ParseException
	{
		Connection con= RecruitmentConnection.getConnect();
		
		createplacedcantable();
		
		String canskill = null;
		String canname = null;
		int yoe = 0;
		String dob = null;
		String canpass  = null;
		String email1 = null;
		
	
		
		try{
			PreparedStatement ps4 = con.prepareStatement("select * from TestMain.candidateunplaced WHERE Email_ID = ?;");
			ps4.setString(1,email);
			ResultSet rs = ps4.executeQuery();
			
			
			
			while(rs.next())
			{
				{
					canname = rs.getString("Candidate_Name");
					canskill = rs.getString("Candidate_Skill");
					yoe = rs.getInt("Year_of_Experience");
					email1  = rs.getString("Email_ID");
					dob  = rs.getString("DOB");
					canpass = rs.getString("Candidate_Password");
					
					PreparedStatement ps5 = con.prepareStatement("DELETE FROM TestMain.candidateunplaced  WHERE Email_ID=?;");
					ps5.setString(1,email1);
					ps5.execute();
					break;
				}				
			}
			}
			
			catch(Exception e)
			{
				System.out.println(e);
				
			}
		
		
		
	 
	int pcid = savecompdetails.getCp_Id();
	String pcname = savecompdetails.getCp_name();
	int pcsal = savecompdetails.getCp_sal();
	String pcprofile = savecompdetails.getCp_profile();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d2 = sdf.parse(dob);
		java.sql.Date l4date = new java.sql.Date(d2.getTime());
		
		
		if(Insertintodelcanplacedtable(canname,canskill,yoe,email1,l4date,canpass,pcid,pcname,pcsal,pcprofile))
		{
			return true;
		}
		else
			{
		return true;
			}

		
		
		
	}
	
	
	
	
	public static boolean Insertintodelcanplacedtable(String canname,String canskill,int yoe,String email1,Date dob,String canpass,int cid, String cname, int csal, String cprofile) throws ParseException
	{
		Connection con= RecruitmentConnection.getConnect();
		try{
		PreparedStatement ps6 = con.prepareStatement("insert into TestMain.Candidateplaced values(?,?,?,?,?,?,?,?,?,?)");
		ps6.setString(1,canname);
		ps6.setString(2,canskill);
		ps6.setInt(3,yoe);
		ps6.setString(4,email1);
		ps6.setDate(5,(java.sql.Date) dob);
		ps6.setString(6,canpass);
		ps6.setInt(7,cid);
		ps6.setString(8,cname);
		ps6.setInt(9,csal);
		ps6.setString(10,cprofile);
		if(ps6.execute())
		{
			return true;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		return false;
	}
	
	
	
	
	
	

}
