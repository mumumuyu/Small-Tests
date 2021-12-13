<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/26
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="student" class="com.lgd.pojo.Student" scope="request"></jsp:useBean>
<jsp:setProperty name="student" property="name" value="lgd"></jsp:setProperty>
<html>
<head>
    <title>request1</title>
</head>
<body>
    <jsp:forward page="request2.jsp"></jsp:forward>
</body>
</html>
