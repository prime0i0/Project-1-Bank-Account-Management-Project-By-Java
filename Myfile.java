import java.sql.*;
class Myfile
{
	public static void main(String ...s)
	{
		Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system" );
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from userdetails");
			int i=1;
			while(rs.next())
			{
				System.out.println("User No ."+i);
				i++;
				System.out.println("Name = "+rs.getString(1)+" , Gender = "+rs.getString(2)+" , Age = "+rs.getString(3)+" , Father Name = "+rs.getString(4)+" , Mother Name = "+rs.getString(5)+" , Mobile Number = "+rs.getString(6)+" , Adhar Number = "+rs.getString(7)+" , Email = "+rs.getString(8)+" , Address = "+rs.getString(9)+" , Username = "+rs.getString(10)+" , Password = "+rs.getString(11));
			}
				con.close();
		}
		catch(Exception e)
			{
				System.out.println(e);
			}
		finally
			{
	
			}
	}
}