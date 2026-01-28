<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Confirmation</title>
</head>
<body>

<%
    String id = String.valueOf(request.getAttribute("ids"));  // Safe casting
%>

<h2>Confirmation</h2>
<h3>Are you sure you want to proceed with the payment for this booking?</h3><br>

<!-- Link passing booking ID as query parameter -->
<a href="payment?bookingid=<%= id %>">Pay</a>

<br><br>
<a href="showbookingbyuserid">Show Booking</a> |
<a href="bookpage"> back</a><br>
<a href="homepage"> HomePage</a>
</body>
</html>
