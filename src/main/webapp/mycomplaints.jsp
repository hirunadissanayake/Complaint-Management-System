<%--
  Created by IntelliJ IDEA.
  User: hiruna
  Date: 6/17/25
  Time: 1:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="true" %>
<%@ page import="java.util.*, model.Complaint" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Complaints</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-body">
            <h3 class="card-title text-center">My Complaints</h3>
            <table class="table table-striped table-bordered mt-4">
                <thead class="table-light">
                <tr>
                    <th>Title</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Complaint> complaints = (List<Complaint>) request.getAttribute("complaints");
                    for (Complaint c : complaints) {
                %>
                <tr>
                    <td><%= c.getTitle() %></td>
                    <td><%= c.getStatus() %></td>
                    <td>
                        <% if ("Pending".equals(c.getStatus())) { %>
                        <a href="edit_complaint.jsp?id=<%= c.getId() %>" class="btn btn-warning btn-sm">Edit</a>
                        <form action="../../ComplaintServlet" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="delete" />
                            <input type="hidden" name="id" value="<%= c.getId() %>" />
                            <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                        </form>
                        <% } else { %>
                        <span class="badge bg-secondary">Locked</span>
                        <% } %>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>

            <a href="employeedashboard.jsp" class="btn btn-secondary">Back to Dashboard</a>
        </div>
    </div>
</div>

</body>
</html>

