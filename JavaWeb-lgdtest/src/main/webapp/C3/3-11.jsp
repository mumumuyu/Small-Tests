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
    <title>3-11</title>
</head>
<body>
<script type="text/javascript">
    function add(){
        //得到这两个文本框的内容
        n1 = Number(document.form1.txt1.value);//value是网页中控件用得最多的属性//获取文本框内容 (document.form1.txt1.value)
        n2 = Number(document.form1.txt2.value);
        document.form1.txt3.value = n1+n2;
    }
</script>
<form name="form1">
    <input name="txt1" type="text"><BR>
    <input name="txt2"  type="text"><BR>
    <input type="button" onclick="add()" value="求和"><BR>
    <input name="txt3"  type="text"><BR>
</form>
</body>
</html>
