<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
  <title>Thêm thuốc</title>
</head>
<body>
<h2>Thêm thuốc mới</h2>

<form action="thuoc?action=insert" method="post">
  Tên thuốc: <input type="text" name="tenThuoc" required><br><br>
  Giá: <input type="number" step="0.01" name="gia" required><br><br>
  Năm NX: <input type="number" name="namNX"><br><br>
  Mã loại: <input type="number" name="maLoai" required><br><br>
  <button type="submit">Lưu</button>
</form>

<br>
<a href="thuoc?action=danhsachthuoc">⬅ Quay lại danh sách</a>

</body>
</html>
