<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Admin Dashboard</title>
</head>
<body>
<h1>Welcome to the Secret Admin Area</h1>
<p>This page is only visible to authenticated admins.</p>

<!-- Admin functionality here -->
<form action="${pageContext.request.contextPath}/logout" method="post">
  <input type="submit" value="Logout">
</form>
</body>
</html>