package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class N1
 */
public class N1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public N1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		int n11 = Integer.parseInt(n1);
		int n22 = Integer.parseInt(n2);
		
		PrintWriter out = response.getWriter();
		
		
		int s = n11 + n22;
		
		// attribute is set in request scope
		request.setAttribute("sum", s);
		
		// request dispatcher
		 request.getRequestDispatcher("N2").forward(request, response);
	}
}
