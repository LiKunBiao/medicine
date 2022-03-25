<%--
  Created by IntelliJ IDEA.
  User: JianFeidao
  Date: 2021/12/11
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户界面</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <![endif]-->
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <style>
        body{
            background: url("img/picture.png");
        }
        .agency{
            margin: auto;
            margin-top: 100px;
            width: 600px;
            height: 500px;
        }
    </style>
</head>
<body>

<!--代办人-->
<div class="agency">
    <form class="form-horizontal" action="/AddLoginServlet">
        <div class="form-group">
            <label for="inputText1" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="username" id="inputText1" placeholder="请输入用户名">
            </div>
        </div>
        <div class="form-group">
            <label for="inputText2" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="password" id="inputText2" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">用户类型</label>
            <div class="col-sm-8">
                <div class="radio">
                    <label>
                        <input type="radio" name="usertype" id="optionsRadios2" value="普通用户">
                        普通用户
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Sign in</button>
                &nbsp;&nbsp;
                <a class="btn btn-default" href="/login.jsp" role="button">Back</a>
            </div>
        </div>
        <input type="hidden" name="register" value="register">
    </form>
</div>
</body>
</html>