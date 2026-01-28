<%@ page import="java.util.List" %>
<%@ page import="com.flm.dto.AccountDetailsdto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>My Accounts</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            padding: 40px;
        }

        .container {
            width: 450px;
            margin: auto;
            background: white;
            padding: 25px 30px;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.2);
            margin-bottom: 35px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #222;
        }

        .field {
            margin-bottom: 15px;
        }

        .label {
            font-weight: bold;
            color: #444;
            font-size: 14px;
        }

        .value {
            background: #eee;
            padding: 10px;
            border-radius: 5px;
            margin-top: 5px;
            border: 1px solid #ccc;
            font-size: 15px;
        }

        .back-btn {
            display: block;
            width: 120px;
            margin: auto;
            margin-top: 10px;
            padding: 10px;
            text-align: center;
            background: #4CAF50;
            color: white;
            border-radius: 6px;
            text-decoration: none;
        }

        .back-btn:hover {
            background: #45a049;
        }

    </style>
</head>

<body>

<h2>My Account Details</h2>

<%
    List<AccountDetailsdto> accList = (List<AccountDetailsdto>) request.getAttribute("adlist");
    if (accList != null) {
        for (AccountDetailsdto a : accList) {
%>

<div class="container">

    <div class="field">
        <div class="label">Account Number</div>
        <div class="value"><%= a.getAccount_number() %></div>
    </div>

    <div class="field">
        <div class="label">User Name</div>
        <div class="value"><%= a.getUsername() %></div>
    </div>

    <div class="field">
        <div class="label">IFSC Code</div>
        <div class="value"><%= a.getIfsc() %></div>
    </div>

    <div class="field">
        <div class="label">UPI ID</div>
        <div class="value"><%= a.getUpi_id() %></div>
    </div>

    <div class="field">
        <div class="label">Bank Name</div>
        <div class="value"><%= a.getBankname() %></div>
    </div>

    <div class="field">
        <div class="label">Branch</div>
        <div class="value"><%= a.getBranch() %></div>
    </div>

    <div class="field">
        <div class="label">Phone</div>
        <div class="value"><%= a.getPhone() %></div>
    </div>

    <div class="field">
        <div class="label">Email</div>
        <div class="value"><%= a.getEmail() %></div>
    </div>

    <div class="field">
        <div class="label">Address</div>
        <div class="value"><%= a.getAddress() %></div>
    </div>

    <div class="field">
        <div class="label">Balance</div>
        <div class="value">₹ <%= a.getBalance() %></div>
    </div>

</div>

<%
        }
    }
%>

<a href="homepage" class="back-btn">Back</a>

</body>
</html>
