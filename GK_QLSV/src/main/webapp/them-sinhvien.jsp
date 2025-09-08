<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
<h2>Thêm sinh viên</h2>


<%--THUỘC TÍNH NAME RẤT QUAN TRỌNG BẮT BUỘC CÓ--%>

<form action="them-sinhvien" method="post">
    <div class="mb-3">
        MSSV
        <input type="text"  name="mssv"  required>
    </div>
    <div class="mb-3">
        Họ tên
        <input type="text"  name="hoten"  required>
    </div>
    <div class="mb-3">
        Ngày sinh
        <input type="date"  name="ngaysinh"  required>
    </div>
    <div class="mb-3">
        Điểm
        <input type="number"  name="diem" required>
    </div>
    <div class="mb-3">
       Mã lớp
        <input type="text"  name="malop"  required>
    </div>
    <button type="submit" class="btn btn-primary">Thêm sinh viên</button>
</form>

<a href="index.jsp" >Quay lại trang chính</a>
</body>
</html>
