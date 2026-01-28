<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.flm.model.ItemsModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Product</title>
</head>
<body>
<h2>Search Product</h2>

<form action="search" method="post">
    <label for="code">Code:</label>
    <input type="text" id="code" name="code" value="<%= request.getAttribute("lastCode") != null ? request.getAttribute("lastCode") : "" %>" required />
    <button type="submit">Search</button>
</form>

<br><br>

<%
    ItemsModel user = (ItemsModel) request.getAttribute("im");
    Boolean notfound = (Boolean) request.getAttribute("notfound");

    if (user != null) {  // only show details if user exists
%>
    <h3>Product Details</h3>
    <table border="1">
        <tr>
            <th>Code</th>
            <th>Product Name</th>
            <th>Rate</th>
            <th>GST</th>
            <th>Total Quantity</th>
            <th>Supplier</th>
            <th>Supplier Address</th>
            <th>Quantity per</th>
        </tr>
        <tr>
            <td><%= user.getCode() %></td>
            <td><%= user.getProname() %></td>
            <td><%= user.getRate() %></td>
            <td><%= user.getGst() %></td>
            <td><%= user.getTotal_quantity() %></td>
            <td><%= user.getSupplier() %></td>
            <td><%= user.getSupplier_add() %></td>
            <td><%= user.getQuantity_per() %></td>
        </tr>
    </table>
<%
    } else if (notfound != null && notfound) {
%>
    <p style="color:red;">No product found for this code.</p>
<%
    } else {
%>
    <p>Enter a product code to search.</p>
<%
    }
%>

<br>
<a href="addpro">Add Product</a><br>
<a href="home">Back</a><br>
</body>
</html>
