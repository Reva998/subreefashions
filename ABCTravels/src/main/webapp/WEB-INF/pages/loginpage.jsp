<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
	<center>
    <h2>Login</h2>

    <form action="${pageContext.request.contextPath}/validate" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Login">
    </form>

	<% 
	        String error = (String) request.getAttribute("error");
	        if (error != null) {
	    %>
	        <p style="color: red;"><%= error %></p>
	    <%
		}
		%>
	<br><br>	<a href="savepage">Register for new User</a>
	</center>	
</body>
</html>
