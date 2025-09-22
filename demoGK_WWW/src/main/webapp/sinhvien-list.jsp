<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/14/2025
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.demogk_www.model.SinhVien" %>
<%@ page import="vn.edu.iuh.fit.demogk_www.model.Lop" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

  <table>
    <tr>
      <th>MSSV</th>
      <th>Ho ten</th>
      <th>Ngaysinh</th>
      <th>Diem</th>
      <th>Lop</th>
      <th>XOA</th>
      <TH>SUA</TH>
    </tr>


    <%
      List<SinhVien> ds = (List<SinhVien>) request.getAttribute("sinhviens");
      if(ds != null){
          for(SinhVien sv : ds){
    %>

      <tr>
        <td>
          <%=sv.getMssv()%>
        </td>
        <td>
          <%=sv.getHoten()%>
        </td>
        <td>
            <%=sv.getNgaysinh()%>
        </td>
        <td>
            <%=sv.getDiem()%>
        </td>
        <td>
            <%=sv.getLop().getTenlop()%>
        </td>

        <td>
          <form action="sinhvien" method="post">
            <input type="hidden" name="action" value="delete"/>
            <input type="hidden" name="mssv" value="<%= sv.getMssv() %>"/>
            <button type="submit">XÓA</button>
          </form>
        </td>

        <td>
          <a  href="sinhvien?action=edit&mssv=<%= sv.getMssv() %>             " > SUA</a>
        </td>
      </tr>

  <%
      }
    }
  %>




  </table>










</body>
</html>
