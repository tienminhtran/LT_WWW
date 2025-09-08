<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Danh sách sinh viên</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2>Danh sách sinh viên</h2>

<table class="table table-bordered table-striped">
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
        <form action="sinhvien" method="post" style="display:inline;">
          <input type="hidden" name="_method" value="delete">
          <input type="hidden" name="mssv" value="${sv.mssv}">
          <button type="submit" class="btn btn-danger btn-sm"
                  onclick="return confirm('Bạn có chắc chắn muốn xóa sinh viên này?');">
            Xóa
          </button>
        </form>
        <a href="sinhvien?action=edit&mssv=${sv.mssv}" class="btn btn-warning btn-sm">Sửa</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<a href="index.jsp" class="btn btn-primary">Quay lại trang chính</a>
<a href="sinhvien-add.jsp" class="btn btn-success">Thêm sinh viên</a>

</body>
</html>
