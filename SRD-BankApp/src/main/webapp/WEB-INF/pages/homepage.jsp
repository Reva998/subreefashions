<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f5f5f5;
        }

        /* Header */
        .header {
            background-color: #4CAF50;
            padding: 20px;
            color: white;
            text-align: center;
        }

        .header h1 {
            margin: 0;
            font-size: 28px;
        }

        .header p {
            margin: 5px 0 0;
            font-size: 16px;
        }

        /* Dashboard Grid */
        .dashboard {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin: 40px 0;
            gap: 20px;
        }

        .card {
            background: white;
            width: 140px;
            height: 140px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.2);
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-decoration: none;
            color: #333;
            transition: transform 0.2s, box-shadow 0.2s;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 15px rgba(0,0,0,0.3);
        }

        .card img {
            width: 100px;
            height: 100px;
            margin-bottom: 10px;
        }

        .card span {
            font-size: 16px;
            font-weight: bold;
            text-align: center;
        }
    </style>
</head>
<body>

    <!-- Header -->
    <div class="header">
        <h1>My Bank Portal</h1>
        <p>Logged in as: <b>${sessionScope.email}</b></p>
    </div>

    <!-- Dashboard with Icons -->
    <div class="dashboard">
        <a href="checkbalance" class="card">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQiib259nVs7EtqYf8iLkk0Pwyn-gELRhzg4A&s" alt="Check Balance">
            <span>Check Balance</span>
        </a>
        <a href="addaccount" class="card">
            <img src="data:image/png;base64,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" alt="Add Account">
            <span>Add Account</span>
        </a>
        <a href="myaccount" class="card">
            <img src="https://cdn-icons-png.flaticon.com/512/6317/6317814.png" alt="My Account">
            <span>My Account</span>
        </a>
        <a href="transfer" class="card">
            <img src="https://cdn-icons-png.flaticon.com/512/4634/4634981.png" alt="Transfer">
            <span>Transfer</span>
        </a>
        <a href="statement" class="card">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjsqVUvpN1HYDZ5KE2gcXWLfso7InCuh1Brg&s" alt="Bank Statement">
            <span>Bank Statement</span>
        </a>
        <a href="logout" class="card">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFA5Wsc1qMNaRAia2Bs3v00fgAb2AHj334-w&s" alt="Logout">
            <span>Logout</span>
        </a>
    </div>

</body>
</html>
