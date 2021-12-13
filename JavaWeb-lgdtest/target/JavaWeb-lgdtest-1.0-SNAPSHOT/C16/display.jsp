<%--
  Created by IntelliJ IDEA.
  User: LGD
  Date: 2021/11/3
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>16-1</title>
</head>
<body>
    <table align="center">
        <caption>欢迎给教师投票</caption>
        <tr bgcolor="yellow">
            <td>编号</td>
            <td>姓名</td>
            <td>得票数</td>
            <td>投票</td>
        </tr>
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/javaweb-test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "1328910");
                Statement stmt = connection.createStatement();
                String sql = "select * from vote";
                ResultSet rset = stmt.executeQuery(sql);
                while (rset.next()){
                    String id = rset.getString(1);
                    String name = rset.getString(2);
                    int vote = rset.getInt(3);
         %>
                    <tr bgcolor="pink">
                        <td><%=id%></td>
                        <td><%=name%></td>
                        <td><img src="${pageContext.request.contextPath}/C16/images/bar.jpg" width="<%=vote%>" height="10"/><%=vote%></td>
                        <td><a href="${pageContext.request.contextPath}/servlet/vote?id=<%=id%>">投票</a></td>
                    </tr>
         <%
                }
                rset.close();
                stmt.close();
                connection.close();
            }catch (SQLException e){
                 e.printStackTrace();
             }
        %>
    </table>
</body>
</html>
