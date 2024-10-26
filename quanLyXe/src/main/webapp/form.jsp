<%@ page import="vn.edu.iuh.fit.dtos.XeDTO" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="vn.edu.iuh.fit.entities.HangXe" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: phant
  Date: 10/24/2024
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Form Xe</title>
</head>
<body>
<%
    String action = request.getParameter("action");
    XeDTO xeDTO=(XeDTO) session.getAttribute("xeDTO");
    long maXe = xeDTO.getMaXe() == 0 ? 0 : xeDTO.getMaXe();
    String tenXe = xeDTO.getTenXe() == null ? "" : xeDTO.getTenXe();
    double giaXe = xeDTO.getGiaXe() == 0 ? 0.0 : xeDTO.getGiaXe();
    int namSX = xeDTO.getNamSX() == 0 ? LocalDate.now().getYear() : xeDTO.getNamSX();
    String hangXe = xeDTO.getHangXe() == null ? "" : xeDTO.getHangXe();

    List<HangXe> hangXeList = (List<HangXe>) session.getAttribute("hangXeList");
%>
<div class="container">
    <h1 class="text-center">Form Xe</h1>
    <form action="controller" method="post">
        <input type="hidden" name="action" value="<%=action%>">
        <div class="mb-2">
            <label for="maXe" class="form-label">Ma Xe</label>
            <input type="text" class="form-control" id="maXe" name="maXe" value="<%=maXe%>" required>
        </div>
        <div class="mb-2">
            <label for="tenXe" class="form-label">Ten Xe</label>
            <input type="text" class="form-control" id="tenXe" name="tenXe" value="<%=tenXe%>" required>
        </div>
        <div class="mb-2">
            <label for="giaXe" class="form-label">Gia Xe</label>
            <input type="text" class="form-control" id="giaXe" name="giaXe" value="<%=giaXe%>" required>
        </div>
        <div class="mb-2">
            <label for="namSX" class="form-label">Nam Sx</label>
            <input type="text" class="form-control" id="namSX" name="namSX" value="<%=namSX%>" required>
        </div>
        <div class="mb-2">
            <label for="hangXe" class="form-label">Hang xe</label>
            <select class="form-select" id="hangXe" name="hangXe">
                <%
                    for (HangXe hxe: hangXeList) {
                        String selected = hxe.getTenHangXe().equals(hangXe) ? "selected" : "";
                %>
                <option value="<%=hxe.getTenHangXe()%>" <%=selected%>><%=hxe.getTenHangXe()%></option>
                <%
                    }
                %>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
        <a href="controller?action=dsXe" class="btn btn-danger">Cancel</a>
    </form>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
</script>
</body>
</html>
