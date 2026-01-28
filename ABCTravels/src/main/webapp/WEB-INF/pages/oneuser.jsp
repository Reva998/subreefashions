<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.flm.dto.UserRegistrationdto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
</head>
<body>
    <h2>User Details</h2>
    <%
        UserRegistrationdto user = (UserRegistrationdto) request.getAttribute("ud");
        if (user != null) {
    %>
    <table border="1">
        <tr>
            <th>User ID</th>
            <th>First Name</th>
            <th>Second Name</th>
            <th>Phone</th>
            <th>Gender</th>
            <th>Email</th>
            <th>Password</th>
            <th>Failed Count</th>
            <th>Status</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <tr>
            <td><%= user.getUserid() %></td>
            <td><%= user.getFirstname() %></td>
            <td><%= user.getSecondname() %></td>
            <td><%= user.getPhone() %></td>
            <td><%= user.getGender() %></td>
            <td><%= user.getEmail() %></td>
            <td><%= user.getPassword() %></td>
            <td><%= user.getFailedcount() %></td>
            <td><%= user.getStatus() %></td>
            <td><a href="edituser?userid=<%= user.getUserid() %>">Edit</a></td>
            <td><a href="deleteuser?userid=<%= user.getUserid() %>">Delete</a></td>
       
	<td><a href="editpage?userid=<%= user.getUserid() %>">Edit</a></td>
	            <td>   <a href="deleteuser?userid=<%= user.getUserid() %>">Delete</a>
					</tr>
					   </table>
    <%
        } else {
    %>
    <p>No user details available.</p>
    <%
        }
    %>
	<a href="userpage"> back</a><br>
	<a href="homepage"> HomePage</a>
</body>
</html>
