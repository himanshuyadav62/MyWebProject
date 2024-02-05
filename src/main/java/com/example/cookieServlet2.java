package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// this servlet class will get the data from cookieServlet1
// will use the value stored in cookie declred in cookie servlet 1
public class cookieServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public cookieServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Cookie[] cookies = request.getCookies();
		
		String name = ""; 
		boolean flag = false;
		if(cookies == null) {
			out.println("you are a new user got to home page to enter your name"); 
			out.println("<a href='index.html'>Home</a>");
		}else {
			 
			for(Cookie c : cookies) {
				String cName = c.getName();
				if(cName.equals("user")) {
					flag = true; 
					name = c.getValue();
				}
			}
			if(flag == true) {
				out.println("welcome back !" + name);
			}else {
				out.println("you are a new user got to home page to enter your name"); 
				out.println("<a href='index.html'>Home</a>");
			}
		}
		
		out.println("<html><body>");
	}

}
