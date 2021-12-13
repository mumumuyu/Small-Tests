<%--
  Created by IntelliJ IDEA.
  User: LGD
  Date: 2021/10/9
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<SCRIPT LANGUAGE="JavaScript">
    function showInfo(){
        var xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
        xmlHttp.open("GET", "info.jsp", true);
        xmlHttp.onreadystatechange=function() {
            if (xmlHttp.readyState==4) {
                infoDiv.innerHTML = xmlHttp.responseText;
            }
        }
        xmlHttp.send();
    }
</SCRIPT>
欢迎来到本系统. <HR>
<input type="button" value="显示公司信息" onClick="showInfo()">
<div id="infoDiv"></div>
</body>
</html>
