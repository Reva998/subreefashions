<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Saree</title>
</head>
<body>

<h2>Add Saree</h2>

<form action="add" method="post">
    <label>Image URL:</label><br>
    <input type="text" name="imageurl" required><br><br>

    <label>Price (₹):</label><br>
    <input type="number" name="price" required><br><br>

    <label>Description:</label><br>
    <input type="text" name="desc" required><br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>
