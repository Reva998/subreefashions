<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Bookings</title>
</head>
<body>
    <h2>Search Bookings</h2>
<form action="getpaybooking" method="post"t>
	<label for="bookingid">BookingId:</label>
	      <input type="text" id="bookingid" name="bookingid" required />
	      <button type="submit">Search</button>
		  
	</form>
	<a href="bookpage"> back</a><br>
	<a href="homepage"> HomePage</a>
</body>
</html>