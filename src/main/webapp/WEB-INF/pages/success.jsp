<%--
  Created by IntelliJ IDEA.
  User: geyao
  Date: 2020/6/2
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<html>
<head>
    <title><fmt:message key="welcome"/></title>
</head>
<body>
    <h3>成了</h3>
    ${requestScope.key}<br/>
    ${sessionScope.key}
</body>
</html>
