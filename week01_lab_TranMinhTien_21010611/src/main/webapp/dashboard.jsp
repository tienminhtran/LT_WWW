<%@ page import="vn.edu.iuh.fit.entities.Account" %>
<%@ page import="vn.edu.iuh.fit.repositories.AccountRepository" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Dashboard</title>
    <style>
        .table th, .table td {
            vertical-align: middle;
        }
        .btn-link {
            color: #007bff;
            text-decoration: none;
        }
        .btn-link:hover {
            color: #0056b3;
            text-decoration: underline;
        }
        .header-button {
            margin-bottom: 20px;
        }
    </style>
</head>
<body class="bg-light">
<%
    AccountRepository accountRepository = new AccountRepository();
    List<Account> accounts = accountRepository.findAllAccount();
%>
<div class="container mt-5">
    <h1 class="text-center mb-4">Account List</h1>
    <div class="header-button">
        <a href="login?action=add" class="btn btn-success mb-3">Add New Account</a>
    </div>
    <table class="table table-bordered table-hover shadow-sm">
        <thead class="table-primary">
        <tr>
            <th>Id</th>
            <th>Full Name</th>
            <th>Password</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Account acc : accounts) {
        %>
        <tr>
            <td><%= acc.getAccount_id() %></td>
            <td><%= acc.getFull_name() %></td>
            <td><%= acc.getPassword() %></td>
            <td><%= acc.getPhone() %></td>
            <td><%= acc.getEmail() %></td>
            <td><%= acc.getStatus() %></td>
            <td>
                <a href="login?action=edit&id=<%= acc.getAccount_id() %>" class="btn btn-link">Edit</a>
                <a href="login?action=delete&id=<%= acc.getAccount_id() %>" class="btn btn-link text-danger">Delete</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
</script>
</body>
</html>
