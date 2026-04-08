package vaibhao;

import java.sql.*;
import java.util.*;

public class InsertUserDefineApplication {

	public static void main(String[] args) throws Exception {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eclipse", "vaibhao", "vaibhaovk");
		if (conn != null) {
			Scanner v = new Scanner(System.in);
			System.out.println("Enter the name");
			String name = v.nextLine();
			System.out.println("Enter the email");
			String email = v.nextLine();
			System.out.println("Enter the contact");
			String contact = v.nextLine();
			Statement stmt = conn.createStatement();
			int value = stmt
					.executeUpdate("insert into register values('" + name + "','" + email + "','" + contact + "')");
			if (value > 0) {
				System.out.println("Record is save Successfully");
			} else {
				System.out.println("Some Problem Is There");
			}
		} else {
			System.out.println("Database Is Not Connected");
		}
	}

}