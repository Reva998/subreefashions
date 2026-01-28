<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.flm.dto.PlanJourneydto,com.flm.dto.UserRegistrationdto,com.flm.dto.Busdetailsdto" %>
<!DOCTYPE html>
<html>
<head>
    <title>Booking Updation</title>
</head>
<body>
    <h2>Booking Updation</h2>
    <%
	PlanJourneydto user = (PlanJourneydto) request.getAttribute("pd");
	     if(user!=null){
    %>
    <form action="editbooking" method="post">
        <label>BookingId:</label>
        <input type="text" name="bookingid" value="<%= user.getBookingid() %>" readonly><br><br>

        <label>Source:</label>
        <input type="text" name="source" value="<%= user.getSource() %>"><br><br>

        <label>Destination:</label>
        <input type="text" name="destination" value="<%= user.getDestination() %>"><br><br>

        <label>Date:</label>
        <input type="date" name="date" value="<%= user.getDate() %>"><br><br>

        <label>Day:</label>
        <input type="text" name="day" value="<%= user.getDay() %>"><br><br>

        <label> Time :</label>
        <input type="time" name="time" value="<%= user.getTime() %>"><br><br>

        <label>Status:</label>
        <input type="text" name="status" value="<%= user.getStatus() %>"><br><br>
		<label>Passangers:</label>
		       <input type="text" name="passangers" value="<%= user.getPassangers() %>"><br><br>
			   <label>UserId:</label>
			   		       <input type="text" name="userid" value="<%= user.getUser().getUserid() %>"><br><br>
						   <label>BusId:</label>
						   <input type="text" name="busid" value="<%= user.getBus().getBusid() %>"><br><br>
			<label>Amount:</label>
		    <input type="text" name="amount" value="<%= user.getTotalamount() %>" readonly><br><br>
		 <label>Payment Status:</label>
					  <input type="text" name="paymentstatus" value="<%= user.getPaymentstatus() %>" readonly><br><br>
					  
        <center><input type="submit" value="Update"></center>
    </form>
    <%
        } else {
    %>
    <p>No booking found.</p>
    <%
        }
    %>
	<a href="homepage"> HomePage</a>
	<a href="bookpage">Back</a>
</body>
</html>
