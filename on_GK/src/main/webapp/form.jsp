<%@ page import="vn.edu.iuh.fit.on_gk.entity.HangXe" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.on_gk.entity.Xe" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/10/2024
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FORM</title>
</head>
<%
    String action =request.getParameter("action");
    List<HangXe> hangXeList = (List<HangXe>) session.getAttribute("hangXeList");

    Xe xe = (Xe) session.getAttribute("xe");
    int maXe = xe.getMaXe() == 0 ? 0 : xe.getMaXe();
    String tenXe = xe.getTenXe() == null ? "" : xe.getTenXe();
    double gia = xe.getGiaXe() == 0 ? 0 : xe.getGiaXe();
    String namSX = xe.getNamSX() == null ? "" : xe.getNamSX();
    String maHangXe = xe.getMaHangXe().getMaHangXe() == 0 ? "" : xe.getMaHangXe().getTenHangXe();




%>
<body>
    <form action="controller" method="post">

<%--        // action có thể ghi value = themxe,  ,....... suaxxe--%>
        <input type="hidden" name="action" value="<%=action%>">
        <table>

            <tr>
                <td>Ma xe</td>
                <td>
                    <input type="text" name="maXe" value="<%=maXe%>" >
                </td>
            </tr>
            <tr>
                <td>Ten Xe</td>
                <td>
                    <input type="text" name="tenXe" value="<%=tenXe%>" >
                </td>
            </tr>
<%--            gia--%>
            <tr>
                <td>Gia</td>
                <td>
                    <input type="text" name="gia" value="<%=gia%>">
                </td>
            </tr>
<%--            nam sx--%>
            <tr>
                <td>Nam SX</td>
                <td>
                    <input type="text" name="namSX" value="<%=namSX%>">
                </td>
            </tr>
            <tr>
                <td>Hang Xe</td>
                <td>
                    <select name="hangXe">
                        <%
                            for (HangXe hangXe : hangXeList) {
                                String selected = hangXe.getTenHangXe().equals(hangXe) ? "selected" : "";
                        %>

                        <option value="<%=hangXe.getMaHangXe()%>" <%=selected%>><%=hangXe.getTenHangXe()%></option>

                        <%
                            }
                        %>
                    </select>
                </td>

            </tr>
            <tr>
                <td>
                    <input type="submit" value="Them">
                </td>
            </tr>

        </table>
    </form>
</body>
</html>
