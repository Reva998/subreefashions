<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.flm.model.ItemsModel" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Product</title>
</head>
<body>
	<%
	    // Get the bill list and totals from request
		List<Object[]> items = (List<Object[]>) request.getAttribute("items");

	    Float totalBeforeGST = (Float) request.getAttribute("totalBeforeGST");
	    Float totalGST = (Float) request.getAttribute("totalGST");
	    Float grandTotal = (Float) request.getAttribute("grandTotal");
	    Float gstPercent = (Float) request.getAttribute("gstPercent");
		String status=(String) request.getAttribute("status");
	%>

		<% if (items != null && !items.isEmpty()) { %>
			
		    <h2>Bill</h2>
		    <table border="1" cellpadding="5">
		        <tr>
		            <th>Code</th>
		            <th>Product Name</th>
		            <th>Rate</th>
		            <th>Quantity</th>
		           
		            <th>GST</th>
					<th>Total</th>
		        </tr>
		        <% for (Object[] obj : items) { 
		               ItemsModel i = (ItemsModel) obj[0];
		               Integer q = (Integer) obj[1];
		               Float tot = (Float) obj[2];
		        %>
		            <tr>
		                <td><%= i.getCode() %></td>
		                <td><%= i.getProname() %></td>
		                <td><%= i.getRate() %></td>
		                <td><%= q %></td>
		               
		                <td><%= i.getGst() %></td>
						<td><%= tot %></td>
		            </tr>
		        <% } %>
		    </table>

		    <br>
		    <h3>Total Before GST: <%= totalBeforeGST %></h3>
		    <h3>GST (<%= gstPercent %> %): <%= totalGST %></h3>
		    <h3>Grand Total: <%= grandTotal %></h3>
			<h3>Payment_Status: <%= status %></h3>
			<br>
			<br>
			<% } %>
			<button onclick="window.print()">Print Bill</button>
			<a href="home">Back</a><br>
			</body>
			</html>