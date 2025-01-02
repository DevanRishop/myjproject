package com.login;

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
import java.sql.SQLException;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String n = request.getParameter("username");
			String p = request.getParameter("password");
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			PrintWriter out = response.getWriter();
			 Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","Dr@3993998");
		   
			ps = con.prepareStatement("insert into login(username,password) values(?,?)");
			ps.setString(1, n);
			ps.setString(2, p);
			
			
			int rs = ps.executeUpdate();
			
			if(rs>0 ) {
				out.println("<font color=red size=10>Registered Successfully<br>");
				out.println("<a href = login.jsp> Login Here</a>");
				
			}else {
				out.println("<font color=red size=10>registraton failed!! pls Try again<br>");
				out.println("<a href = register.jsp> Login Here</a>");
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			 response.getWriter().println("Error: " + e.getMessage());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
}