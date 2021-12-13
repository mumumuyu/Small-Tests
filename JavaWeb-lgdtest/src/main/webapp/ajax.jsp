<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/9/19
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>
  <%--导入jQuery--%>
  <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"/>
</head>
<body>
  <script type="text/javascript">

    function a1(){
      $.ajax({
        url:"${pageContext.request.contextPath}/ajax/a1",
        data:{"name":$("txtName").val()},
        success:function (data) {
          console.log(data)
        }
      });
    }

  </script>
</body>
</html>
