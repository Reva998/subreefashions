<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Bookings by User id</title>
</head>
<body>
    <h2>Search Bookings by User id</h2>
<form action="getbookingbyuser" method="post"t>
	<label for="userid">UserId:</label>
	      <input type="text" id="userid" name="userid" required />
	      <button type="submit">Search</button>
		  
	</form>
	<a href="userpage"> back</a><br>
	<a href="bookpage"> back</a><br>
	<a href="homepage"> HomePage</a>
</body>
</html>