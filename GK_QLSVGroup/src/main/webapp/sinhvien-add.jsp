<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Thêm sinh viên</title></head>
<body>
<h2>Thêm sinh viên</h2>

<form action="sinhvien" method="post">
  <input type="hidden" name="_method" value="add">
  MSSV: <input type="text" name="mssv" required><br>
  Họ tên: <input type="text" name="hoten" required><br>
  Ngày sinh: <input type="date" name="ngaysinh" required><br>
  Điểm: <input type="number" step="0.01" name="diem" required><br>
  Mã lớp: <input type="text" name="malop" required><br><br>
  <button type="submit">Thêm sinh viên</button>
</form>

<a href="sinhvien">Quay lại danh sách</a>
</body>
</html>
