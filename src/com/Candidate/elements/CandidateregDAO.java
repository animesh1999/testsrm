package com.Candidate.elements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.Connection.setup.RecruitmentConnection;

public class CandidateregDAO {

	
	
	public static void Candidateunplacedtablecreate()
	{
		Connection con= RecruitmentConnection.getConnect();
	       try {
			PreparedStatement ps=con.prepareStatement("CREATE  TABLE IF NOT EXISTS TestMain.Candidateunplaced(Candidate_Name VARCHAR(20),Candidate_Skill VARCHAR(20) NOT NULL,Year_of_Experience VARCHAR(8) NOT NULL,Email_ID VARCHAR(20),DOB DATE,Candidate_Password VARCHAR(20));");//throws sql exception
			ps.execute(); 

	       }
	       catch(Exception e)
	       {
	    	   System.out.println(e);
	       }
	}
	
	
	
	
	
	
	public int InsertCanunplaced(Candidate c) throws ParseException, SQLException {
		// TODO Auto-generated method stub
		
			int status  = 0;
			Candidateunplacedtablecreate();
			String cd_name = c.getCd_name();
			String cd_skill = c.getCd_skill();
			int cd_yoe  = c.getCd_yoe();
			String cd_emailid = c.getCd_emailid();
			String cd_dob = c.getCd_dob();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d1 = sdf.parse(cd_dob);
			java.sql.Date l2date = new java.sql.Date(d1.getTime());
			String cd_pass = c.getCd_pass();
			
			status= InsertintoCandidateunplacedtable(cd_name,cd_skill,cd_yoe,cd_emailid,l2date,cd_pass);
			
			return status;
			
	}
	
	
	public static int InsertintoCandidateunplacedtable(String cd_name,String cd_skill,int cd_yoe,String cd_emailid,Date l2date,String cd_pass) throws ParseException, SQLException
	{
		int statuso = 0;
		Connection con= RecruitmentConnection.getConnect();
		PreparedStatement ps1 = con.prepareStatement("insert into Candidateunplaced values(?,?,?,?,?,?)");
		ps1.setString(1,cd_name);
		ps1.setString(2,cd_skill);
		ps1.setInt(3,cd_yoe);
		ps1.setString(4,cd_emailid);
		ps1.setDate(5,(java.sql.Date)l2date);
		ps1.setString(6,cd_pass);
		statuso = ps1.executeUpdate();
		return statuso;
		
		
	}

}
