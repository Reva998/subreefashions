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
<h2>Search Product</h2>

<!-- Search Form -->
<form action="search1" method="post">
    <label for="code">Code:</label>
    <input type="text" id="code" name="code"
           value="<%= request.getAttribute("lastCode") != null ? request.getAttribute("lastCode") : "" %>"
           required />
    <button type="submit">Search</button>
</form>

<%
    ItemsModel user = (ItemsModel) request.getAttribute("im");
    Boolean notfound = (Boolean) request.getAttribute("notfound");

    if (user != null) {
        // Store product details in session
        session.setAttribute("code", user.getCode());
        session.setAttribute("proname", user.getProname());
        session.setAttribute("rate", user.getRate());
        session.setAttribute("totgst", user.getGst());
%>
    <h3>Product Details</h3>
    <table border="1">
        <tr>
            <th>Code</th>
            <th>Product Name</th>
            <th>Rate</th>
            <th>GST</th>
            <th>Total Quantity</th>
        </tr>
        <tr>
            <td><%= user.getCode() %></td>
            <td><%= user.getProname() %></td>
            <td><%= user.getRate() %></td>
            <td><%= user.getGst() %></td>
            <td><%= user.getTotal_quantity() %></td>
        </tr>
    </table>
    <br><br>

    <!-- Quantity Form -->
    <form action="addqun" method="post">
        <label>Enter Quantity:</label>
        <input type="text" name="qun" required>
        <input type="hidden" name="code" value="<%= user.getCode() %>">
        <br><br>
        <center><input type="submit" value="Add"></center>
    </form>

<%
        // Store total, gst, qun in session if available
        Object totalObj = request.getAttribute("tot");
        Object gstObj = request.getAttribute("gst");
        Object qunObj = request.getAttribute("qu");

        Float total = (totalObj != null) ? (Float) totalObj : 0f;
        Float gst = (gstObj != null) ? (Float) gstObj : 0f;
        Integer qun = (qunObj != null) ? (Integer) qunObj : 0;

        session.setAttribute("totl", total);
        session.setAttribute("gst", gst);
        session.setAttribute("qun", qun);
%>

    <!-- Add To Bill Form -->
    <form action="addbill" method="post">
        <label>Total:</label>
        <input type="text" name="tot" value="<%= total %>" readonly>
        <label>Total GST:</label>
        <input type="text" name="gst" value="<%= gst %>" readonly>

        <input type="hidden" name="code" value="<%= session.getAttribute("code") %>">
        <input type="hidden" name="proname" value="<%= session.getAttribute("proname") %>">
        <input type="hidden" name="quan" value="<%= session.getAttribute("qun") %>">
        <input type="hidden" name="rate" value="<%= session.getAttribute("rate") %>">
        <input type="hidden" name="totgst" value="<%= session.getAttribute("totgst") %>">

        <br><br>
        <center><input type="submit" value="Add_To_Bill"></center>
    </form>

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

<br><br>

<%
    // Bill List and Totals
    List<Object[]> items = (List<Object[]>) request.getAttribute("items");
    Float totalBeforeGST = (Float) request.getAttribute("totalBeforeGST");
    Float totalGST = (Float) request.getAttribute("totalGST");
    Float grandTotal = (Float) request.getAttribute("grandTotal");
    Float gstPercent = (Float) request.getAttribute("gstPercent");

    // Retrieve session values for second form
    Float ttl = (Float) session.getAttribute("totl");
    Float gt = (Float) session.getAttribute("gst");
    Integer qunValue = (Integer) session.getAttribute("qun");
%>

<% if (items != null && !items.isEmpty()) { %>
    <form action="billpay" method="post">
        <h2>Added Products</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>Code</th>
                <th>Product Name</th>
                <th>Rate</th>
                <th>Quantity</th>
                <th>GST</th>
                <th>Total</th>
				<th> Delete</th>
            </tr>
			<% for (int index = 0; index < items.size(); index++) { 
			          Object[] obj = items.get(index);
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
					 <td> <a href="deleteFromBill?index=<%= index %>">Delete</a></td>
                </tr>
            <% } %>
        </table>

        <br>
        <h3>Total Before GST: <%= totalBeforeGST %></h3>
        <h3>GST (<%= gstPercent %> %): <%= totalGST %></h3>
        <h3>Grand Total: <%= grandTotal %></h3>

        <br><br>
        <label for="paymentstatus">Payment Status:</label>
        <select name="paymentstatus" id="paymentstatus" style="width:120px; height:30px; overflow-y:auto;">
            <option value="select">select</option>
            <option value="paid">Paid</option>
            <option value="reject">Reject</option>
        </select>

        <!-- Hidden values for billpay form -->
        <input type="hidden" name="tot" value="<%= ttl %>" readonly>
        <input type="hidden" name="gst" value="<%= gt %>" readonly>
        <input type="hidden" name="quan" value="<%= qunValue %>">
        <input type="hidden" name="code" value="<%= session.getAttribute("code") %>">
        <input type="hidden" name="proname" value="<%= session.getAttribute("proname") %>">
        <input type="hidden" name="rate" value="<%= session.getAttribute("rate") %>">
        <input type="hidden" name="totgst" value="<%= session.getAttribute("totgst") %>">

        <br><br>
        <input type="submit" value="Submit">
    </form>
<% } %>

<a href="clearbill">clear_bill</a><br>
<a href="home">Back</a><br>
</body>
</html>
