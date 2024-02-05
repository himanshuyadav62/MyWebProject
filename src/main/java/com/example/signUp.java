package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public signUp() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    PrintWriter out = response.getWriter();
	    out.println("<html><body>");
	  
	    // connection to database
	     out.println(name); 
	     out.println("<br>");
	     System.out.println(System.getProperty("java.class.path"));
	    try {
	    	//C:\Users\my271\mysql-connector-j-8.3.0.jar
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","Himanshu@2001");
				String s = "insert into user_details values(?,?,?)";
				PreparedStatement ps = con.prepareStatement(s);
				ps.setString(1, name); 
				ps.setString(2, email);
				ps.setString(3, password);
				ps.executeUpdate();
				out.println("<h1>data submitted successfully<h1>"); 
			} catch (SQLException e) {
				out.println("connection failed"); 
				e.printStackTrace();
			}
		}
		catch (ClassNotFoundException e) {
				e.printStackTrace();
				out.println(e); 
				out.println("<h1>data not submitted<h1>");
			}
	    out.println("</body>");
	    out.println("</html>");   
	}
}
