package assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Jdbcdemo {
	
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			//loading the mysql driver
			//drivername is case sensitive
			

			/*
			 * Since JDBC 4.0, explicitly registering the driver is optional. 
			 * We just need to put vender's Jar in the classpath, 
			 * and then JDBC driver manager can detect and load the driver automatically.
			 */

			//classname.methodname=>static method
			//Class.forName("com.mysql.jdbc.Driver");  //type 4 mysql driver

			//3306-DEFAULT mysql port number
			//wipro2025:: mysql database name
			//username:root
			//my password is empty
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo","root","root");
			
			//con=DriverManager.getConnection("jdbc:mysql:@127.0.0.1:3306/wipro","root","");//valid
			st=con.createStatement();//build sql statements
			rs=st.executeQuery("select * from employee");//ResultSet means rows and columns
			while(rs.next())//iterate the records one by one!
			{
				//EITHER COLUMN NAME OR COLUMN POSITION INDEX 1,2,3....
				int a=rs.getInt("id");//column name
				String b=rs.getString("name");//2nd column=>name
				float c=rs.getFloat("salary");//float c=rs.getFloat(3);
//				String d=rs.getString("dept");

				System.out.println(a+ " "+b + " "+c);
				
			}
		}
		catch(Exception e)//SQLException is a checked exception
		{
			e.printStackTrace();
		}

		finally
		{
			try
			{
				if(rs!=null) 
					rs.close();
				if(st!=null)
					st.close();
				if(con!=null)
					con.close();
			}
			catch(Exception e)
			{
				System.out.println("Finally Block::"+e);
			}
		
		}




	}

}