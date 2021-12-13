<%@ page import="com.lgd.dao.ScoreDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lgd.pojo.Score" %><%--
  Created by IntelliJ IDEA.
  User: LGD
  Date: 2021/11/3
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

    <title>课程学生成绩</title>
</head>
<body>
    <form   action="${pageContext.request.contextPath}/servlet/updateScore" method="post">
        <% String cid = "1";%>
        <table align="center">
            <caption>请输入课程编号为<%=cid%>的所有学生成绩<input type="submit" value="提交成绩"/></caption>
            <input type="hidden" name="cid" value="<%=cid%>"/>
            <tr bgcolor="yellow">
                <td>学号</td>
                <td>姓名</td>
                <td>考试类型</td>
                <td>分数</td>
            </tr>
            <%
            ScoreDao scoreDao = new ScoreDao();
            ArrayList scores = null;

                try {
                    scores = scoreDao.getListByCid(cid);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            for (int i = 0; i < scores.size(); i++) {
                Score score = (Score) scores.get(i);
            %>
            <tr bgcolor="#ff1493">
                <td><%=score.getId()%></td>
                <td><%=score.getName()%></td>
                <td><%=score.getType()%></td>
                <td>
                    <%
                        if (Score.isEmpty(score.getScorenum()) || score.getScorenum() == null) {
                    %>
                        <input name="score" type="text" size="4"/>
                        <input name="type" type="hidden" value="<%=score.getType()%>"/>
                        <input name="id" type="hidden" value="<%=score.getId()%>"/>
                    <%
                        }else{
                            out.print(score.getScorenum());
                        }
                    %></td>
            </tr>
            <%
                }
            %>
        </table>

    </form>
</body>
</html>