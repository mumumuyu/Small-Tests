<%@ page import="javafx.application.Application" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<%--${pageContext.request.contextPath}代表当前项目--%>
<h2>当前有 <span><%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%></span>人在线</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
    用户名:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    爱好:
    <input type="checkbox" name="hobby" value="吃饭">吃饭
    <input type="checkbox" name="hobby" value="睡觉">睡觉
    <input type="checkbox" name="hobby" value="打游戏">打游戏
    <input type="checkbox" name="hobby" value="学习">学习

    <input type="submit">
    <%--ctrl + shift + /--%>
    <%
        pageContext.setAttribute("name1","lgd1");
        request.setAttribute("name2","lgd2");
        session.setAttribute("name3","lgd3");
        application.setAttribute("name4","lgd4");
        String s1 = (String) pageContext.findAttribute("name1");
        String s2 = (String) pageContext.findAttribute("name2");
        String s3 = (String) pageContext.findAttribute("name3");
        String s4 = (String) pageContext.findAttribute("name4");
        String s5 = (String) pageContext.findAttribute("name5");
    %>
    <h1>取出的值为:</h1>
    <h3>${name1}</h3>
    <h3>${name2}</h3>
    <h3>${name3}</h3>
    <h3>${name4}</h3>
    <h3>${name5}</h3>
<%--    <jsp:forward page="success.jsp">--%>
<%--        <jsp:param name="name" value="lgd"/>&lt;%&ndash;转发内容&ndash;%&gt;--%>
<%--        <jsp:param name="age" value="15"/>--%>
<%--    </jsp:forward>--%>
</form>
</body>
</html>
