<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>filters Uses</title>
</head>
<body>
	<!--  filter is pluggable
		usage -> 
			1. Authentication
			2. authorization
			3. formatting of request body or header before sending to servlet
			4. compressing the response data sent to the client
			5. alter response by adding some cookies , header information 
			6. **** input validation 
	 -->
	 <!--
	 	Filter - > init , doFilter , Destroy
	 	FilterChain 
	 	FilterConfig	
	 -->
	 <div class ="container">
	 	<h1><a href="ProfileServlet">go to Profile Servlet</a></h1>
	 	<h1><a href="OrderServlet">Go to Order Servlet</a></h1>
	 </div>
</body>
</html>