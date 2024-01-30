package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



public class displayAttrbResults extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	// get forwaded responce from setAttributeArithmaticsServlet.html
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// call processRequest method to display the attribtes
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("displaying attributs"); 
		out.println("<html><body>");
		String firstNum = (String) request.getAttribute("firstNum");
		String secondNum = (String) request.getAttribute("secondNum");	
		
		// get attribute fomr reqeust object and print them 
		out.println("sum of " + firstNum + "and " + secondNum + " is " + (int) request.getAttribute("add"));
		out.println("sub of " + firstNum + "and " + secondNum +  " is " + (int) request.getAttribute("sub"));
		out.println("multiply of " + firstNum + "and " + secondNum + " is " + (int) request.getAttribute("multiply"));
		out.println("divide of " + firstNum + "and " + secondNum + " is " + (int) request.getAttribute("divide"));
		out.println("</body></html>");
	}
}
