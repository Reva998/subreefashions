<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.flm.dto.Busdetailsdto" %>
<!DOCTYPE html>

<html>
<head>
    <title>All Buses</title>
</head>
<body>
    <h2>Bus details</h2>

    <%
        List<Busdetailsdto> list = (List<Busdetailsdto>) request.getAttribute("lst");
        if (list != null && !list.isEmpty()) {
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

        <%
            for (int i = 0; i < list.size(); i++) {
                Busdetailsdto user = list.get(i);
        %>
        <tr>
			<td><%= user.getBusid() %></td>
            <td><%= user.getSource() %></td>
            <td><%= user.getDestination() %></td>
            <td><%= user.getDate() %></td>
            <td><%= user.getDay() %></td>
            <td><%= user.getArrivaltime() %></td>
            <td><%= user.getDepaturetime() %></td>
            <td><%= user.getVaccancies() %></td>
			<td><%= user.getAmount() %></td>
            
        </tr>
        <%
            }
        %>
    </table>

    <%
        } 
		else {
    %>
        <p>No bus found.</p>
    <%
        }
    %>
	<a href="buspage"> back</a><br>
	<a href="homepage"> HomePage</a>
</body>
</html>
