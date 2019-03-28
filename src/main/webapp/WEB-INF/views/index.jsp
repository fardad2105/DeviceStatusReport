<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SOBHAN
  Date: 3/22/2019
  Time: 2:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<form:form method="post" commandName="excelFile" action="${pageContext.request.contextPath}/excel/uploadFile" enctype="multipart/form-data">--%>
    <%--Please Select a excel file <input type="file" name="file">--%>
    <%--<br>--%>
    <%--<input type="submit" value="Import">--%>
<%--</form:form>--%>


<c:url value="/excel/uploadExcelFile" var="uploadFileUrl" />
<form method="post" enctype="multipart/form-data"
      action="${uploadFileUrl}">
    <input type="file" name="file" accept=".xls,.xlsx" id="files" />

    <input id="uploadButton"
        type="submit" value="Upload" />
</form>

</body>
</html>
