package vaibhao;

import java.sql.*;

public class InsertApplication {

	public static void main(String[] args) throws Exception {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eclipse", "vaibhao", "vaibhaovk");
		if (conn != null) {
			Statement stmt = conn.createStatement();
			int value = stmt.executeUpdate("insert into register values('vaibhau','vaibhau@gmail.com','143143')");
			if (value > 0) {
				System.out.println("Record Save Successfully");
			} else {
				System.out.println("Some problem is There");
			}

		}
	}

}