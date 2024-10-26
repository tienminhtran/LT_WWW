<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.on_gk.entity.Xe" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Cửa hàng bán xe</title>
</head>
<body>

<%
  List<Xe> dsXe = (List<Xe>) session.getAttribute("dsXe");

  if(dsXe == null){
    response.sendRedirect("controller?action=getDsXe");
  }


%>

<h1>CỬA HÀNG BÁN XE GẮN MÁY ABC</h1>

<a href="controller?action=getDsXe">Danh sách xe</a>
<a href="controller?action=themxe">Thêm xe</a>

<!--    TÌM KIẾM-->
<form method="post" action="controller?action=timkiem">
  <input type="text" name="search" placeholder="Nhập từ khóa tìm kiếm">
  <button type="submit">Tìm kiếm</button>
</form>

<!--    table-->
<table>
  <tr>
    <th>Mã xe</th>
    <th>Tên xe</th>
    <th>Giá xe</th>
    <th>Năm sản xuất</th>
    <th>Hãng xe</th>
    <th>Chức năng</th>
  </tr>

  <%
    if (dsXe !=null){
      for (Xe xe : dsXe) {
  %>
  <tr>
    <td><%= xe.getMaXe() %></td>
    <td><%= xe.getTenXe() %></td>
    <td><%= xe.getGiaXe() %></td>
    <td><%= xe.getNamSX() %></td>
    <td><%= xe.getMaHangXe().getTenHangXe() %></td>
    <td>
      <a href="controller?action=suaxe&maXe=<%=xe.getMaXe() %>">Sua</a>
    </td>
  </tr>

  <%
    } } else {
  %>
  <tr>
    <td>
      Không có danh sách xe
    </td>
  </tr>

  <%
    }
  %>
</table>

</body>
</html>
