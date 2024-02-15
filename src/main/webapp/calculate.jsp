<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculation</title>
<script>
    function performCalculation() {
        var xhr = new XMLHttpRequest();
        var expression = document.getElementById("expression").value;

        xhr.open("POST", "Calculate");
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); 
        xhr.onload = function() {
            if (xhr.status === 200) {
                document.getElementById("result").textContent = xhr.responseText;
            } else {
                alert("An error occurred.");
            }
        };
        xhr.send("expression=" + encodeURIComponent(expression)); // Send the data
    }
</script>
<style>
	form {
	    margin-left: 50px;
	    margin-top: 50px; 
	}
	
	input {
		width: 200px;
	}
	
	button {
		margin-left: 10px;
	}
	
	#result {
	    margin-left: 50px;
	    font-size: 20px;
	    margin-top: 20px;
		font-weight: bold;
	}
</style>
</head>
<body>
    <form> 
        <input type="text" id="expression" placeholder="Enter your arithmetic expression">
        <button type="button" onclick="performCalculation()">Calculate</button> 
    </form>
    <div id="result"></div> </body>
</html>
