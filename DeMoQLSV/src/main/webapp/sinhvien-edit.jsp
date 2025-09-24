<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="vn.edu.iuh.fit.demoqlsv.model.SinhVien" %>
<%@ page import="vn.edu.iuh.fit.demoqlsv.model.Lop" %>
<%
  SinhVien sv = (SinhVien) request.getAttribute("sv");
%>
<!DOCTYPE html>
<html>
<head><title>Edit Sinh viên</title></head>
<body>
<h1>Chỉnh sửa sinh viên</h1>
<form action="sinhvien" method="post">
  <input type="hidden" name="action" value="update"/>
  MSSV: <input type="text" name="mssv" value="<%= sv.getMssv() %>" readonly/><br/>
  Họ tên: <input type="text" name="hoten" value="<%= sv.getHoten() %>"/><br/>
  Ngày sinh: <input type="date" name="ngaysinh" value="<%= sv.getNgaysinh() %>"/><br/>
  Điểm: <input type="number" step="0.1" name="diem" value="<%= sv.getDiem() %>"/><br/>
  Mã lớp: <input type="text" name="malop" value="<%= sv.getLop().getMalop() %>"/><br/>
  <button type="submit">Cập nhật</button>
</form>
</body>
</html>
