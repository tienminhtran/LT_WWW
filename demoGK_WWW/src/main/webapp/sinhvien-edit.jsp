<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/19/2025
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.demogk_www.model.SinhVien" %>
<%@ page import="vn.edu.iuh.fit.demogk_www.model.Lop" %>
<%

    SinhVien sv = (SinhVien) request.getAttribute("sv");
%>

<form action="sinhvien" METHOD="post">
    <input type="hidden" name="action" value="update" />

    MSSV: <input type="text" name="mssv"   value="<%= sv.getMssv()%>"  readonly2003/><br/>
    Họ tên: <input type="text" name="hoten"  value="<%= sv.getHoten() %>" /><br/>
    Ngày sinh: <input type="date" name="ngaysinh"  value="<%= sv.getNgaysinh()%>"/><br/>
    Điểm: <input type="number" step="0.1" name="diem" value="<%= sv.getDiem()%>" /><br/>
    Mã lớp: <input type="text" name="malop"  value="<%= sv.getLop().getMalop()%>" /><br/>
    <button type="submit">LƯU</button>
</form>