<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách loại thuốc</title>
</head>
<body>
<h2>Danh sách loại thuốc</h2>
<br><br>


<%--listbox--%>

<table border="1" cellpadding="5">
    <tr>
        <th>Mã loại</th>
        <th>Tên loại thuốc</th>

    </tr>
    <c:forEach var="t" items="${dsLoaiThuoc}">
        <tr>
            <td>${t.maLoai}</td>
            <td>${t.tenLoai}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
