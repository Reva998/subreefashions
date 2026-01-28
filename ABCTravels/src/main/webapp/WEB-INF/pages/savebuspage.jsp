<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bus Registration</title>
</head>
<body>
    <h2>Bus Registration Form</h2>
	
    <form action="savebus" method="post">
        <label>Source:</label>
        <input type="text" name="source" required><br><br>

        <label>Destination:</label>
        <input type="text" name="destination" required><br><br>

		<label>Date:</label>
		<input type="date" name="date" required><br><br>

		<label>Day:</label>
		<input type="text" name="day" placeholder="e.g., Monday" required><br><br>

		<label>Arrival Time:</label>
		<input type="time" name="arrivaltime" required><br><br>
		<label>Depature Time:</label>
				<input type="time" name="depaturetime" required><br><br>

        <label>Vaccancies:</label>
        <input type="text" name="vaccancies" required><br><br>
		 <label>Amount:</label>
		        <input type="text" name="amount" required><br><br>

        

     <center>   <input type="submit" value="Register"> </center>
    </form>
	<a href="buspage"> back</a><br>
	<a href="homepage"> HomePage</a>
</body>
</html>
