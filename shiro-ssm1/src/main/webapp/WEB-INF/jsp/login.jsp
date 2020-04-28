<%--
  Created by IntelliJ IDEA.
  User: 范俊
  Date: 2020/4/28
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <form action="" class="form" method="post">
                    <div class="form-group">
                        <label for="username">账号</label>
                        <input class="form-control" type="text" id="username" name="username">
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input class="form-control" type="text" id="password" name="password">
                    </div>
                    <div class="form-group">
                        <button class="btn btn-success">登录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
