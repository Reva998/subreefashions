<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search-bus</title>
</head>
<body>
    <h2>Search_bus</h2>
<form action="editbuspage" method="post">
	<label for="busid">BusId:</label>
	      <input type="text" id="busid" name="busid" required />
	      <button type="submit">Search</button>
		  
	</form>
	<a href="buspage"> back</a><br>
	<a href="homepage"> HomePage</a>
</body>
</html>