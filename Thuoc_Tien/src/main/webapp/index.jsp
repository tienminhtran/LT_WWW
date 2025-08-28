<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang chủ</title>
</head>
<body>
<h2>Trang chủ</h2>
<table border="1" cellpadding="5">

        <tr>
            <a href="thuoc?action=danhsachthuoc">Danh sách thuốc</a>
        </tr>
            |
        <tr>
            <a href="thuoc?action=danhsachloaithuoc">Danh sách loại thuốc</a>
        </tr>
            |
        <tr>
            <a href="thuoc?action=add">Thêm thuốc</a>
        </tr>
                |
        <tr>
            <a href="thuoc?action=add">Hiển thị ds thuốc theo loại</a>
        </tr>
</table>
</body>
</html>
