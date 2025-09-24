<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.demoqlsv.model.SinhVien" %>
<%@ page import="vn.edu.iuh.fit.demoqlsv.model.Lop" %>
<!DOCTYPE html>
<html>
<head>
  <title>Danh sách SV</title>
</head>
<body>
<h1>Danh sách sinh viên</h1>

<!-- Form tìm kiếm -->
<form action="sinhvien" method="get">
  <input type="hidden" name="action" value="find"/>
  <input type="text" name="mssv" placeholder="Nhập MSSV cần tìm"/>
  <button type="submit">Tìm</button>
</form>



        <!-- Form tìm kiếm -->
<form action="sinhvien" method="get">
  <input type="hidden" name="action" value="find"/>
  <input type="text" name="name" placeholder="Nhập tên sinh viên cần tìm"/>
  <button type="submit">Tìm</button>
</form>

<!-- Form tìm theo điểm -->
<form action="sinhvien" method="get" style="text-align: right">
  <input type="hidden" name="action" value="findByDiem"/>
  Từ: <input type="text" name="min" placeholder="Điểm min"/>
  Đến: <input type="text" name="max" placeholder="Điểm max"/>
  <button type="submit">Tìm</button>
</form>


<a href="sinhvien" >Trả lại danh sách</a>
<hr>


<% String error = (String) request.getAttribute("error"); %>
<% if (error != null) { %>
<p style="color:red"><%= error %></p>
<% } %>

<table border="1" cellspacing="0" cellpadding="5"        style="margin: 0 auto; width: 80%; text-align: center; border-collapse: collapse;">
<tr>
    <th>MSSV</th>
    <th>Họ tên</th>
    <th>Ngày sinh</th>
    <th>Điểm</th>
    <th>Lớp</th>
    <th>XÓA</th>
    <th>EDIT</th>
  </tr>

  <%
    SinhVien sv = (SinhVien) request.getAttribute("sv");
    List<SinhVien> ds = (List<SinhVien>) request.getAttribute("sinhviens");

    if (sv != null) {
  %>
  <tr>
    <td><%= sv.getMssv() %></td>
    <td><%= sv.getHoten() %></td>
    <td><%= sv.getNgaysinh() %></td>
    <td><%= sv.getDiem() %></td>
    <td><%= sv.getLop().getTenlop() %></td>
    <td>
      <form action="sinhvien" method="post" style="display:inline;">
        <input type="hidden" name="action" value="delete"/>
        <input type="hidden" name="mssv" value="<%= sv.getMssv() %>"/>
        <button type="submit">XÓA</button>
      </form>
    </td>
    <td>
      <a href="sinhvien?action=edit&mssv=<%= sv.getMssv() %>">Cập nhật</a>
    </td>
  </tr>
  <%
  } else if (ds != null) {
    for (SinhVien s : ds) {
  %>
  <tr>
    <td><%= s.getMssv() %></td>
    <td><%= s.getHoten() %></td>
    <td><%= s.getNgaysinh() %></td>
    <td><%= s.getDiem() %></td>
    <td><%= s.getLop().getTenlop() %></td>
    <td>
      <form action="sinhvien" method="post" style="display:inline;">
        <input type="hidden" name="action" value="delete"/>
        <input type="hidden" name="mssv" value="<%= s.getMssv() %>"/>
        <button type="submit">XÓA</button>
      </form>
    </td>
    <td>
      <a href="sinhvien?action=edit&mssv=<%= s.getMssv() %>">Cập nhật</a>
    </td>
  </tr>
  <%
      }
    }
  %>
</table>
</body>
</html>

<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--  <title>Danh sách SV</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Danh sách sinh viên</h1>--%>

<%--<!-- Form tìm kiếm -->--%>
<%--<form action="sinhvien" method="get">--%>
<%--  <input type="hidden" name="action" value="find"/>--%>
<%--  <input type="text" name="mssv" placeholder="Nhập MSSV cần tìm"/>--%>
<%--  <button type="submit">Tìm</button>--%>
<%--</form>--%>

<%--<form action="sinhvien" method="get">--%>
<%--  <input type="hidden" name="action" value="find"/>--%>
<%--  <input type="text" name="name" placeholder="Nhập tên sinh viên cần tìm"/>--%>
<%--  <button type="submit">Tìm</button>--%>
<%--</form>--%>

<%--<form action="sinhvien" method="get">--%>
<%--  <input type="hidden" name="action" value="findByDiem"/>--%>
<%--  Từ: <input type="text" name="min" placeholder="Điểm min"/>--%>
<%--  Đến: <input type="text" name="max" placeholder="Điểm max"/>--%>
<%--  <button type="submit">Tìm</button>--%>
<%--</form>--%>

<%--<a href="sinhvien" >Trả lại danh sách</a>--%>

<%--<c:if test="${not empty error}">--%>
<%--  <p style="color:red">${error}</p>--%>
<%--</c:if>--%>

<%--<table border="1" cellspacing="0" cellpadding="5">--%>
<%--  <tr>--%>
<%--    <th>MSSV</th>--%>
<%--    <th>Họ tên</th>--%>
<%--    <th>Ngày sinh</th>--%>
<%--    <th>Điểm</th>--%>
<%--    <th>Lớp</th>--%>
<%--    <th>XÓA</th>--%>
<%--    <th>EDIT</th>--%>
<%--  </tr>--%>

<%--  <!-- Nếu chỉ tìm ra 1 sv -->--%>
<%--  <c:if test="${not empty sv}">--%>
<%--    <tr>--%>
<%--      <td>${sv.mssv}</td>--%>
<%--      <td>${sv.hoten}</td>--%>
<%--      <td>${sv.ngaysinh}</td>--%>
<%--      <td>${sv.diem}</td>--%>
<%--      <td>${sv.lop.tenlop}</td>--%>
<%--      <td>--%>
<%--        <form action="sinhvien" method="post" style="display:inline;">--%>
<%--          <input type="hidden" name="action" value="delete"/>--%>
<%--          <input type="hidden" name="mssv" value="${sv.mssv}"/>--%>
<%--          <button type="submit">XÓA</button>--%>
<%--        </form>--%>
<%--      </td>--%>
<%--      <td><a href="sinhvien?action=edit&mssv=${sv.mssv}">Cập nhật</a></td>--%>
<%--    </tr>--%>
<%--  </c:if>--%>

<%--  <!-- Nếu có danh sách nhiều sv -->--%>
<%--  <c:forEach var="s" items="${sinhviens}">--%>
<%--    <tr>--%>
<%--      <td>${s.mssv}</td>--%>
<%--      <td>${s.hoten}</td>--%>
<%--      <td>${s.ngaysinh}</td>--%>
<%--      <td>${s.diem}</td>--%>
<%--      <td>${s.lop.tenlop}</td>--%>
<%--      <td>--%>
<%--        <form action="sinhvien" method="post" style="display:inline;">--%>
<%--          <input type="hidden" name="action" value="delete"/>--%>
<%--          <input type="hidden" name="mssv" value="${s.mssv}"/>--%>
<%--          <button type="submit">XÓA</button>--%>
<%--        </form>--%>
<%--      </td>--%>
<%--      <td><a href="sinhvien?action=edit&mssv=${s.mssv}">Cập nhật</a></td>--%>
<%--    </tr>--%>
<%--  </c:forEach>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>
