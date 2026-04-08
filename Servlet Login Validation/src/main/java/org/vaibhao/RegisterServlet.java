package org.vaibhao;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Database configuration
	private static final String DB_URL = "jdbc:mysql://localhost:3306/eclipse";
	private static final String DB_USER = "vaibhao";
	private static final String DB_PASSWORD = "vaibhaovk";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Get form parameters
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		// Validate inputs
		if (isEmpty(fullname) || isEmpty(username) || isEmpty(email) || isEmpty(password)) {
			sendError(request, response, "All fields are required!");
			return;
		}

		if (!password.equals(confirmPassword)) {
			sendError(request, response, "Passwords do not match!");
			return;
		}

		if (password.length() < 8) {
			sendError(request, response, "Password must be at least 8 characters long!");
			return;
		}

		try {
			// Register the user (with plain password - INSECURE)
			if (registerUser(fullname, username, email, password)) {
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
				out.println("<div class='success-message'>Registration successful! Please login.</div>");
			} else {
				sendError(request, response, "Registration failed. Username or email may already exist.");
			}
		} catch (SQLException e) {
			sendError(request, response, "Database error: " + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			sendError(request, response, "Server configuration error.");
			e.printStackTrace();
		}
	}

	private boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}

	private boolean registerUser(String fullname, String username, String email, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String sql = "INSERT INTO sregister (fullname, username, email, password) VALUES (?, ?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, fullname);
			pstmt.setString(2, username);
			pstmt.setString(3, email);
			pstmt.setString(4, password); // Storing plain password - UNSAFE

			return pstmt.executeUpdate() > 0;
		}
	}

	private void sendError(HttpServletRequest request, HttpServletResponse response, String message)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("signup.html");
		rd.include(request, response);
		response.getWriter().println("<div class='error-message'>" + message + "</div>");
	}
}