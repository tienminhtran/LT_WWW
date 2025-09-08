<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sửa sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2>Sửa thông tin sinh viên</h2>

<c:if test="${not empty error}">
    <div class="alert alert-danger">${error}</div>
</c:if>

<form action="sua-sinhvien" method="post">
    <input type="hidden" name="mssv" value="${sv.mssv}" />
    <div class="mb-3">
        <label>Họ tên</label>
        <input type="text" name="hoten" class="form-control" value="${sv.hoten}" required />
    </div>
    <div class="mb-3">
        <label>Ngày sinh</label>
        <input type="date" name="ngaysinh" class="form-control" value="${sv.ngaysinh}" required />
    </div>
    <div class="mb-3">
        <label>Điểm</label>
        <input type="number" step="0.01" name="diem" class="form-control" value="${sv.diem}" required />
    </div>
    <div class="mb-3">
        <label>Lớp</label>
        <select name="malop" class="form-control">
            <c:forEach var="lop" items="${lops}">
                <option value="${lop.malop}"
                        <c:if test="${lop.malop == sv.lop.malop}">selected</c:if>
                >${lop.tenlop}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Cập nhật</button>
    <a href="danh-sach-sinh-vien" class="btn btn-secondary">Quay lại</a>
</form>

</body>
</html>
