<%--
  Created by IntelliJ IDEA.
  User: JianFeidao
  Date: 2021/12/11
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>登录界面</title>

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
  <script type="text/javascript" src="/js/login.js" ></script>
  <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
  <style type="text/css">
    body{background: url(img/picture.png) no-repeat;background-size:cover;font-size: 16px;}
    .form{background: rgba(255,255,255,0.2);width:400px;margin:100px auto;}
    #login_form{display: block;}
    #register_form{display: none;}
    .fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
    input[type="text"],input[type="password"]{padding-left:26px;}
    .checkbox{padding-left:21px;}
  </style>
</head>
<body>
<!--
    基础知识：
    网格系统:通过行和列布局
    行必须放在container内
    手机用col-xs-*
    平板用col-sm-*
    笔记本或普通台式电脑用col-md-*
    大型设备台式电脑用col-lg-*
    为了兼容多个设备，可以用多个col-*-*来控制；
-->
<div class="container">
  <div class="form row">
    <form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="login_form" action="/LoginServlet">
      <h3 class="form-title">Login to your account</h3>
      <div class="col-sm-9 col-md-9">
        <div class="form-group">
          <i class="fa fa-user fa-lg"></i>
          <input class="form-control required" type="text" placeholder="Username" name="username" value="${cookie.username.value}" autofocus="autofocus" maxlength="20"/>
        </div>
        <div class="form-group">
          <i class="fa fa-lock fa-lg"></i>
          <input class="form-control required" type="password" placeholder="Password" name="password" value="${cookie.password.value}" maxlength="8"/>
        </div>
        <div class="form-group">
          <label class="checkbox">
              <input type="checkbox" name="remember" value="1" /> Remember me
          </label>
          <hr />
          <a href="/registerUser.jsp" id="register_btn" class="">Create an account</a>
        </div>
        <div class="form-group">
          <input type="submit" class="btn btn-success pull-right" value="Login "/>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>