<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.flm.dto.PlanJourneydto, com.flm.dto.UserRegistrationdto, com.flm.dto.Busdetailsdto" %>
<!DOCTYPE html>
<html>
<head>
    <title>Receipt</title>
</head>
<body>
	<center>
		<h3> ABC Travels</h3>
    <h4>Receipt</h4>
	</center>
	<br>
	
	<br>

    <%
        PlanJourneydto user = (PlanJourneydto) request.getAttribute("ud");
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
		LocalTime time = LocalTime.now();
		    String formattedTime = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    %>

	<p>
	    <span>Date of Receipt: <%= formattedDate %></span>
	    <span style="margin-left: 300px;">Time of Receipt: <%= formattedTime %></span>
	    <span style="margin-left: 300px;">EmailId: <%= user.getUser().getEmail() %></span>
	</p>


    <%
        if(user != null) {
    %>
	<br>
	<br>
	
    <table border="1">
        <tr>
			<th>BookingId</th>
			<th>First Name</th>
			<th>Second Name</th>
			<th>Phone Number</th>	
            <th>Source</th>
            <th>Destination</th>
            <th>Date</th>
            <th>Day</th>
            <th>Time</th>
            <th>Status</th>
            <th>Passengers</th>
            <th>User ID</th>
            <th>Bus ID</th>
            <th>Total Amount</th>
            <th>Payment Status</th>
        </tr>
        <tr>
			<td><%= user.getBookingid() %></td>
			<td><%= user.getUser().getFirstname() %></td>
			<td><%= user.getUser().getSecondname() %></td>
			<td><%= user.getUser().getPhone() %></td>
            <td><%= user.getSource() %></td>
            <td><%= user.getDestination() %></td>
            <td><%= user.getDate() %></td>
            <td><%= user.getDay() %></td>
            <td><%= user.getTime() %></td>
            <td><%= user.getStatus() %></td>
            <td><%= user.getPassangers() %></td>
            <td><%= user.getUser().getUserid() %></td>
            <td><%= user.getBus().getBusid() %></td>
            <td><%= user.getTotalamount() %></td>
            <td><%= user.getPaymentstatus() %></td>
        </tr>
    </table>
    <%
        } else {
    %>
        <p>No booking details available.</p>
    <%
        }
    %>
	<br>
	<br>
	<br>
<center>	<p> THANKS FOR CHOOSING ABC TRAVELS</p></center>
<center>	<p> <: Have a Happy Journey :></p></center>
<br><br><br><br>	<br><button onclick="window.print()">Print or Save Receipt as PDF</button>

    <br><br><br>
	<a href="bookpage"> back</a><br><br><br>
  <a href="homepage"> HomePage</a>
</body>
</html>
