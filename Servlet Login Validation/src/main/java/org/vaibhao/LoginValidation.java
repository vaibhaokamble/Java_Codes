package org.vaibhao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/validate")
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Database configuration
	private static final String DB_URL = "jdbc:mysql://localhost:3306/eclipse";
	private static final String DB_USER = "vaibhao";
	private static final String DB_PASSWORD = "vaibhaovk";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("name");
		String password = request.getParameter("pass");

		if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
			sendErrorResponse(request, response, "Username and password cannot be empty!");
			return;
		}

		try {
			// Validate credentials (plain text comparison - NOT secure for production)
			if (validateUser(username, password)) {
				request.getSession().setAttribute("username", username);
				response.sendRedirect("welcome.html");
			} else {
				sendErrorResponse(request, response, "Invalid username or password!");
			}
		} catch (SQLException e) {
			out.println("<h3>Database Error:</h3>");
			out.println("<pre>" + e.getMessage() + "</pre>");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			out.println("<h3>Driver Error:</h3>");
			out.println("<pre>" + e.getMessage() + "</pre>");
		}
	}

	private boolean validateUser(String username, String password) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement stmt = conn.prepareStatement("SELECT password FROM sregister WHERE username = ?")) {

			stmt.setString(1, username);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					String dbPassword = rs.getString("password");
					return password.equals(dbPassword); // Plain text comparison
				}
				return false;
			}
		}
	}

	private void sendErrorResponse(HttpServletRequest request, HttpServletResponse response, String errorMessage)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
		dispatcher.include(request, response);
		response.getWriter().println("<div class='error-message'>" + errorMessage + "</div>");
	}
}