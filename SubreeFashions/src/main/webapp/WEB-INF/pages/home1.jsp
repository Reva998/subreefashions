<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home page</title>
    <link rel="stylesheet" href="fashion.css">
</head>
<body>
    <section class="fas">
        <nav>
            <ul>
                <li><img src="${pageContext.request.contextPath}/images/logo.webp" alt="logo"></li>
                <li><a href="home1">Home</a></li>
                <li><a href="coll">Collections</a></li>
                <li><a href="subreesarees">About us</a></li>
                <li><a href="contact">Contact</a></li>
            </ul>
        </nav>
        <img src="${pageContext.request.contextPath}/images/ban2.jpg" alt="banner">
    </section>

    <section class="fas2">
        <c:forEach var="item" items="${categories}">
            <a href="coll">
                <div class="menu">
                    <img src="${pageContext.request.contextPath}/images/${item.image}" alt="${item.name}">
                    <p>${item.name}</p>
                </div>
            </a>
        </c:forEach>
    </section>

    <div style="font-family: 'Times New Roman', Times, serif; margin: 2%;">
        <h3>Top Brands</h3><br>
        <h2>Unbeatable Offers await's</h2>
    </div>

    <section class="fas3">
        <c:forEach var="brand" items="${topBrands}">
            <a href="coll">
                <div class="menu1">
                    <img src="${pageContext.request.contextPath}/images/${brand}" alt="Brand">
                </div>
            </a>
        </c:forEach>
    </section>

    <div style="font-family: Arial, Helvetica, sans-serif; margin: 2%; padding: 1%;">
        <h3>Top Categories on Offer</h3><br>
        <h2>Deals you don't want to miss</h2>
    </div>

    <section class="fas4">
        <c:forEach var="deal" items="${deals}">
            <a href="coll">
                <div class="menu2">
                    <img src="${pageContext.request.contextPath}/images/${deal}" alt="Deal">
                </div>
            </a>
        </c:forEach>
    </section>

    <section class="fas5">
        <c:forEach var="feat" items="${featured}">
            <a href="coll">
                <div class="menu6">
                    <img src="${pageContext.request.contextPath}/images/${feat}" alt="Featured">
                </div>
            </a>
        </c:forEach>
    </section>

    <footer class="footer">
        <p>&copy; 2025 Subree Fashions. All rights reserved.</p>
        <p>Designed with ❤️ by Subree Team</p>
    </footer>
</body>
</html>
