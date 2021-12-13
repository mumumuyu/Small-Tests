<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/26
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>开始使用 layui</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asset/css/layui.css">
    <script src="${pageContext.request.contextPath}/asset/layui.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<!-- 你的HTML代码 -->
<form name="login">
    <input type="text" name="id" >
    <input type="button" onclick="valid()">
</form>
<script>
    //一般直接写在一个js文件中
    layui.use(['layer', 'form'], function(){
        var layer = layui.layer
            ,form = layui.form
            ,table = layui.table;

        layer.msg('Hello World');
    });
    function valid() {
        if (login.id.value === "") {
            layer.alert('请输入用户名', {
                icon: 5,
                title: "提示"
            });
            return;
        }
    }
</script>
<div class="layui-container">
    常规布局（以中型屏幕桌面为例）：
    <div class="layui-row">
        <div class="layui-col-md9">
            你的内容 9/12
        </div>
        <div class="layui-col-md3">
            你的内容 3/12
        </div>
    </div>
    移动设备、平板、桌面端的不同表现：
    <div class="layui-row">
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4">
            移动：6/12 | 平板：6/12 | 桌面：4/12
        </div>
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4">
            移动：6/12 | 平板：6/12 | 桌面：4/12
        </div>
        <div class="layui-col-xs4 layui-col-sm12 layui-col-md4">
            移动：4/12 | 平板：12/12 | 桌面：4/12
        </div>
        <div class="layui-col-xs4 layui-col-sm7 layui-col-md8">
            移动：4/12 | 平板：7/12 | 桌面：8/12
        </div>
        <div class="layui-col-xs4 layui-col-sm5 layui-col-md4">
            移动：4/12 | 平板：5/12 | 桌面：4/12
        </div>
    </div>
</div>

</body>
</html>
