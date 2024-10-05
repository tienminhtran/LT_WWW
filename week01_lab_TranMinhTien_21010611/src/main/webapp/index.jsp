<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Page</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="bg-light d-flex justify-content-center align-items-center vh-100">
<div class="card shadow-sm p-4" style="width: 22rem;">
  <h3 class="text-center mb-4">Login</h3>
  <form action="login" method="post">
    <input type="hidden" name="action" value="login">

    <div class="mb-3">
      <label class="form-label">Account Id:</label>
      <input type="text" class="form-control" id="accountid" name="accountid" required>
    </div>
    <div class="mb-3">
      <label  class="form-label">Password: </label>
      <input type="password" class="form-control" id="password" name="password" required>
    </div>
    <div class="d-grid mb-3">
      <button type="submit" name="login" value="login" class="btn btn-primary">Login</button>
    </div>
    <div class="text-center">
      <a href="#" class="text-decoration-none">Forgot your password?</a>
    </div>
  </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXlAH+e+4YyT7RX6QjoG0FjS05A6F/It2lO3y9S/QD/yRqgXQ56P3to7bo1Dh" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIphndgHknpmLMsD6KAO8XKzWm1R9j9QT4K00RPI6xljV+n/tzj5M0iDhbXhQp8" crossorigin="anonymous"></script>
</body>
</html>
