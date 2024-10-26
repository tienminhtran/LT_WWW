 <%@ page import="vn.edu.iuh.fit.entities.Xe" %>
<%@ page import="vn.edu.iuh.fit.dtos.XeDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Dashboard</title>
</head>
<body>
<%
    List<XeDTO> dsXe = (List<XeDTO>) session.getAttribute("xeDTOs");
    if(dsXe == null){
        response.sendRedirect("controller?action=dsXe");
    }
%>
<div class="container">
    <h1 class="text-center mt-4">CỬA HÀNG BÁN XE GÁN MÁY ABC</h1>

    <div class="row">
        <div class="d-flex justify-content-start mb-3">
            <a href="controller?action=dsXe" class="btn btn-primary me-3">Quản lý xe</a>
            <a href="controller?action=themXe" class="btn btn-warning">Thêm mới xe</a>
        </div>
    </div>


    <div class="row justify-content-end mb-3">
        <form action="controller" method="post">
            <input type="hidden" name="action" value="timKiem">
            <div class="input-group">
                <input type="text" class="form-control" name="tenTimKiem" placeholder="Nhập tên xe cần tìm">
                <button class="btn btn-outline-secondary" type="submit">Tìm kiếm</button>
            </div>
        </form>
    </div>
    <%
        if(dsXe != null) {
    %>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Mã xe</th>
            <th>Tên xe</th>
            <th>Giá bán</th>
            <th>Năm SX</th>
            <th>Hãng xe</th>
            <th>Action</th>

        </tr>
        </thead>
        <tbody>
        <%
            for(XeDTO xe : dsXe){
        %>
            <tr>
                <td><%=xe.getMaXe()%></td>
                <td><%=xe.getTenXe()%></td>
                <td><%=xe.getGiaXe()%></td>
                <td><%=xe.getNamSX()%></td>
                <td><%=xe.getHangXe()%></td>
                <td>
                    <a href="controller?action=suaXe&maXe=<%=xe.getMaXe()%>" class="btn btn-warning me-3">Sửa</a>
                    <a href="controller?action=xoaXe&maXe=<%=xe.getMaXe()%>" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
    <h3 class="text-center">Không có dữ liệu</h3>
    <% }%>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
</script>
</body>
</html>