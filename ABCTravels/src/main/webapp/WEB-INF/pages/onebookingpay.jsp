<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.flm.dto.PlanJourneydto,com.flm.dto.UserRegistrationdto,com.flm.dto.Busdetailsdto" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Bookings</title>
</head>
<body>
    <h2>Booking details</h2>

    <%
        PlanJourneydto user = (PlanJourneydto) request.getAttribute("ud");
       if(user!=null)
	   {
    %>

    <table border="1">
        <tr>
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
		   <th> Edit </th>
		   <th> Delete </th>
        </tr>
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

       
 
	<td> <a href="editbookingpage?bookingid=<%= user.getBookingid() %>">Edit</a></td>
		            <td>   <a href="deletebooking?bookingid=<%= user.getBookingid() %>">Delete</a>
						</tr>
						</table>
    <%
        } else {
    %>
    <p>No booking details available.</p>
    <%
        }
    %>
	<a href="confirmpayment?bookingid=<%=user.getBookingid()%>"> proceed payment</a><br>
	<a href="bookpage"> back</a><br>
	<a href="homepage"> HomePage</a>
</body>
</html>
