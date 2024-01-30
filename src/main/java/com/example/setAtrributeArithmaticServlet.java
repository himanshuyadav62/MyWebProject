package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// this servlet will set the attributes for the arithmatic operation set in getTwoNumbers.html and display the results in displayAttrbResults.html
public class setAtrributeArithmaticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public setAtrributeArithmaticServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		// get the values from the inputNumber.html
		String firstNumber = request.getParameter("n1");
		String secondNumber = request.getParameter("n2");
		
		
		int firstNum = Integer.parseInt(firstNumber);
		int secondNum = Integer.parseInt(secondNumber);
		// set the attribute
			request.setAttribute("firstNum", firstNumber);
			request.setAttribute("secondNum", secondNumber);
			request.setAttribute("add", (firstNum + secondNum));
		
			request.setAttribute("sub", (firstNum - secondNum));
	
			request.setAttribute("multiply", (firstNum * secondNum));
		
			request.setAttribute("divide", (firstNum / secondNum));
	
		
		// forward the request to displayAttrbResults.html
		RequestDispatcher rd = request.getRequestDispatcher("displayAttrbResults");
		rd.forward(request, response);
	}

}
