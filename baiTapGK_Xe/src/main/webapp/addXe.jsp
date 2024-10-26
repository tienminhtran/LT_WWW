<%@ page import="vn.edu.iuh.fit.entities.HangXe" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entities.Xe" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: Tran Hien Vinh
  Date: 24/10/2024
  Time: 08:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Xe</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<%
    String header = "";
    String action = request.getParameter("action");
    if (action.equals("suaXe")) {
        header = "Sửa Xe";
    } else {
        header = "Thêm Xe";
    }
    Xe xe = (Xe) request.getAttribute("xe");
%>
<div class="container">
    <h1 class="text-center"><%=header%></h1>
    <form action="controller" method="post">
        <input type="hidden" name="action" value="<%=action%>">
        <% if (xe != null) { %>
        <input type="hidden" name="id" value="<%= xe.getId() %>">
        <% } %>
        <div class="mb-3">
            <label for="tenxe" class="form-label">Tên xe</label>
            <input type="text" class="form-control" id="tenxe" name="tenxe" value="<%= xe != null ? ((Xe) request.getAttribute("xe")).getTenxe() : "" %>"
                   required>
        </div>
        <div class="mb-3">
            <label for="giaxe" class="form-label">Giá xe</label>
            <input type="text" class="form-control" id="giaxe" name="giaxe" value="<%=xe !=null ? ((Xe) request.getAttribute("xe")).getGiaxe() : ""%>"
                   required>
        </div>
        <div class="mb-3">
            <label for="namsanxuat" class="form-label
            ">Năm sản xuất</label>
            <input type="text" class="form-control" id="namsanxuat" name="namsanxuat"
                   value="<%=xe !=null ? ((Xe) request.getAttribute("xe")).getNamsanxuat() : ""%>" required>
        </div>
        <div class="mb-3">
            <section>
                <label for="mahangxe" class="form-label">Hãng xe</label>
                <select class="form-select" id="mahangxe" name="mahangxe">
                    <%
                        List<HangXe> dsHangXe = (List<HangXe>) request.getAttribute("dsHangXe");
                        if (dsHangXe != null && !dsHangXe.isEmpty()) {
                            for (HangXe hangXe : dsHangXe) {
                                String selected = xe!=null && xe.getMahangxe().getId()==hangXe.getId() ? "selected" : "";
                    %>
                    <option value="<%=hangXe.getId()%>" <%=selected%> ><%=hangXe.getTenhang()%>
                    </option>
                    <%
                            }
                        }
                    %>
                </select>
            </section>
        </div>
        <button type="submit" class="btn btn-primary"><%=header%></button>
        <a href="controller?action=getDsXe" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
