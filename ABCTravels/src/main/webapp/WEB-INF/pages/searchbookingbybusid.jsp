<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Bookings by bus id</title>
</head>
<body>
    <h2>Search Bookings by bus id</h2>
<form action="getbookingbybus" method="post"t>
	<label for="busid">BusId:</label>
	      <input type="text" id="busid" name="busid" required />
	      <button type="submit">Search</button>
		  
	</form>
	<a href="buspage"> back</a><br>
	<a href="bookpage"> back</a><br>
	<a href="homepage"> HomePage</a>
</body>
</html>