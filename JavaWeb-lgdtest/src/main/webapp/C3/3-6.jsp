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
    <title>3-6</title>
</head>
<body>
    <%--<script type="text/javascript">
    //setTimeout让函数某段时间之后运行1次，参数2是毫秒
    timer = window.setTimeout("fun1()","1000");
    var i = 0;
    function fun1(){
        i++;
        window.status = i;
        if(i==100){
            window.clearTimeout(timer);//清除定时器，否则会一直运行
            return;
        }
        timer = window.setTimeout("fun1()","1000");
    }
    </script>--%>
    <script type="text/javascript">
        var num=0;
        function changeNum(){
            num=num+1;
            window.status=num+"";
            if(num==100){
                window.clearInterval(dsq);
            }
        }
        var dsq=window.setInterval("changeNum()",1000);
    </script>
</body>
</html>
