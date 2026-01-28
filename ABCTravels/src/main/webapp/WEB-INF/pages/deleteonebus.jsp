<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.flm.dto,Busdetailsdto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bus Details</title>
</head>
<body>
    <h2>User Details</h2>
    <%
	Busdetailsdto list = (Busdetailsdto) request.getAttribute("ud");
	      if (list != null ) {
    %>
    <table border="1">
        <tr>
			<th>BusId</th>
			<th>Source</th>
			
			            <th>Destination</th>
			            <th>Date</th>
			            <th>Day</th>
			            <th>Arrival_Time</th>
			            <th>Depature_Time</th>
			            <th>Vaccancies</th>
			           <th>Amount</th>
        </tr>
        <tr>
			<td><%=user.getBusid() %></td>
			<td><%= user.getSource() %></td>
			          <td><%= user.getDestination() %></td>
			          <td><%= user.getDate() %></td>
			          <td><%= user.getDay() %></td>
			          <td><%= user.getArrivaltime() %></td>
			          <td><%= user.getDepaturetime() %></td>
			          <td><%= user.getVaccancies() %></td>
					  <td><%= user.getAmount() %></td>
        </tr>
    </table>
	<a href="deletebus">delete</a>
    <%
        } else {
    %>
    <p>No bus details available.</p>
    <%
        }
    %>
	<a href="buspage"> back</a><br>
	<a href="homepage"> HomePage</a>
</body>
</html>
