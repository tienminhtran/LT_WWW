<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Danh sách sinh viên</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
<h2>Danh sách sinh viên</h2>
<form action="danh-sach-sinh-vien" method="get" class="mb-3">
  <label>Điểm từ: <input name="minDiem" /></label>
    <br>
  <label>đến: <input  name="maxDiem" /></label>
  <br>
  <button type="submit" class="btn btn-primary">Tìm</button>
</form>

<table >
  <thead>
  <tr>
    <th>MSSV</th>
    <th>Họ tên</th>
    <th>Ngày sinh</th>
    <th>Điểm</th>
    <th>Lớp</th>
    <th>Hành động</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="sv" items="${sinhviens}">
    <tr>
      <td>${sv.mssv}</td>
      <td>${sv.hoten}</td>
      <td>${sv.ngaysinh}</td>
      <td>${sv.diem}</td>
      <td>${sv.lop.tenlop}</td>
      <td>
        <a href="danh-sach-sinh-vien?action=delete&mssv=${sv.mssv}"
           onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</a>

        <a href="sua-sinhvien?mssv=${sv.mssv}" >Sửa</a>

      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<a href="index.jsp">Quay lại trang chính</a>
</body>
</html>
