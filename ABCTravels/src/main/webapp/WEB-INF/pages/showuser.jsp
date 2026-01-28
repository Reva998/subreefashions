<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.flm.dto.UserRegistrationdto" %>

<html>
<head>
    <title>All Users</title>
</head>
<body>
    <h2>Registered Users</h2>

    <%
        List<UserRegistrationdto> list = (List<UserRegistrationdto>) request.getAttribute("lst");
        if (list != null && !list.isEmpty()) {
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
            <th>edit</th>
			<th>delete</th>
        </tr>

        <%
            for (int i = 0; i < list.size(); i++) {
                UserRegistrationdto user = list.get(i);
        %>
        <tr>
            <td><%= user.getUserid() %></td>
            <td><%= user.getFirstname() %></td>
            <td><%= user.getSecondname() %></td>
            <td><%= user.getPhone() %></td>
            <td><%= user.getGender() %></td>
            <td><%= user.getEmail() %></td>
            <td><%= user.getPassword() %></td>
            <td><%= user.getFailedcouts() %></td>
            <td><%= user.getStatus() %></td>
            <td>
                <a href="editpage?userid=<%= user.getUserid() %>">Edit</a></td>
             <td>   <a href="deleteuser?userid=<%= user.getUserid() %>">Delete</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>

    <%
        } 
		else {
    %>
        <p>No users found.</p>
    <%
        }
    %>
	<a href="saveuser">save</a><br>
	<a href="userpage"> back</a><br>
	<a href="homepage"> HomePage</a>
</body>
</html>
