<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.flm.dto.UserRegistrationdto" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Updation</title>
</head>
<body>
    <h2>User Updation</h2>
    <%
        UserRegistrationdto user = (UserRegistrationdto) request.getAttribute("ud");
        if (user != null) {
    %>
    <form action="edituser" method="post">
        <label>User Id:</label>
        <input type="text" name="userid" value="<%= user.getUserid() %>" readonly><br><br>

        <label>First Name:</label>
        <input type="text" name="firstname" value="<%= user.getFirstname() %>"><br><br>

        <label>Second Name:</label>
        <input type="text" name="secondname" value="<%= user.getSecondname() %>"><br><br>

        <label>Phone:</label>
        <input type="text" name="phone" value="<%= user.getPhone() %>"><br><br>

        <label>Gender:</label>
        <input type="text" name="gender" value="<%= user.getGender() %>"><br><br>

        <label>Email:</label>
        <input type="email" name="email" value="<%= user.getEmail() %>"><br><br>

        <label>Password:</label>
        <input type="password" name="password" value="<%= user.getPassword() %>"><br><br>

        <label>Failed Count:</label>
        <input type="number" name="failedcount" value="<%= user.getFailedcouts() %>"><br><br>

        <label>Status:</label>
        <input type="text" name="status" value="<%= user.getStatus() %>"><br><br>

        <center><input type="submit" value="Update"></center>
    </form>
    <%
        } else {
    %>
    <p>No users found.</p>
    <%
        }
    %>
	<a href="userpage"> back</a><br>
	<a href="homepage"> HomePage</a>
</body>
</html>
