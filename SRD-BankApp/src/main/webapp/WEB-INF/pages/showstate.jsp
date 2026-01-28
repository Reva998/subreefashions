<%@ page import="java.util.List" %>
<%@ page import="com.flm.dto.BankStatementdto" %>

<%
    List<BankStatementdto> statementList = (List<BankStatementdto>) request.getAttribute("statementlist");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank Statement</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f2f2f2;
        padding: 30px;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background: white;
        box-shadow: 0 0 5px gray;
    }

    th, td {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
    }

    th {
        background: #4CAF50;
        color: white;
    }

    tr:nth-child(even) {
        background: #f2f2f2;
    }

    .btn-download {
        display: block;
        width: 200px;
        margin: 20px auto;
        padding: 10px;
        background: #008cff;
        color: white;
        text-align: center;
        text-decoration: none;
        border-radius: 6px;
    }

    .btn-download:hover {
        background: #006ecc;
    }
</style>

</head>
<body>

<h2>Bank Statement</h2>

<table>
    <thead>
        <tr>
            <th>Transaction ID</th>
            <th>Account Number</th>
            <th>UPI ID</th>
            <th>Sender UPI</th>
            <th>Amount</th>
            <th>Date</th>
            <th>Balance</th>
        </tr>
    </thead>
    <tbody>
    <%
        if(statementList != null) {
            for(BankStatementdto b : statementList) {
    %>
        <tr>
            <td><%= b.getTransid() %></td>
            <td><%= b.getAccount_number() %></td>
            <td><%= b.getUpi_id() %></td>
            <td><%= b.getSender_upi() %></td>
            <td> <%= b.getAmount() %></td>
            <td><%= b.getDate() %></td>
            <td> <%= b.getBalance() %></td>
        </tr>
    <%
            }
        } else {
    %>
        <tr>
            <td colspan="7">No Transactions Found</td>
        </tr>
    <%
        }
    %>
    </tbody>
</table>
<a href="homepage" >Home</a>
<a href="downloadStatement" class="btn-download">Download Bank Statement</a>

</body>
</html>
