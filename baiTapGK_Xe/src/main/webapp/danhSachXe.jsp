<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entities.Xe" %><%--
  Created by IntelliJ IDEA.
  User: Tran Hien Vinh
  Date: 24/10/2024
  Time: 08:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <table class="table table-bordered mt-3">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên xe</th>
            <th>Giá</th>
            <th>Năm sản xuất</th>
            <th>Hãng xe</th>
        </tr>
        </thead>
        <tbody>
        <%
            Xe xe = (Xe) request.getAttribute("dsXe");
            if (xe != null) {
        %>
        <tr>
            <td><%=xe.getId()%>
            </td>
            <td><%=xe.getTenxe()%>
            </td>
            <td><%=xe.getGiaxe()%>
            </td>
            <td><%=xe.getNamsanxuat()%>
            </td>
            <td><%=xe.getMahangxe().getTenhang()%>
            </td>
        </tr>
        <%
        } else {
        %>
        <!-- Nếu không có thuốc, hiển thị thông báo -->
        <tr>
            <td colspan="4" class="text-center">Không có xe nào trong danh sách.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <a href="controller?action=getDsXe">Quay lại</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
