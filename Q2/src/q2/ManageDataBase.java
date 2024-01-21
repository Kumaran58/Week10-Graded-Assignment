package q2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ManageDataBase {

	private Connection connection ;
	private Statement statement;
	private ResultSet rs;
	Scanner sc = new Scanner(System.in);


	public ManageDataBase(String url,String username,String password)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,password);
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("Connected Established ...");
	}

	
	public void add()
	{
		System.out.print("Enter the required  no of records to be inserted in DataBase : ");
		int con = sc.nextInt();
		for(int i=0 ; i<con ; i++)
		{
			System.out.println("Enter id,name,email,mobile number of one employee separated by space : ");
			String Q = "insert into employee values ( "+sc.nextInt()+",'"+sc.next()+"', '"+sc.next()+"', '"+sc.next()+"')";
			try {
				statement.execute(Q);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(".............");
		
	}


	public void alter()
	{
		System.out.println("Enter the required column name and type to alter which is seperated by space : ");
		String q = "alter table employee modify column "+sc.next()+" "+ sc.next();
		try {
			statement.execute(q);
			System.out.println("Column altered successfully...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(".............");
		
	}

	public void update()
	{
		System.out.print("Enter id where to be updated in Database : ");
		int id = sc.nextInt();
		System.out.print("Enter name to update : ");
		String name = sc.next();
		System.out.print("Enter mobile number to update : ");
		String mobile = sc.next();
		String q = "update employee set name = '"+name+"' , phone_number = '"+mobile+"' where id = "+id+" ";
		try {
			statement.execute(q);
			System.out.println("Column altered successfully...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(".............");
		
	}

	public void deleteAll()
	{
		String q = "truncate table employee";
		try {
			statement.execute(q);
			System.out.println("sucessfully deleted all empolyees ! ");
			
			//			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(".............");
		
	}

	public void deleteOne()
	{
		System.out.print("Enter the number of id you have to delete : ");
		int con = sc.nextInt();
		for(int i = 0 ; i < con ; i++)
		{
			System.out.println("Enter the id to be deleted : ");
			String q = "delete from employee where id = "+sc.nextInt();
			try {
				statement.execute(q);
				System.out.println("deleted the employee details ");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println(".............");
	}

	public void display()
	{
		String query = "Select * from employee";
		try {
			rs = statement.executeQuery(query);
			if(rs.isBeforeFirst())
			{
				System.out.println("The employee records are...");
				while(rs.next())
				{
					System.out.print(rs.getInt(1) + " ");
					System.out.print(String.format("%-20s", rs.getString(2)));
					System.out.print(String.format("%-25s", rs.getString(3)));
					System.out.print(rs.getString(4));
					System.out.println();
				}
			}
			else
			{
				System.out.println("No records found in the employee table...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(".............");
		
	}
	
	public void disconnect()
	{
		try {
			connection.close();
			System.out.println("Connection Disconnected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(".............");
		
	}

}