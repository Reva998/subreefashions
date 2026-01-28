<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.flm.model.ItemsModel" %>

<html>
<head>
    <title>All Products</title>
</head>
<body>
   <h2>Registered Products</h2>

    <%
        ItemsModel  user = (ItemsModel) request.getAttribute("im");
        if (user != null) {
    %>

    <table border="1">
        <tr>
            <th>Code</th>
            <th>Product Name</th>
            <th>Rate</th>
            <th>GST</th>
            <th>TotalQuantity</th>
            <th>Suppiler</th>
            <th>Supplier_Address</th>
            <th>Quantity_per</th>
            
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
        }
		else {
    %>
        <p>No products found.</p>
    <%
        }
    %>
	<a href="addpro">Add_product</a><br>
	<a href="home"> back</a><br>

</body>
</html>
