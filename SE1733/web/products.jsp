<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%@ page import="model.Category" %>
<%@ page import="dao.CategoryDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Showcase</title>
    <link rel="stylesheet"  href="css/product.css"> 
</head>
<body>
    <div id="header">
        <div id="logo">
            <img src="images/logo.png" alt="Logo">
        </div>
        <div id="navigation">
            <button onclick="location.href='login.jsp'">Login</button>
            <button onclick="location.href='register.jsp'">Register</button>
            <form action="search.jsp" method="get">
                <input type="text" name="query" placeholder="Search...">
                <input type="submit" value="Search">
            </form>
        </div>
    </div>

    <div id="categories">
        <h2>Categories</h2>
        <ul>
            <% 
                CategoryDAO categoryDAO = new CategoryDAO();
                List<Category> categories = categoryDAO.getAll();
                for (Category category : categories) {
            %>
                <li><a href="<%= "category.jsp?id=" + category.getId() %>"><%= category.getName() %></a></li>
            <% } %>
        </ul>
    </div>

    <div id="filters">
    <div id="price-filter">
        <h2>Price Range:</h2>
        <form action="filter.jsp" method="post">
            <input type="checkbox" name="priceFilter" value="0-1300"> $0 - $1300
            <input type="checkbox" name="priceFilter" value="1300-2000"> $1300 - $2000
            <!-- Add more price range checkboxes as needed -->
        </form>
    </div>

    <div id="category-filter">
        <h2>Categories:</h2>
        <form action="filter.jsp" method="post">
            <% for (Category category : categories) { %>
                <input type="checkbox" name="categoryFilter" value="<%= category.getId() %>"> <%= category.getName() %><br>
            <% } %>
        </form>
    </div>

    <input type="submit" value="Apply Filters">
</div>

    <div id="product-list">
        <h2>Product List</h2>
        <div id="products">
            <%
                List<Product> products = (List<Product>) request.getAttribute("data");
                for (Product product : products) {
            %>
                <div class="product">
                    <img src="<%= product.getImage() %>" alt="<%= product.getName() %>">
                    <h3><%= product.getName() %></h3>
                    <p>Price: $<%= product.getPrice() %></p>
                </div>
            <% } %>
        </div>
    </div>
</body>
</html>
