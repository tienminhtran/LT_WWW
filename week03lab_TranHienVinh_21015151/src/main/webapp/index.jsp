<%--
  Created by IntelliJ IDEA.
  User: Tran Hien Vinh
  Date: 02/10/2024
  Time: 05:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.week03_lab.backend.repositories.entities.Product" %>
<%
//    List<Product> products = (List<Product>) request.getAttribute("products");
//
//    if (products == null) {
//        response.sendRedirect("controller"); // Chuyển hướng đến controller nếu sản phẩm không tồn tại
//    }
%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<div class="container-fluid bg-info">
    <h2 class="h2 text-center">HOME</h2>
    <a href="addProduct.jsp" class="btn btn-primary">Add Product</a>
<%--    &lt;%&ndash;    Form tìm kiếm product &ndash;%&gt;--%>
<%--    <form action="controller" method="get" class="mb-4">--%>
<%--        <input type="hidden" name="action" value="search">--%>
<%--        <input type="text" name="id" placeholder="Tìm kiếm sản phẩm..." class="form-control"--%>
<%--               required>--%>
<%--        <button type="submit" class="btn btn-primary mt-2">Tìm kiếm</button>--%>
<%--    </form>--%>
<%--    &lt;%&ndash; Hiển thị danh sách sản phẩm hoặc sản phẩm tìm kiếm &ndash;%&gt;--%>
<%--    <c:choose>--%>
<%--        <c:when test="${not empty product}">--%>
<%--            <div class="card" style="width: 18rem; margin-top: 20px;">--%>
<%--                <img src="${product.imgPath}" class="card-img-top" alt="${product.name}">--%>
<%--                <div class="card-body">--%>
<%--                    <h5 class="card-title">${product.name}</h5>--%>
<%--                    <p class="card-text">${product.description}</p>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </c:when>--%>
<%--        <c:when test="${not empty products}">--%>
<%--            <div class="row">--%>
<%--                <c:forEach var="prod" items="${products}">--%>
<%--                    <div class="card" style="width: 18rem; margin-bottom: 20px">--%>
<%--                        <img src="${prod.imgPath}" class="card-img-top" alt="${prod.name}">--%>
<%--                        <div class="card-body">--%>
<%--                            <h5 class="card-title">${prod.name}</h5>--%>
<%--                            <p class="card-text">${prod.description}</p>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>
<%--            </div>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <p>Không có sản phẩm nào để hiển thị</p>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>
    <form action="controller" method="GET">
        <button type="submit" class="btn btn-success">Danh sách sản phẩm</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
