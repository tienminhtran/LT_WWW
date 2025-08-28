<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách thuốc</title>
</head>

<body>

<%--loc--%>
<form method="get" action="thuoc">
    <input type="hidden" name="action" value="filterByLoai"/>
    <label for="maLoai">Lọc theo loại thuốc:</label>
    <select name="maLoai" id="maLoai">
        <option value="">--Chọn loại thuốc--</option>
        <c:forEach var="loai" items="${dsLoaiThuoc}">
            <option value="${loai.maLoai}">${loai.tenLoai}</option>
        </c:forEach>
    </select>
    <button type="submit">Lọc</button>
</form>


<h2>Danh sách thuốc</h2>

<a href="thuoc?action=add"> Thêm thuốc mới</a>
<br><br>


<c:if test="${not empty sessionScope.msg}">
    <p style="color: green;">${sessionScope.msg}</p>
    <c:remove var="msg" scope="session"/>
</c:if>


<table border="1" cellpadding="1">
    <tr>
        <th>Mã</th>
        <th>Tên thuốc</th>
        <th>Giá</th>
        <th>Năm NX</th>
        <th>Mã loại</th>
    </tr>
    <c:forEach var="t" items="${dsThuoc}">
        <tr>
            <td>${t.maThuoc}</td>
            <td>${t.tenThuoc}</td>
            <td>${t.gia}</td>
            <td>${t.namNX}</td>
            <td>${t.maLoai}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
