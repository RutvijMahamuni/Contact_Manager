package apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DBConnect{
	/*Since a class cannot directly start from a try catch block, we can use
	 *a static block to contain it
	 */
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/*The connection to database is established using a method here. It helps
	 * to keep the code clean and gives a gateway for us to use the connection
	 * for executing various queries
	 */
	public static Connection getConnection() throws SQLException{
	
	String jdbcurl="jdbc:mysql://localhost:3306/learntricks";
	String user="root";
	String pwd="root";
	return DriverManager.getConnection(jdbcurl, user, pwd);
	}
	
}

public class Operations{
	
	//1. To get all the contacts from the list
	
	public void viewAll() {
		try {
			Connection con=DBConnect.getConnection();
			String query="select * from contacts";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"  ");
				System.out.print(rs.getString(2)+"  ");
				System.out.print(rs.getString(3)+"  ");
				System.out.print(rs.getString(4)+"  ");
				System.out.println();
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println("An error occured! \n");;
		}
	}
	
	public void addContact(String name, String phone, String mail) {
		String nm=name;
		String ph=phone;
		String email=mail;
		String query="insert into contacts (name, phone, email) values(?,?,?)";
		try {
			Connection con=DBConnect.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, nm);
			ps.setString(2, ph);
			ps.setString(3, email);
			
			int updatedrecords=ps.executeUpdate();
			
			if(updatedrecords>0) {System.out.println();
			System.out.println("Contact added successfully");
			System.out.println();}
			else {
				System.out.println("Contact could not be added");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public void updateContact(String nm1, String nm2, String ph, String em) {
		String name1=nm1;
		String name2=nm2;
		String phone=ph;
		String mail=em;
		String queryfind="select * from contacts where name=?";
		String queryupdate="update contacts set name=?,phone=?, email=? where name=?";
		try {
			Connection con=DBConnect.getConnection();
			PreparedStatement ps=con.prepareStatement(queryfind);
			ps.setString(1, name1);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				ps=con.prepareStatement(queryupdate);
				ps.setString(1, name1);
				ps.setString(2, name2);
				ps.setString(3, phone);
				ps.setString(4, mail);
				int updatedrecords=ps.executeUpdate();
				System.out.println("Records updated!");
			}
			else
			{
				System.out.println("No such record found!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();;
		}
		
//		try {
//			Connection con=DBConnect.getConnection();
//			PreparedStatement ps=con.prepareStatement(query);
//			ps.setString(1, name2);
//			ps.setString(2, phone);
//			ps.setString(3, mail);
//			ps.setString(4,name1);
//			
//			int updatedrecords=ps.executeUpdate();
//			if(updatedrecords>0) 
//			{
//				System.out.println();
//			System.out.println(updatedrecords+" contacts updated");
//			System.out.println();}
//			else {
//				System.out.println();
//				System.out.println("No record found!");
//				System.out.println();
//			}
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
	}
	public void deleteContacts(String name) {
		String nm=name;
		String query="delete from contacts where name=?";
		try {
			Connection con=DBConnect.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, nm);
			int affectedrecords=ps.executeUpdate();
			if(affectedrecords>0) {
				System.out.println();
				System.out.println(affectedrecords+ " contacts deleted");
				System.out.println();
			}
			else
			{
				System.out.println("No record found!");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

