package com.Register.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.Connection.setup.RecruitmentConnection;

public class RecruitmentDAO {
	
	
	
	
	public static void Recruitmenttablecreate()
	{
		Connection con= RecruitmentConnection.getConnect();
	       try {
			PreparedStatement ps=con.prepareStatement("CREATE  TABLE IF NOT EXISTS RegisterMain(Company_ID INT PRIMARY KEY ,Company_Name VARCHAR(20) NOT NULL,Company_Salary VARCHAR(8) NOT NULL,Company_Profile VARCHAR(30),Company_Password VARCHAR(20));");//throws sql exception
			ps.execute(); //insert/update/delete int--1 /0

	       }
	       catch(Exception e)
	       {
	    	   System.out.println(e);
	       }
	}
	
	public int InsertRegMain(Recruitment r) throws ParseException, SQLException
	{

			int status  = 0;
			Recruitmenttablecreate();
			int cp_id = r.getCp_Id();
			String cp_name = r.getCp_name();
			int cp_sal  = r.getCp_sal();
			String cp_profile = r.getCp_profile();
			String cp_pass = r.getCp_pass();
			
			status= InsertintoRectable(cp_id,cp_name,cp_sal,cp_profile,cp_pass);
			
			return status;
		
	}
	
	
	public static int InsertintoRectable(int cp_id,String cp_name,int cp_sal,String cp_profile,String cp_pass) throws ParseException, SQLException
	{
		int statuso = 0;
		Connection con= RecruitmentConnection.getConnect();
		PreparedStatement ps1 = con.prepareStatement("insert into RegisterMain values(?,?,?,?,?)");
		ps1.setInt(1,cp_id);
		ps1.setString(2,cp_name);
		ps1.setInt(3,cp_sal);
		ps1.setString(4,cp_profile);
		ps1.setString(5,cp_pass);
		statuso = ps1.executeUpdate();
		return statuso;
		
		
	}
	
	

}
