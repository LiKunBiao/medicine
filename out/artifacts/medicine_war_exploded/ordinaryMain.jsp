<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>主界面</title>

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
            width: 1200px;
            height: 500px;
            margin: auto;
            margin-top: 20px;
        }
        h3{
            text-align: center;
        }
        /*table{*/
        /*    margin: auto;*/
        /*    margin-top: 20px;*/
        /*}*/
        th{
            background-color: #5882FA;
            text-align: center;
        }
        td{
            text-align: center;
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
                <li><a href="/FindOrdinaryAgencyServlet">经办人信息</a></li>
                <li><a href="/FindOrdinaryClientServlet">顾客信息</a></li>
                <li><a href="/FindOrdinaryMedicineServlet">药品信息</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">普通用户<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/AncellationServlet">注销</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<!--经办人-->
<c:if test="${id == 1}">
    <div class="agency">
        <h3>经办人信息表</h3>
        <br>
        <div class="table-responsive">
            <div style="float: left"><!--左浮动-->
                <form class="form-inline" action="/SearchAgencyByPageServlet">
                    <div class="form-group">
                        <select class="form-control" name="key1">
                            <option value="ano">编号</option>
                            <option value="aname">姓名</option>
                            <option value="asex">性别</option>
                            <option value="aphone">电话</option>
                            <option value="aremark">备注</option>
                        </select>
                        <input type="text" class="form-control" name="value1" id="exampleInput1" placeholder="查询条件一">
                    </div>
                    <div class="form-group">
                        <select class="form-control" name="key2">
                            <option value="ano">编号</option>
                            <option value="aname">姓名</option>
                            <option value="asex">性别</option>
                            <option value="aphone">电话</option>
                            <option value="aremark">备注</option>
                        </select>
                        <input type="text" class="form-control" name="value2" id="exampleInput2" placeholder="查询条件二">
                    </div>
                    <button type="submit" class="btn btn-info">查询</button>
                </form>
            </div>
            <form>
                <table class="table table-hover table-bordered ">
                    <tr>
                        <th><input type="checkbox"></th>
                        <th>编号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>电话</th>
                        <th>备注</th>
                    </tr>
                    <c:forEach items="${agencyPage.list}" var="agency">
                        <tr>
                            <td><input type="checkbox" name="ano" value="${agency.ano}"></td>
                            <td>${agency.ano}</td>
                            <td>${agency.aname}</td>
                            <td>${agency.asex}</td>
                            <td>${agency.aphone}</td>
                            <td>${agency.aremark}</td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
            <div><!--分页条-->
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:forEach begin="1" end="${agencyPage.totalPage}" var="i">
                            <c:if test="${agencyPage.currentPage == i}">
                                <!--当前页深色-->
                                <li class="active"><a href="/FindAgencyByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                            </c:if>
                            <c:if test="${agencyPage.currentPage != i}">
                                <!--当前页深色-->
                                <li><a href="/FindAgencyByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                            </c:if>
                        </c:forEach>
                        <span style="font-size: 25px;margin-left: 5px">
                        共${agencyPage.totalCount}条记录，共${agencyPage.totalPage}页
                    </span>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${id == 2}">
    <div class="agency">
        <h3>用户信息表</h3>
        <br>
        <div class="table-responsive">
            <div style="float: left"><!--左浮动-->
                <form class="form-inline" action="/SearchLoginByPageServlet">
                    <div class="form-group">
                        <button class="btn btn-default" type="submit">用户名</button>
                        <input type="text" class="form-control" name="username" id="exampleInput3" placeholder="请输入用户名">
                    </div>
                    <button type="submit" class="btn btn-info">查询</button>
                </form>
            </div>
            <form>
                <table class="table table-hover table-bordered ">
                    <tr>
                        <th><input type="checkbox"></th>
                        <th>用户名</th>
                        <th>密码</th>
                        <th>用户类型</th>
                    </tr>
                    <c:forEach items="${loginPage.list}" var="login">
                        <tr>
                            <td><input type="checkbox" name="username" value="${login.username}"></td>
                            <td>${login.username}</td>
                            <td>${login.password}</td>
                            <td>${login.usertype}</td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
            <div><!--分页条-->
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:forEach begin="1" end="${loginPage.totalPage}" var="i">
                            <c:if test="${loginPage.currentPage == i}">
                                <!--当前页深色-->
                                <li class="active"><a href="/FindLoginByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                            </c:if>
                            <c:if test="${loginPage.currentPage != i}">
                                <!--当前页深色-->
                                <li><a href="/FindLoginByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                            </c:if>
                        </c:forEach>
                        <span style="font-size: 25px;margin-left: 5px">
                        共${loginPage.totalCount}条记录，共${loginPage.totalPage}页
                    </span>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${id == 3}">
    <div class="agency">
        <h3>顾客信息表</h3>
        <br>
        <div class="table-responsive">
            <div style="float: left"><!--左浮动-->
                <form class="form-inline" action="/SearchClientByPageServlet">
                    <div class="form-group">
                        <select class="form-control" name="key1">
                            <option value="cno">编号</option>
                            <option value="cname">姓名</option>
                            <option value="csex">性别</option>
                            <option value="cage">年龄</option>
                            <option value="caddress">住址</option>
                            <option value="cphone">电话</option>
                            <option value="csymptom">症状</option>
                            <option value="mno">已购药品</option>
                            <option value="ano">经办人</option>
                            <option value="cdate">录入日期</option>
                            <option value="cremark">备注</option>
                        </select>
                        <input type="text" class="form-control" name="value1" id="exampleInput5" placeholder="查询条件一">
                    </div>
                    <div class="form-group">
                        <select class="form-control" name="key2">
                            <option value="cno">编号</option>
                            <option value="cname">姓名</option>
                            <option value="csex">性别</option>
                            <option value="cage">年龄</option>
                            <option value="caddress">住址</option>
                            <option value="cphone">电话</option>
                            <option value="csymptom">症状</option>
                            <option value="mno">已购药品</option>
                            <option value="ano">经办人</option>
                            <option value="cdate">录入日期</option>
                            <option value="cremark">备注</option>
                        </select>
                        <input type="text" class="form-control" name="value2" id="exampleInput6" placeholder="查询条件二">
                    </div>
                    <button type="submit" class="btn btn-info">查询</button>
                </form>
            </div>
            <form>
                <table class="table table-hover table-bordered ">
                    <tr>
                        <th><input type="checkbox"></th>
                        <th>编号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>年龄</th>
                        <th>住址</th>
                        <th>电话</th>
                        <th>症状</th>
                        <th>已购药品</th>
                        <th>经办人</th>
                        <th>录入日期</th>
                        <th>备注</th>
                    </tr>
                    <c:forEach items="${clientPage.list}" var="client">
                        <tr>
                            <td><input type="checkbox" name="cno" value="${client.cno}"></td>
                            <td>${client.cno}</td>
                            <td>${client.cname}</td>
                            <td>${client.csex}</td>
                            <td>${client.cage}</td>
                            <td>${client.caddress}</td>
                            <td>${client.cphone}</td>
                            <td>${client.csymptom}</td>
                            <td>${client.mno}</td>
                            <td>${client.ano}</td>
                            <td>${client.cdate}</td>
                            <td>${client.cremark}</td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
            <div><!--分页条-->
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:forEach begin="1" end="${clientPage.totalPage}" var="i">
                            <c:if test="${clientPage.currentPage == i}">
                                <!--当前页深色-->
                                <li class="active"><a href="/FindClientByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                            </c:if>
                            <c:if test="${clientPage.currentPage != i}">
                                <!--当前页深色-->
                                <li><a href="/FindClientByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                            </c:if>
                        </c:forEach>
                        <span style="font-size: 25px;margin-left: 5px">
                        共${clientPage.totalCount}条记录，共${clientPage.totalPage}页
                    </span>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${id == 4}">
    <div class="agency">
        <h3>经办人信息表</h3>
        <br>
        <div class="table-responsive">
            <div style="float: left"><!--左浮动-->
                <form class="form-inline" action="/SearchMedicineByPageServlet">
                    <div class="form-group">
                        <select class="form-control" name="key1">
                            <option value="mno">编号</option>
                            <option value="mname">名称</option>
                            <option value="mmode">服用方法</option>
                            <option value="mefficacy">功效</option>
                        </select>
                        <input type="text" class="form-control" name="value1" id="exampleInput7" placeholder="查询条件一">
                    </div>
                    <div class="form-group">
                        <select class="form-control" name="key2">
                            <option value="mno">编号</option>
                            <option value="mname">名称</option>
                            <option value="mmode">服用方法</option>
                            <option value="mefficacy">功效</option>
                        </select>
                        <input type="text" class="form-control" name="value2" id="exampleInput8" placeholder="查询条件二">
                    </div>
                    <button type="submit" class="btn btn-info">查询</button>
                </form>
            </div>
            <form>
                <div style="float: right;margin: 5px"><!--右浮动-->
                    <a class="btn btn-info" href="/addMedicine.jsp" role="button">添加代办人</a>
                    <button type="submit" class="btn btn-info">删除选中</button>
                </div>
                <table class="table table-hover table-bordered ">
                    <tr>
                        <th><input type="checkbox"></th>
                        <th>编号</th>
                        <th>名称</th>
                        <th>服用方法</th>
                        <th>功效</th>
                    </tr>
                    <c:forEach items="${medicinePage.list}" var="medicine">
                        <tr>
                            <td><input type="checkbox" name="mno" value="${medicine.mno}"></td>
                            <td>${medicine.mno}</td>
                            <td>${medicine.mname}</td>
                            <td>${medicine.mmode}</td>
                            <td>${medicine.mefficacy}</td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
            <div><!--分页条-->
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:forEach begin="1" end="${medicinePage.totalPage}" var="i">
                            <c:if test="${medicinePage.currentPage == i}">
                                <!--当前页深色-->
                                <li class="active"><a href="/FindMedicineByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                            </c:if>
                            <c:if test="${medicinePage.currentPage != i}">
                                <!--当前页深色-->
                                <li><a href="/FindMedicineByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                            </c:if>
                        </c:forEach>
                        <span style="font-size: 25px;margin-left: 5px">
                        共${medicinePage.totalCount}条记录，共${medicinePage.totalPage}页
                    </span>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</c:if>
</body>
</html>