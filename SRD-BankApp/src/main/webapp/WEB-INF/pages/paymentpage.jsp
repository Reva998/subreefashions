<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Payment Details</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f3f3f3;
    }
    .container {
        width: 400px;
        margin: 40px auto;
        background: white;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px gray;
    }
    h2 {
        text-align: center;
    }
    label {
        font-weight: bold;
    }
    input[type="text"], input[type="number"] {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        margin-bottom: 15px;
        border-radius: 5px;
        border: 1px solid #ccc;
    }
    button {
        width: 100%;
        padding: 10px;
        background: #008cff;
        border: none;
        color: white;
        font-size: 18px;
        border-radius: 5px;
        cursor: pointer;
    }
    button:hover {
        background: #006ecc;
    }
</style>

</head>
<body>

<div class="container">
    <h2>Enter Payment Details</h2>

    <form action="paypage" method="post">

        <label>Account Number</label>
        <input type="text" name="account_number" required>

        <label>UPI ID</label>
        <input type="text" name="upi_id" required>

        <label>Sender UPI ID</label>
        <input type="text" name="sender_upi" required>

        <label>Amount</label>
        <input type="number" name="amount" required>

       

        <button type="submit">Submit</button>
    </form>

</div>

</body>
</html>
