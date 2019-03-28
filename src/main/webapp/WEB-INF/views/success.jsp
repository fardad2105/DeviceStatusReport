<%--
  Created by IntelliJ IDEA.
  User: SOBHAN
  Date: 3/22/2019
  Time: 2:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table cellpadding="2" cellspacing="2" border="1">

    <c:forEach var="p" items="${listDeviceInfo}">
        <tr>
            <td>${p.device_id}</td>
            <td>${p.ts_date}</td>
            <td>${p.ts_time}</td>
            <td>${p.opr_type}</td>
            <td>${p.detail_pay}</td>
            <td>${p.card_number}</td>
            <td>${p.reference_number}</td>
            <td>${p.ts_code}</td>
            <td>${p.price}</td>
            <td>${p.month_code}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
