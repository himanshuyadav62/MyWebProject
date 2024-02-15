package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class Calculate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String expression = request.getParameter("expression");
        
        
        String result = Calculator.calculate(expression);
        
        response.setContentType("text/plain"); 
        response.getWriter().write(result);
    }

   
}
