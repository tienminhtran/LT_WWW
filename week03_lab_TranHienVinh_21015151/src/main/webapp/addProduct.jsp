<%--
  Created by IntelliJ IDEA.
  User: Tran Hien Vinh
  Date: 02/10/2024
  Time: 05:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container bg-info w-50">
  <h2 class="h2 text-center">ADD PRODUCT</h2>
  <form action="controller" method="post">
    <input type="hidden" name="action" value="add">
    <div class="mb-3">
      <label for="name" class="form-label">Name:</label>
      <input type="text" class="form-control" name="name" placeholder="Name" id="name">
    </div>
    <div class="mb-3">
      <label for="description" class="form-label">Description:</label>
      <input type="text" class="form-control" name="description" placeholder="Description" id="description">
    </div>
    <div class="mb-3">
      <label for="name" class="form-label">Img path:</label>
      <input type="text" class="form-control" name="img" placeholder="Img path" id="img">
    </div>
    <div class="d-grid">
      <input type="submit" class="btn btn-primary btn-block" value="Submit">
    </div>
    <div class="d-grid pt-2 pb-2">
      <input type="reset" class="btn btn-primary btn-block" value="Reset">
    </div>
    <div class="d-grid pt-2 pb-2">
      <a href="index.jsp" class="btn btn-primary btn-block">Back To Home</a>
    </div>
  </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
