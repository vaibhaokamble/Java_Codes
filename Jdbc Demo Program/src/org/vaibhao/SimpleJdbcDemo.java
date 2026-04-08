package org.vaibhao;

import java.sql.*;

public class SimpleJdbcDemo {
	public static void main(String[] args) {
		// 1. Connect to database
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "vaibhao",
				"vaibhaovk")) {

			System.out.println("Connected to database!");

			// 2. Create a statement
			Statement stmt = conn.createStatement();

			// 3. Execute a query
			ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

			// 4. Process results
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Salary: $"
						+ rs.getDouble("salary"));
			}

		} catch (SQLException e) {
			System.out.println("Database error: " + e.getMessage());
		}
	}
}