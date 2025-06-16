<%--
  Created by IntelliJ IDEA.
  User: hiruna
  Date: 6/16/25
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-body">
            <h3 class="card-title text-center mb-4">Admin Dashboard</h3>
            <p class="text-center">Welcome Admin, <strong><%= session.getAttribute("username") %></strong></p>
            <div class="d-flex justify-content-center gap-3">
                <a href="all_complaints.jsp" class="btn btn-primary">📋 View All Complaints</a>
                <a href="index.jsp" class="btn btn-danger">🚪 Logout</a>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
