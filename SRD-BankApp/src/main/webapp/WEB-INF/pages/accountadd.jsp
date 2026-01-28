<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Account</title>

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

        .form-box {
            background: white;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.15);
            width: 350px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        label {
            font-weight: bold;
            font-size: 14px;
            color: #444;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 8px 0 15px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        button {
            width: 100%;
            padding: 12px;
            background: #4CAF50;
            color: white;
            border: none;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background: #45a049;
        }
    </style>
</head>
<body>

    <div class="form-box">
        <h2>Add Account</h2>

        <form method="post" action="saveaccount">

            <label>Account Number</label>
            <input type="text" name="accountnumber" required>

            <label>IFSC Code</label>
            <input type="text" name="ifsc" required>

            <label>Bank Name</label>
            <input type="text" name="bank" required>

            <label>Branch</label>
            <input type="text" name="branch" required>

            <button type="submit">Submit</button>

        </form>
    </div>
	<a href="homepage" >Home</a>
</body>
</html>
