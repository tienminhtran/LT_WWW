<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/9/2024
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello</h1>

    <form action="controller" method="post">
        <input type="hidden" name="action" value="add">
        <table>
            <tr>
                <td>name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>0
                <td>description</td>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <td>img</td>
                <td><input type="text" name="img"></td>
            </tr>
            <tr>
                <td><input type="submit" value="add"></td>
            </tr>
        </table>
    </form>
</body>
</html>
