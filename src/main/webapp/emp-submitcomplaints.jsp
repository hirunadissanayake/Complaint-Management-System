<%--
  Created by IntelliJ IDEA.
  User: hiruna
  Date: 6/17/25
  Time: 1:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Submit Complaint</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-body">
            <h3 class="card-title text-center">Submit Complaint</h3>
            <form method="post" action="/complaintServlet">
                <input type="hidden" name="action" value="submit" />

                <div class="mb-3">
                    <label class="form-label">Title</label>
                    <input type="text" name="title" class="form-control" required />
                </div>

                <div class="mb-3">
                    <label class="form-label">Description</label>
                    <textarea name="description" class="form-control" required></textarea>
                </div>

                <button type="submit" class="btn btn-primary">Submit Complaint</button>
                <a href="employeedashboard.jsp" class="btn btn-secondary">Back to Dashboard</a>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>

