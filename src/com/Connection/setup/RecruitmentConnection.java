package com.Connection.setup;
import java.sql.Connection;
import java.sql.DriverManager;

public class RecruitmentConnection {


	static Connection connection=null;
	public static Connection getConnect() 
	{
		try
		{
			
			//load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	
		//estabilish the connection  url,root,root
		  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/TestMain", "root", "root");
		
		  System.out.println("Connected");
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		  return connection;  
	}

}

