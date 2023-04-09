import java.sql.*;
import java.io.*;
import java.util.*;
public class Database
{
	public void database()
	{
		Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system" );
			PreparedStatement st=con.prepareStatement("insert into userdetails values(?,?,?,?,?,?,?,?,?,?,?)");
			Scanner sc=new Scanner(System.in);
			
			System.out.print("Your Name : ");
			String name=sc.nextLine();
			System.out.print("Gender : ");
			String gender = sc.nextLine();
			System.out.print("Age : ");
			String age = sc.nextLine();
			System.out.print("Father Name : ");
			String fname=sc.nextLine();
			System.out.print("Mother Name : ");
			String mname=sc.nextLine();
			System.out.print("Mobile Number : ");
			String mobile=sc.nextLine();
			System.out.print("Adhar Number : ");
			String adhar = sc.nextLine();
			System.out.print("Email : ");
			String email = sc.nextLine();
			System.out.print("Address with PIN code : ");
			String address=sc.nextLine();
			System.out.println("---create username and password---");
			System.out.print("USERNAME : ");
			String uname=sc.nextLine();
			
			Console  c = System.console();
			System.out.print("PASSWORD : ");		
			char p[] = c.readPassword();
			String password ="";
			for(char ch : p)
			{
				password+=(ch);
			}
		
			st.setString(1,name);
			st.setString(2,gender);
			st.setString(3,age);
			st.setString(4,fname); 
			st.setString(5,mname); 
			st.setString(6,mobile); 
			st.setString(7,adhar); 
			st.setString(8,email); 
			st.setString(9,address); 
			st.setString(10,uname); 
			st.setString(11,password); 
			
			
			File f1 = new File ("A5.txt");
			FileWriter fw = new FileWriter(f1,true);
			fw.append(' ');
			fw.write(uname);
			fw.close();
			File f2 = new File ("A5.txt");
			FileWriter fww = new FileWriter(f2,true);
			fww.write(password);
			fww.close();
			
			
			int flag=st.executeUpdate();
			System.out.println(flag+"record inserted");
			System.out.println(".....WELCOME Mr "+name+" You have Successfully created account");
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