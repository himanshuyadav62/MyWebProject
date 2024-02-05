<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jsp page 1</h2>
	<%-- scriptlet tag 
        Java code can be written here
     --%>
	<%!int a= 2; 
		int b = 3; 
		int sum(int a,int b){
			return a+b; 
		}
		static String reverse(String a){
			// reverse String a by function
			String result = "";
			for (int i = a.length() - 1; i >= 0; i--) {
				result += a.charAt(i);
			}
            return result;
		}
	%>
	<%--
		declaration tag
	 --%>
	<%
        out.println("a+b = " + sum(a,b));
		out.println("<br>");
        out.println("reverse = " + reverse("hello"));
    %>
   	
 	 <%-- expression tag 
 	 	 directly print the result of expression without using out.println()
 	 --%>  	
    
    <%=
    	"<br>" + 
    	"sum is " + (a+b)
    %>
    
    <br> 
    <br>
    <a href="jspDirective.jsp">jsp directive</a>
</body>
</html>