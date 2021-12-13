<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/26
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.lgd.dao.StudentDao" %>
<%@ page import="com.lgd.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>showStudent</title>
</head>
<body>
<%--    创建对象--%>
<%
    StudentDao studentdao = new StudentDao();
    ArrayList students = studentdao.queryAllStudents();
%>
    <table border = 2>
        <tr>
            <td>学号</td>
            <td>姓名</td>
        </tr>
        <%
            for (int i = 0; i < students.size(); i++) {
                Student student = (Student) students.get(i);
        %>
        <tr>
            <td><%= student.getId()%></td>
            <td><%= student.getName()%></td>
        </tr>
        <%
          }
            %>
    </table>
</body>
</html>
