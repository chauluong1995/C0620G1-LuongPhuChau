<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/15/2020
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <form action="showUpdate">
        <h1>${email.language}</h1>
        <h1>${email.pageSize}</h1>
        <h1>${email.spamsFilter}</h1>
        <h1>${email.signature}</h1>
        <input type="submit" value="Update Info">
    </form>
</body>
</html>
