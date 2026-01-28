<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.flm.dto.Busdetailsdto" %>
<!DOCTYPE html>
<html>
<head>
    <title>Seats</title>
    <style>
        .seat-grid {
            display: grid;
            grid-template-columns: repeat(5, 80px);
            grid-gap: 10px;
            padding: 20px;
        }
        .seat {
            width: 80px;
            height: 80px;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 10px;
            text-align: center;
            line-height: 80px;
            cursor: pointer;
        }
		.seat.margin-right {
		    margin-right: 40px; /* or adjust as needed */
		}
    </style>
</head>
<body>
    <h2>Seats Available</h2>

    <%
        Busdetailsdto list = (Busdetailsdto) request.getAttribute("bd");
        if (list != null) {
    %>

    <h2>Bus Seat Layout</h2>
    <p>BusId : <%= list.getBusid() %></p><br/>

    <div class="seat-grid">
        <%
		int seatstot=25;
            int rem = seatstot - list.getVaccancies();
			System.out.println(rem);
			System.out.println(list.getVaccancies());
            for (int i = 1; i <= seatstot; i++) {
                if (i <= rem) {
        %>
            <div class="seat" style="background-color:red;"><%= i %></div>
        <%
                } else {
        %>
            <div class="seat" style="background-color:green;"><%= i %></div>
        <%
                }
            }
        %>
    </div>

    <%
        } else {
    %>
        <p>No bus found.</p>
    <%
        }
    %>
<a href="savejournpage">Bookpage</a><br>
    <a href="buspage">BusPage</a><br>
    <a href="homepage">HomePage</a>
</body>
</html>
