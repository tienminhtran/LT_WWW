<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách lớp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
<h2>Danh sách lớp</h2>

<table >
    <thead>
    <tr>
        <th>Mã lớp</th>
        <th>Tên lớp</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="lop" items="${lops}">
        <tr>
            <td>${lop.malop}</td>
            <td>${lop.tenlop}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="index.jsp" class="btn btn-secondary mt-3">Quay lại trang chính</a>
</body>
</html>
