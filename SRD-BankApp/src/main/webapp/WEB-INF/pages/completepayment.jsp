<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Status</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f2f2f2;
    }
    .container {
        width: 450px;
        margin: 50px auto;
        background: white;
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0 0 10px gray;
    }
    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }
    .field {
        margin-bottom: 12px;
    }
    .label {
        font-weight: bold;
        color: #444;
    }
    .value {
        background: #eee;
        padding: 8px;
        border-radius: 5px;
        margin-top: 4px;
    }
    .msg {
        text-align: center;
        font-size: 18px;
        font-weight: bold;
        color: green;
        margin-top: 20px;
    }
    .msg.failed {
        color: red;
    }
    .back-btn {
        display: block;
        width: 120px;
        text-align: center;
        margin: 25px auto 0 auto;
        padding: 10px;
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

<div class="container">
    <h2>Transaction Details</h2>

    <div class="field">
        <div class="label">Transaction ID</div>
        <div class="value"><%= request.getAttribute("tid") %></div>
    </div>

    <div class="field">
        <div class="label">UPI ID</div>
        <div class="value"><%= request.getAttribute("upi") %></div>
    </div>

    <div class="field">
        <div class="label">Sender UPI</div>
        <div class="value"><%= request.getAttribute("supi") %></div>
    </div>

    <div class="field">
        <div class="label">Amount</div>
        <div class="value">₹ <%= request.getAttribute("am") %></div>
    </div>

    <div class="field">
        <div class="label">Transaction Date & Time</div>
        <div class="value"><%= request.getAttribute("ttd") %></div>
    </div>

    <div class="msg <%= "Sorry,Payment failed".equals(request.getAttribute("msg")) ? "failed" : "" %>">
        <%= request.getAttribute("msg") %>
    </div>

    <a href="homepage" class="back-btn">Back to Home</a>

</div>
<button onclick="window.print()">Print This Page</button>

</body>
</html>
