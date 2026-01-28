<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.flm.dto.Kanchisareesdto" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Collections</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/collstyle.css">
</head>
<body>
<div class="scroll-container">
  <div class="scroll-track">
    <img src="<%= request.getContextPath() %>/images/img14.jpg" alt="1">
    <img src="<%= request.getContextPath() %>/images/img10.jpg" alt="2">
    <img src="<%= request.getContextPath() %>/images/img9.jpg" alt="3">
    <img src="<%= request.getContextPath() %>/images/img8.jpg" alt="4">
    <img src="<%= request.getContextPath() %>/images/img13.jpg" alt="5">
  </div>
</div>

<br><br>
<h2 style="text-align: center; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
    Silkpattu Sarees
</h2>

<section class="dis">
    <%
        List<Kanchisareesdto> list = (List<Kanchisareesdto>) request.getAttribute("kl");
        if (list != null && !list.isEmpty()) {
            for (Kanchisareesdto user : list) {
    %>
        <div class="arg">
            <img src="<%= user.getImage() %>" alt="Silkpattu">
             <center><p><b>₹<%= user.getPrice() %></b></p></center>
             <input type="button" value="Description" onclick="window.location.href='desc.html';">
             <input type="button" value="BuyNow" onclick="window.location.href='book.html';">
        </div>
    <%
            }
        } else {
    %>
        <p>No records</p>
    <%
        }
    %>
</section>

<div style="text-align: center;">
    <a href="<%= request.getContextPath() %>/home1.html">back</a> 
    <a href="<%= request.getContextPath() %>/next1.html">next</a>
</div>

<footer class="footer">
    <p>&copy; 2025 Subree Fashions. All rights reserved.</p>
    <p>Designed with ❤️ by Subree Team</p>
</footer>
</body>
</html>
