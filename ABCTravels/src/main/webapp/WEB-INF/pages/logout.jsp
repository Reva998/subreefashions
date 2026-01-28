%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logiout Page</title>
</head>
<body>
    <h2>Logout</h2>

    <form action="${pageContext.request.contextPath}/log" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
<input type="button" name="logout"><br>
    </form>

	
		<a href="savepage">Register for new User</a>
		
</body>
</html>