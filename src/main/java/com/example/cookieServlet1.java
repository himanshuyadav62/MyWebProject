package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// this servlet will be called when the user clicks on the "Submit" button
// in this servlet , we will make a cookie of user's name and send it to cookieServlet2
public class cookieServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public cookieServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		String name =  request.getParameter("name");
		
		// creating a cookie
		
		
		out.println("welcome ! " + name); 
		out.println("<br>");
		// requst dispatch button to send request to cookieservlet2
		out.println("<a href='cookieServlet2'>go to servlet 2</a>");
		Cookie userName = new Cookie("user", name);
		response.addCookie(userName);
		out.println("</body></html>");
		
	}

}
