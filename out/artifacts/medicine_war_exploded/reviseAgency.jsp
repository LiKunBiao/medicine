<%--
  Created by IntelliJ IDEA.
  User: JianFeidao
  Date: 2021/12/7
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>修改代办人界面</title>

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
<nav class="navbar navbar-default">
    <!--<nav class="navbar navbar-inverse">-->
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header" class="table table-bordered" class="table table-striped">
            <!--汉堡按钮-->
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">医药管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/FindAgencyByPageServlet">顾客信息</a></li>
                <li><a href="#">经办人信息</a></li>
                <li><a href="#">药品信息</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">管理员<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/FindLoginByPageServlet">管理用户信息</a></li>
                        <li><a href="/login.jsp">注销</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<!--上面是导航条-->
<!--代办人-->

<div class="agency">
    <form class="form-horizontal" action="/ReviseAgencyServlet">
        <div class="form-group">
            <label for="inputText1" class="col-sm-2 control-label">编号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="ano" value="${agency.ano}" id="inputText1" placeholder="请输入编号">
            </div>
        </div>
        <div class="form-group">
            <label for="inputText2" class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="aname" value="${agency.aname}" id="inputText2" placeholder="请输入姓名">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">性别</label>
            <div class="col-sm-1">
                <div class="radio">
                    <label>
                        <c:if test="${agency.asex == '男'}">
                            <input type="radio" name="asex" id="optionsRadios1" value="男" checked>
                        </c:if>
                        <c:if test="${agency.asex != '男'}">
                            <input type="radio" name="asex" id="optionsRadios1" value="男">
                        </c:if>
                        男
                    </label>
                </div>
            </div>
            <div class="col-sm-9">
                <div class="radio">
                    <label>
                        <c:if test="${agency.asex == '女'}">
                            <input type="radio" name="asex" id="optionsRadios2" value="女" checked>
                        </c:if>
                        <c:if test="${agency.asex != '女'}">
                            <input type="radio" name="asex" id="optionsRadios2" value="女">
                        </c:if>
                        女
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="inputText3" class="col-sm-2 control-label">电话</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="aphone" value="${agency.aphone}" id="inputText3" placeholder="请输入电话">
            </div>
        </div>
        <div class="form-group">
            <label for="inputText4" class="col-sm-2 control-label">备注</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="aremark" value="${agency.aremark}" id="inputText4" placeholder="请输入备注">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Sign in</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
