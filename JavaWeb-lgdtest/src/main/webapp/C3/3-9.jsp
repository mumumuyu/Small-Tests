<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/9/17
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>3-9</title>
</head>
<body>
<script type="text/javascript">
    document.writeln("<table width=400 height=400 border=1>");
    for(i=1;i<=8;i++){
        document.writeln("<tr>");
        for(j=1;j<=8;j++){
            color = "black";
            if((i+j)%2==0){
                color = "white";
            }
            document.writeln("<td bgcolor=" + color + "></td>");						        }
        document.writeln("</tr>");
    }
    document.writeln("</table>");
</script>
</body>
</html>
