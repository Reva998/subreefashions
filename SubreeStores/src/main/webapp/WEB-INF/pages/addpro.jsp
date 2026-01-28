<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
    <h2>Product Registration Form</h2>
	
    <form action="savepro" method="post">
        <label>Code:</label>
        <input type="text" name="code" required><br><br>

        <label>Product Name:</label>
        <input type="text" name="proname" required><br><br>

        <label>Rate:</label>
        <input type="text" name="rate" required><br><br>

        <label>GST:</label>
        <input type="text" name="gst" required><br><br>

        <label>Total_Quantity:</label>
        <input type="text" name="tq" required><br><br>

        <label>Supplier:</label>
        <input type="text" name="supplier" required><br><br>

        <label>Supplier_Address:</label>
         <textarea name="supp_add" rows="3" cols="25" required></textarea><br><br>

        <label>Quantity_per:</label>
        <input type="text" name="qp" required><br><br>

     <center>   <input type="submit" value="Register"> </center>
    </form>
	<a href="home"> back</a><br>

</body>
</html>
