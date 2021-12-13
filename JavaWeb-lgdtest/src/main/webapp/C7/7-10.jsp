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
    <title>7-10</title>
</head>
<body>
    <%
        //从Cookie获得number
        String str = null;
        Cookie[] cookies = request.getCookies();
        for(int i=0;i<cookies.length;i++){
            if(cookies[i].getName().equals("number")){
                str = cookies[i].getValue();
                break;
            }
        }
        int number = Integer.parseInt(str);
    %>
    该数字的立方为：<%=number*number*number %><HR>
</body>
</html>
