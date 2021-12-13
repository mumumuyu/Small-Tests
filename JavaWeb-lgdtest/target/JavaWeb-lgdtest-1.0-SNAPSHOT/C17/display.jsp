<%@ page import="java.sql.*" %>
<%@ page import="com.lgd.dao.VoteDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lgd.pojo.Vote" %><%--
  Created by IntelliJ IDEA.
  User: LGD
  Date: 2021/11/3
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>17-1</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/servlet/votes" method="post">
    <table align="center">
        <caption>欢迎给教师投票<input type="submit" value="提交投票" align="center"/></caption>
        <tr bgcolor="yellow">
            <td>编号</td>
            <td>姓名</td>
            <td>得票数</td>
            <td>投票</td>
        </tr>
        <%
            VoteDao voteDao = new VoteDao();
            ArrayList votes = null;
            try {
                votes = voteDao.getAllVote();
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < votes.size(); i++) {
                Vote vote = (Vote) votes.get(i);
         %>
                    <tr bgcolor="pink">
                        <td><%=vote.getId()%></td>
                        <td><%=vote.getName()%></td>
                        <td><img src="${pageContext.request.contextPath}/C17/images/bar.jpg" width="<%=vote.getVotenum()%>" height="10"/><%=vote.getVotenum()%></td>
                        <td><input type="checkbox" name="ids" value="<%=vote.getId()%>"></td>
                    </tr>
        <%
            }
        %>
    </table>
    </form>
</body>
</html>
