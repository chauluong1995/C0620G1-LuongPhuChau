<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/15/2020
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <form:form action="update" method="post" modelAttribute="email">
        <h1>Setting</h1>

        <form:label path="language">Languages
            <form:select path="language">
                <c:forEach var="language" items="${languages}">
                    <c:choose>
                        <c:when test="${language.equals(email.language)}">
                            <form:option value="${email.language}" selected="${email.language}"><c:out value="${email.language}"></c:out></form:option>
                        </c:when>
                        <c:otherwise>
                            <form:option value="${language}">${language}</form:option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </form:label>

        <br><br>

        <form:label path="pageSize">Page Size : Show
            <form:select path="pageSize">
                <c:forEach var="pageSize" items="${pageSizes}">
                    <c:choose>
                        <c:when test="${pageSize.equals(email.pageSize)}">
                            <form:option value="${email.pageSize}" selected="${email.pageSize}">${email.pageSize}</form:option>
                        </c:when>
                        <c:otherwise>
                            <form:option value="${pageSize}">${pageSize}</form:option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            emails per page
        </form:label>

        <br><br>

        <form:label path="spamsFilter">Spams Filter :
            <c:if test="${email.spamsFilter eq 'true'}">
                <form:checkbox path="spamsFilter" checked="checked" />
            </c:if>

            <c:if test="${email.spamsFilter eq 'false'}">
                <form:checkbox path="spamsFilter" checked="" />
            </c:if>

<%--            <input type="checkbox" name="${email.spamsFilter}" id="${email.spamsFilter}"--%>
<%--                   value="${email.spamsFilter}" ${email.spamsFilter == "true" ? "checked" : ""}>--%>

            Enable spams filter
        </form:label>

        <br><br>

        <form:label path="signature">Signature :
        <form:textarea path="signature" value="${email.signature}" />
        </form:label>

        <br><br>

        <input type="submit" value="Update">
        <input type="submit" value="Cancel">

    </form:form>
</body>
</html>
