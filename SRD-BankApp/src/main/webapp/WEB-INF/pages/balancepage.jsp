<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Select Account</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
            width: 400px;
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .account-list {
            display: flex;
            flex-direction: column;
            gap: 10px;
            max-height: 200px; /* scrollable if too many accounts */
            overflow-y: auto;
        }

        .account-item {
            padding: 12px 15px;
            background: #f0f0f0;
            border-radius: 5px;
            cursor: pointer;
            transition: background 0.2s, transform 0.2s;
            display: flex;
            align-items: center;
        }

        .account-item:hover {
            background: #e0e0e0;
            transform: translateX(2px);
        }

        /* Hide default radio button */
        .account-item input[type="radio"] {
            display: none;
        }

        /* Selected style */
        .account-item input[type="radio"]:checked + label {
            background: #4CAF50;
            color: white;
        }

        label {
            width: 100%;
            cursor: pointer;
            user-select: none;
        }

        button {
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

    </style>
</head>
<body>

<div class="container">
    <h2>Select Account</h2>
    <form action="getbalance" method="post">
        <div class="account-list">
            <%
                java.util.List<String> accounts = (java.util.List<String>) request.getAttribute("accounts");
                if (accounts != null && !accounts.isEmpty()) {
                    int i = 0;
                    for (String acc : accounts) {
            %>
                        <div class="account-item">
                            <input type="radio" id="acc<%=i%>" name="accountnumber" value="<%= acc %>">
                            <label for="acc<%=i%>"><%= acc %></label>
                        </div>
            <%
                        i++;
                    }
                } else {
            %>
                <div class="account-item">
                    <label>No accounts available</label>
                </div>
            <%
                }
            %>
        </div>
        <button type="submit">Check Balance</button>
    </form>
</div>

</body>
</html>
