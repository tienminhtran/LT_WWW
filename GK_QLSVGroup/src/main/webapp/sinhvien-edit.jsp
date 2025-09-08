<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Sửa sinh viên</title></head>
<body>
<h2>Sửa sinh viên</h2>

<c:if test="${not empty error}">
  <div style="color:red">${error}</div>
</c:if>

<form action="sinhvien" method="post">
  <input type="hidden" name="_method" value="update">
  MSSV: <input type="text" name="mssv" value="${sv.mssv}" readonly><br>
  Họ tên: <input type="text" name="hoten" value="${sv.hoten}" required><br>
  Ngày sinh: <input type="date" name="ngaysinh" value="${sv.ngaysinh}" required><br>
  Điểm: <input type="number" step="0.01" name="diem" value="${sv.diem}" required><br>
  Mã lớp: <input type="text" name="malop" value="${sv.lop.malop}" required><br><br>
  <button type="submit">Cập nhật</button>
</form>

<a href="sinhvien">Quay lại danh sách</a>
</body>
</html>
