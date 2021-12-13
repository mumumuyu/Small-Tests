<%--
  Created by IntelliJ IDEA.
  User: LGD
  Date: 2021/10/3
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>8-10</title>
</head>
<body>
    <%
        //第一次访问，实例化count
        Integer count = (Integer)application.getAttribute("count");
        if(count==null){
            count = new Integer(0);
        }
        count++;
        application.setAttribute("count",count);
    %>
    您是该页面的第<%=count%>个访问者。
</body>
</html>
