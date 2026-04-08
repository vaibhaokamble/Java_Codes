package vaibhao.housepred.config;

import java.io.File;
import java.io.FileInputStream;
import java.security.PublicKey;
import java.sql.*;
import java.util.Properties;

public class DBConfig {
	protected Connection connection;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	protected CallableStatement cstmt;

	public DBConfig() {

		try {
			Class.forName(PathHelper.p.getProperty("db.driverClass"));
			connection = DriverManager.getConnection(PathHelper.p.getProperty("db.url"),
					PathHelper.p.getProperty("db.username"), PathHelper.p.getProperty("db.password"));
			System.out.println("Database connected");
		} catch (Exception e) {
			System.out.println("Error is " + e);
		}
	}

	public static void main(String args[]) {
		new DBConfig();
	}
}
