<%--
  Created by IntelliJ IDEA.
  User: geyao
  Date: 2020/6/4
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
    <title>图书新增</title>
</head>
<body>
    <form action="book" method="post">
        <input type="submit" value="新增图书">
    </form>
    <form action="book/10" method="post">
        <input type="submit" value="修改图书"><input type="hidden" value="put" name="_method">
    </form>
    <form action="book/10" method="post">
        <input type="submit" value="删除图书"><input type="hidden" value="delete" name="_method">
    </form>
    <a href="book/10">查询图书</a>
</body>
</html>
