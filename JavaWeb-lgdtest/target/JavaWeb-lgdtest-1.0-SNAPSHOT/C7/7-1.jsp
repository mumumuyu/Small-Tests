<%--
  Created by IntelliJ IDEA.
  User: LGD
  Date: 2021/10/2
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>7-1</title>
</head>
<body>
    <%--  比如post,get--%>
    提交方式: <%=request.getMethod() %><br>
    请求的URL地址: <%=request.getRequestURI() %><br>
    <%--比如http/1.1--%>
    协议名称: <%=request.getProtocol() %><br>
    客户端请求服务器文件的路径: <%=request.getServletPath() %><br>
    <%--	？后的参数--%>
    URL的查询部分: <%=request.getQueryString() %><br>
    服务器的名称: <%=request.getServerName() %><br>
    服务器端口号: <%=request.getServerPort() %><br>
    远程客户端的IP地址: <%=request.getRemoteAddr()%><br>
</body>
</html>
