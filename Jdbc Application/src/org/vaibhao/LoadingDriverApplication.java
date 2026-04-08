package org.vaibhao;

import java.sql.Connection;
import java.sql.DriverManager;

public class LoadingDriverApplication {
	public static void main(String args[]) throws Exception {

		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();

		DriverManager.registerDriver(d);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eclipse", "vaibhao", "vaibhaovk");

		if (conn != null) {
			System.out.println("Database is Connected....");
		} else {
			System.out.println("Database is Not Connected....");
		}
	}

}
