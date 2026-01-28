<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Balance</title>
</head>
<body>

    <h2>Account Balance Details</h2>

    <p>Account Number: <%= request.getAttribute("accno") %></p>
    <p>Balance: <%= request.getAttribute("res") %></p>
<a href="homepage" >Home</a>
<a href="checkbalance" >back</a>
</body>
</html>
