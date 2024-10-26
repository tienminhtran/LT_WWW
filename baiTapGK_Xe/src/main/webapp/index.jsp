<%@ page import="vn.edu.iuh.fit.entities.Xe" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<%
    List<Xe> dsXe = (List<Xe>) request.getAttribute("dsXe");
//    if (dsXe == null) {
//        response.sendRedirect("controller?action=getDsXe");
//    }
%>
<div class="container">
    <h1 class="text-center">CỦA HÀNG BÁN XE GẮN MÁY ABC</h1>
    <a href="danhSachXe.jsp">Danh sách xe</a> <span>|</span>
    <a href="controller?action=addXe">Thêm xe</a>
    <form action="controller" method="get">
        <input type="hidden" name="action" value="getXeByName">
        <div style="text-align: right">
            <input type="text" name="searchValue" id="searchValue" class=""
                   style="margin-left:100px">
            <button type="submit" class="btn btn-primary mt-2">Tìm kiếm</button>
        </div>
    </form>
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
            if (dsXe != null && !dsXe.isEmpty()) {
                for (Xe xe : dsXe) {
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
            <td>
                <a href="controller?action=suaXe&id=<%=xe.getId()%>" class="btn btn-primary">Sửa</a>
            </td>
            <td>
                <a href="controller?action=xoaXe&id=<%=xe.getId()%>" class="btn btn-primary">Xóa</a>
            </td>
        </tr>
        <%
            }
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
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>