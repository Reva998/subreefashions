<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Account Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .box {
            background: white;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.15);
            width: 350px;
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .msg {
            font-size: 18px;
            font-weight: bold;
            color: #444;
        }

        a {
            margin-top: 20px;
            display: inline-block;
            padding: 10px 20px;
            background: #4CAF50;
            color: white;
            border-radius: 5px;
            text-decoration: none;
        }

        a:hover {
            background: #45a049;
        }
    </style>
</head>
<body>

    <div class="box">
        <h2>Account Status</h2>

        <div class="msg">
            <%= request.getAttribute("msg") %>
        </div>

        <a href="homepage">Go Home</a>
    </div>

</body>
</html>
