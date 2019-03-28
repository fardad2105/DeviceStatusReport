<%--
  Created by IntelliJ IDEA.
  User: fardad2105
  Date: 12/8/2018.
  Time: 5:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h1 class="text-danger text-center">HTTP Status 403 - Access is denied</h1>

<c:choose>
    <c:when test="${empty username}">
        <h2 class="text-primary text-center">You do not have permission to access this page!</h2>
    </c:when>
    <c:otherwise>
        <h2 class="text-primary text-center">Username : ${username} <br/>
            You do not have permission to access this page!</h2>
    </c:otherwise>
</c:choose>

</body>
</html>