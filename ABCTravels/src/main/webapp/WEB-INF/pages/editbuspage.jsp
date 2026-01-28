<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.flm.dto.Busdetailsdto" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Updation</title>
</head>
<body>
    <h2>User Updation</h2>
    <%
        Busdetailsdto user = (Busdetailsdto) request.getAttribute("ud");
        if (user != null) {
    %>
    <form action="editbus" method="post">
        <label>BusId:</label>
        <input type="text" name="busid" value="<%= user.getBusid() %>" readonly><br><br>

        <label>Source:</label>
        <input type="text" name="source" value="<%= user.getSource() %>"><br><br>

        <label>Destination:</label>
        <input type="text" name="destination" value="<%= user.getDestination() %>"><br><br>

        <label>Date:</label>
        <input type="date" name="date" value="<%= user.getDate() %>"><br><br>

        <label>Day:</label>
        <input type="text" name="day" value="<%= user.getDay() %>"><br><br>

        <label>Arrival Time :</label>
        <input type="time" name="arrivaltime" value="<%= user.getArrivaltime() %>"><br><br>

        <label>Depature Time:</label>
        <input type="time" name="depaturetime" value="<%= user.getDepaturetime() %>"><br><br>

       

        <label>Seats Available:</label>
        <input type="text" name="vaccancies" value="<%= user.getVaccancies() %>"><br><br>
		<label>Amount:</label>
		        <input type="text" name="amount" value="<%= user.getAmount() %>"><br><br>
        <center><input type="submit" value="Update"></center>
    </form>
    <%
        } else {
    %>
    <p>No bus found.</p>
    <%
        }
    %>
	<a href="buspage"> back</a><br>
	<a href="homepage"> HomePage</a>
</body>
</html>
