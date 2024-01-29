package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ReqDispatcher
 */
public class ReqDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       // initailzer servlet 
		public void init() throws ServletException {
        System.out.println("init() method is called");
    }
    public ReqDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Registration Confirmation</title></head><body>");
        out.println("<h2>Registration Confirmation</h2>");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");

        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Password: " + password + "</p>");
        out.println("<p>Gender: " + gender + "</p>");

        
        // request dispatcher to forward the request to another servlet
        // request.getRequestDispatcher("SecondServlet").forward(request, response);
               
//        RequestDispatcher rd = request.getRequestDispatcher("FirstServlet");
//        rd.forward(request, response);
        
        
         // request dispatcher to include another page in the response
//        RequestDispatcher rd = request.getRequestDispatcher("index.html");
//        rd.include(request, response);
//        out.println("</body> </html> ");
    }
    
    
    //  destroy method  --- life cycle end
	public void destroy() {
		System.out.println("destroy() method is called");
	}

}
