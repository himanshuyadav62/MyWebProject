package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class N2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		response.setContentType("text/html");
		response.getWriter().println("<html><head><title>Registration Confirmation</title></head><body>");
		response.getWriter().println("<h2>servelet n2</h2>");
	}


	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("<html><head><title>Registration Confirmation</title></head><body>");
		
		
		int n11 = Integer.parseInt(request.getParameter("n1"));
		int n22 = Integer.parseInt(request.getParameter("n2"));
		int p = n11 * n22; 
		request.setAttribute("product", p);
		PrintWriter out = response.getWriter();
		int sum = (int) request.getAttribute("sum");
		out.println("<p>Sum: " + sum + "</p>");
		out.println("<p>Product: " + p + "</p>");
	}

}
