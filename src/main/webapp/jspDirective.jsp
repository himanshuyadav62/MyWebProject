<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.Random,java.util.ArrayList,java.io.*" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<h1>Random number </h1>
	<%
		Random r = new Random(); 
	    int n = r.nextInt(100); 
	    //out.println(n);
	%>
	<h2> Random number is : <%= n %></h2>
	
	<p>2. include directive
	</p>
	<%-- including greetings.html page in this page  --%>
	<%@include file =  "greetings.html" %>
	
	<br>
	<br> 
	
	
</body>
</html>















<%-- TAGLIB 
// helps use to use other library 
    JSTL LIBRARY  
    CORE -- OUT , forEach , if ,
    sql , 
    formatting 

	 --%>

<%--
		<p>
			<h2>jsp directive</h2>
			<p> page directive</p>
			<p> include directive</p>
			<p> taglib directive</p>
		</p>
		<br> 
		<p>1.  page directive</p>
		<p> apply on whole page
			<%@ page language="java" contentType="text/html; charset=UTF-8"
				pageEncoding="UTF-8"%>
		</p>		
	 --%>