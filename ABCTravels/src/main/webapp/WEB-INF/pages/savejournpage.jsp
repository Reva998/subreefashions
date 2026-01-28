<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.flm.dto.Busdetailsdto" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bookings</title>
</head>
<body>
    <h2>Booking Form</h2>
	
    <form action="savejourn" method="post">
        <label>Source:</label>
        <input type="text" name="source" required><br><br>

        <label>Destination:</label>
        <input type="text" name="destination" required><br><br>

		<label>Date:</label>
		<input type="date" name="date" required><br><br>

		<label>Day:</label>
		<input type="text" name="day" placeholder="e.g., Monday" required><br><br>

		<label> Time:</label>
		<input type="time" name="time" required><br><br>
		<label>Passengers:</label>
		<input type="number" name="passengers" min="1" required><br><br>

        <label>UserId:</label>
        <input type="text" name="userid" required><br><br>

	
		    <label>BusId:</label>
			<label>BusId:</label>
			       <input type="text" name="busid" id="busid" required><br><br>
		

     <center>   <input type="submit" value="Register"> </center>
    </form
	<!-- Separate form to View Seats -->
	    <form action="seats" method="post">
	        <input type="hidden" name="busid" id="hiddenBusId">
	        <input type="submit" value="View Seats">
	    </form>
	<br>
	<!-- Search Bus Details by ID -->
	<form action="getonebus" method="post">
	    <label>Search Bus Details by Bus ID:</label>
	    <input type="text" name="busid" required>
	    <input type="submit" value="Search">
	</form>
	
	<a href="homepage"> HomePage</a>
	<a href="bookpage">back</a>
</body>
</html>
