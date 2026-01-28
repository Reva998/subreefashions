<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h2>User Registration Form</h2>
	
    <form action="saveuser" method="post">
        <label>First Name:</label>
        <input type="text" name="firstname" required><br><br>

        <label>Second Name:</label>
        <input type="text" name="secondname" required><br><br>

        <label>Phone:</label>
        <input type="text" name="phone" required><br><br>

        <label>Gender:</label>
        <input type="text" name="gender" required><br><br>

        <label>Email:</label>
        <input type="email" name="email" required><br><br>

        <label>Password:</label>
        <input type="password" name="password" required><br><br>

        <label>Failed Count:</label>
        <input type="number" name="failedcount" required><br><br>

        <label>Status:</label>
        <input type="text" name="status" required><br><br>

     <center>   <input type="submit" value="Register"> </center>
    </form>
	<a href="userpage"> back</a><br>
	<a href="homepage"> HomePage</a>
</body>
</html>
