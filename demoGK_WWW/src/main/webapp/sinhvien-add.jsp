<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/19/2025
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="sinhvien" METHOD="post">
    <input type="hidden" name="action" value="add" />

    MSSV: <input type="text" name="mssv" /><br/>
    Họ tên: <input type="text" name="hoten" /><br/>
    Ngày sinh: <input type="date" name="ngaysinh" /><br/>
    Điểm: <input type="number" step="0.1" name="diem" /><br/>
    Mã lớp: <input type="text" name="malop" /><br/>
    <button type="submit">Thêm sinh viên</button>
</form>