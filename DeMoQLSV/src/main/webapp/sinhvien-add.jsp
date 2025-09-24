<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.demoqlsv.dao.LopDao" %>
<%@ page import="vn.edu.iuh.fit.demoqlsv.model.Lop" %>

<%
  LopDao lopDao = new LopDao();
  List<Lop> dsLop = lopDao.findAll();
%>

<h2>Thêm sinh viên</h2>
<form action="sinhvien" method="post">
  <input type="hidden" name="action" value="add" />
  MSSV: <input type="text" name="mssv" /><br/>
  Họ tên: <input type="text" name="hoten" /><br/>
  Ngày sinh: <input type="date" name="ngaysinh" /><br/>
  Điểm: <input type="number" step="0.1" name="diem" /><br/>

  Lớp:
  <select name="malop">
    <% for (Lop l : dsLop) { %>
    <option value="<%= l.getMalop() %>"><%= l.getTenlop() %></option>
    <% } %>
  </select><br/>

  <button type="submit">Thêm sinh viên</button>
</form>
