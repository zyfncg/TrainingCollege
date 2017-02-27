<%--
  Created by IntelliJ IDEA.
  User: ZhangYF
  Date: 2017/2/17
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="${contextPath}css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/css/style.css">
</head>
<body>
<div class="register-body">
    <form class="form-horizontal" role="form" method='POST' action='${actionURL}'>
        <div class="form-group row">
            <label for="institutionid" class="col-md-2 control-label">机构编号</label>
            <div class="col-md-8">
                <input type='text' id="institutionid" class="userid form-control" name='institutionid' value="${institutionid}" readonly="readonly" required>
            </div>
        </div>
        <div class="form-group row">
            <label for="name" class="col-md-2 control-label">机构名称</label>
            <div class="col-md-8">
                <input type='text' id="name" class="name form-control" name='name' value="" required>
            </div>
        </div>
        <div class="form-group row">
            <label for="password" class="col-md-2 control-label">密码</label>
            <div class="col-md-8">
                <input type='password' id="password" class="password form-control" name='password' required>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-md-offset-3 col-md-6">
                <input type='submit' class="submit-btn btn btn-lg btn-primary btn-block" name='submit' value='注册'>
            </div>
        </div>
    </form>
    <br>
</div>
</body>
</html>
