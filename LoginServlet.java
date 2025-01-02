package com.login;

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


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","Dr@3993998");
			String n = request.getParameter("username");
			String p = request.getParameter("password");
			PreparedStatement ps = con.prepareStatement("select username from login where username=? and password=?");
			ps.setString(1,n);
			ps.setString(2, p);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("welcom.jsp");
				rd.forward(request, response);
			}
			else {
				out.println("<font color=red size=10>login Failed!! please Try again<br>");
				 out.println("<a href = login.jsp>Try again </a><br><h5>OR</h5><br>");
				 out.println("<a href = register.jsp> register Here</a>");
		           
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
