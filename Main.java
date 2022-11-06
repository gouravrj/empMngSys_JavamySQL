package Employee_Managment_system;
import java.util.*;
import java.sql.*;
public class Main {
	
	static void add_emp(Connection conn)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter ID     :");
		int id = sc.nextInt();
		System.out.print("Enter Name   :");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Enter Phone  :");
		String phone = sc.nextLine();
		System.out.print("Enter e-Mail :");
		String email = sc.nextLine();
		System.out.print("Enter Salary :");
		String sal = sc.nextLine();
		
		try {
			String query = "INSERT INTO EMPLOYEE VALUES ("+id+",'"+name+"','"+phone+"','"+email+"',"+sal+")";
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			System.out.println("Values are Inserted Successfuly.");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		sc.close();
		
	}
	
	static void search_id(Connection conn)
	{
		boolean isEmpty = true;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the ID number to Seacrh : ");
		int id = sc.nextInt();
		String query = "SELECT * FROM EMPLOYEE WHERE ID="+id+";";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())	
			{
				System.out.println("The Employee Name is "+rs.getString(2)+" ("+rs.getString(1)+")");
				System.out.print("Phone  : "+rs.getString(3));
				System.out.print("  e-Mail : "+rs.getString(4));
				System.out.print("  Salary : "+rs.getString(5));
				isEmpty = false;
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(isEmpty)
			System.out.print("NO Such record associated with id: "+id+" is Found.");
		System.out.println();
		sc.close();
		
	}
	static void delete_id(Connection conn)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the ID that you want to Delete: ");
		int id = sc.nextInt();
		String query = "DELETE FROM EMPLOYEE WHERE ID="+id;
		int rows = 0;
		try {
			Statement st = conn.createStatement();
			rows = st.executeUpdate(query);
			if(rows==0)
				System.out.print("No Such ID is Found .... ");
			else	
				System.out.print("Deleted Successfully ....");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		sc.close();
		
	}
	static void delete_name(Connection conn)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Name that you want to Delete: ");
		String name = sc.nextLine();
		String query = "DELETE FROM EMPLOYEE WHERE NAME='"+name+"'";
		int rows = 0;
		try {
			Statement st = conn.createStatement();
			rows = st.executeUpdate(query);
			if(rows==0)
				System.out.print("No Such Name is Found .... ");
			else	
				System.out.print("Deleted Successfully ....");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		sc.close();
		
	}
	static void update(Connection conn)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the ID to Update: ");
		int id = sc.nextInt();
		System.out.println("1.Update Name\n2.Update e-Mail\n3.Update Phone\n4.Update Salary");
		
		System.out.print("Enter your Choice: ");
		int ch = sc.nextInt();
		String query="";
		switch(ch)
		{
			case 1:
				System.out.print("Enter Name to Update: ");
				sc.nextLine();
				String name = sc.nextLine();
				query = "UPDATE EMPLOYEE SET name='"+name+"' where ID="+id+";";
				break;
			case 2:
				System.out.print("Enter e-Mail to Update: ");
				sc.nextLine();
				String email = sc.nextLine();
				query = "UPDATE EMPLOYEE SET email='"+email+"' where ID="+id+";";
				break;
			case 3:
				System.out.print("Enter Phone Number to Update: ");
				sc.nextLine();
				String phone = sc.nextLine();
				query = "UPDATE EMPLOYEE SET phone='"+phone+"' where ID="+id+";";
				break;
			case 4:
				System.out.print("Enter Salary to Update: ");
				sc.nextLine();
				String sal = sc.nextLine();
				query = "UPDATE EMPLOYEE SET salary="+sal+" where ID="+id+";";
				break;
			default:
				System.out.print("Wrong Choice, Back to Main Menu");
		}
		if(query.length()!=0)
		{
			try {
				Statement st = conn.createStatement();
				int rows = st.executeUpdate(query);
				if(rows==0)
					System.out.print("No Such record Found with ID "+id+" to Update ...");
				else
					System.out.print("Updated Successfully .... ");
					//Should Display the Updated Record .......
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println();
		sc.close();
		
	}
	static void display_all(Connection conn)
	{
		boolean isEmpty = true;
		String query = "SELECT * FROM EMPLOYEE;";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			System.out.println("ID \t Name \t \t Phone \t \t e-Mail \t \t Salary");
			System.out.println("== \t ==== \t \t ===== \t \t ====== \t \t ======");
			while(rs.next())	
			{
				
				String d1 = rs.getString(1);
				String d2 = rs.getString(2);
				String d3 = rs.getString(3);
				String d4 = rs.getString(4);
				String d5 = rs.getString(5);
				System.out.println(d1+" \t "+d2+" \t "+d3+" \t "+d4+" \t "+d5);
				isEmpty = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(isEmpty)
			System.out.print("Empty ... No Records Found");
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/emp_managment_system";
		String username = "root";
		String password = "Gourav@2001";
		try {
				Connection con = DriverManager.getConnection(url,username,password);
				
				Scanner sc = new Scanner(System.in);
			
				int ch;
				do{
					System.out.println("1.ADD Employee");
					System.out.println("2.Search an Employee ID");
					System.out.println("3.Edit an Employee Data");
					System.out.println("4.Delete an Employee by ID");
					System.out.println("5.Delete an Employee by Name");
					System.out.println("6.Display all Employees");
					System.out.println("7.Exit .....");
					System.out.print("Enter your Choice: ");
					ch = sc.nextInt();
					switch(ch)
					{
						case 1:
							add_emp(con);
							break;
						case 2:
							search_id(con);
							break;
						case 3:
							update(con);
							break;
						case 4:
							delete_id(con);
							break;
						case 5:
							delete_name(con);
							break;
						case 6:
							display_all(con);
							break;
						case 7:
							System.out.print("Exited ... ");
							break;
						default:
							System.out.print("Wrong Choice");
					}
				}while(ch!=7);
				con.close();
				sc.close();
				
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
