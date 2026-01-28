<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.flm.dto.PlanJourneydto,com.flm.dto.UserRegistrationdto,com.flm.dto.Busdetailsdto" %>
<%@ page import="java.net.URLEncoder" %>
<html>
<head>
    <title>All Bookings</title>
</head>
<body>
    <h2>Booking details</h2>

    <%
        List<PlanJourneydto> list = (List<PlanJourneydto>) request.getAttribute("lst");
        if (list != null && !list.isEmpty()) {
    %>

    <table border="1">
        <tr>
			<th>Booking Id</th>
            <th>Source</th>
            <th>Destination</th>
            <th>Date</th>
            <th>Day</th>
            <th>Time</th>
            <th>Status</th>
			<th>Passangers</th>
            <th>UserId</th>
			<th>BusId</th>
			
           <th>TotalAmount</th>
		   <th>PaymentStatus</th>
		   <th> Edit</th>
		   <th> Delete</th>
        </tr>

        <%
            for (int i = 0; i < list.size(); i++) {
                PlanJourneydto user = list.get(i);
        %>
        <tr>
			<td><%=user.getBookingid() %></td>
            <td><%= user.getSource() %></td>
            <td><%= user.getDestination() %></td>
            <td><%= user.getDate() %></td>
            <td><%= user.getDay() %></td>
            <td><%= user.getTime() %></td>
            <td><%= user.getStatus() %></td>
			<td><%= user.getPassangers()%></td>
            <td><%= user.getUser().getUserid() %></td>
			<td><%= user.getBus().getBusid()%></td>
			<td><%= user.getTotalamount()%></td>
			<td><%= user.getPaymentstatus()%></td>
			
			<td><a href="editbookingpage?bookingid=<%= user.getBookingid() %>">Edit</a></td>
			<td><a href="deletebooking?bookingid=<%= user.getBookingid() %>">Delete</a></td>

        </tr>
        <%
            }
        %>
    </table>
	
    <%
        } 
		else {
    %>
        <p>No Bookings found.</p>
    <%
        }
    %>
	<a href="savejournpage">Save</a><br>
	<a href="bookpage"> back</a><br>
	<a href="homepage"> HomePage</a>
</body>
</html>
