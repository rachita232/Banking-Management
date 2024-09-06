package com.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num= Integer.parseInt(request.getParameter("num"));
		
		PrintWriter out=response.getWriter();
		
		response.setContentType("text/html");
		String driver="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,"system","1234");
			 String query = "select * from account";
		        PreparedStatement ps = con.prepareStatement(query);
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		            out.println("Account: " + rs.getInt(1) + ", Name: " + rs.getString(2) + ", Balance: " + rs.getInt(3));
		    }
		        }
		
		catch(Exception e)
		{
			
			out.println("<h2>Exception:"+ e.getMessage()+"<h2>");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}