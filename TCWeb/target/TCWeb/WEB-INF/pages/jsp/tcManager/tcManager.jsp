<%--
  Created by IntelliJ IDEA.
  User: ZhangYF
  Date: 2017/2/17
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="${contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/css/style.css">
</head>
<body>
<nav class="navbar navbar-default navbar-static-top" role="navigation">
    <h3>TRAINING COLLEGE</h3>
</nav>
<div class="body-page row">
    <div class="user-nav col-md-3">
        <div class="manager-info">
            <h3>9000001</h3>
            <h3>刘峰</h3>
        </div>
        <div class="console">
            <ul class="nav nav-tabs nav-stacked">
                <li class="active"><a href="#approve-course" data-toggle="tab">审批课程</a></li>
                <li ><a href="#balance" data-toggle="tab">结算</a></li>
                <li ><a href="#statistics" data-toggle="tab">统计</a></li>
            </ul>
        </div>
        <div class="logout">
            <h3><a href="${contextPath}/logout/manager">退出登录</a></h3>
        </div>
    </div>
    <div class="show-page col-md-9">
        <div class="tab-content">
            <div class="tab-pane fade in active" id="approve-course">
                <div class="approve-page">
                    <div class="row course-approve-item">
                        <div class="col-md-3 course-name">J2EE与中间件</div>
                        <div class="col-md-3 course-starttime">2016-10-12</div>
                        <div class="col-md-2 course-teacher">王松</div>
                        <div class="col-md-2 course-price">342.0</div>
                        <div class="col-md-2 course-result">
                            <a class="course-pass" href="">YES</a><span>/</span>
                            <a class="course-pass" href="">NO</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="balance">
                <div class="balance-page">
                    <div class="row">
                        <div class="col-md-3 institution-name">南大清脑</div>
                        <div class="col-md-3 institution-money">188888</div>
                        <div class="col-md-3 institution-balance">
                            <button class="col-md-2 balance-btn">结算</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="statistics">
                <div class="">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#institution-statistic"  data-toggle='tab'>机构统计</a></li>
                        <li><a href="#student-statistic"  data-toggle='tab'>学员统计</a></li>
                        <li><a href="#finance" data-toggle='tab'>财务统计</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="institution-statistic">
                            <div class="institution-list-panel">
                                <div class="row">
                                    <div class="col-md-4 institution-name">南大清脑</div>
                                    <div class="col-md-4 institution-stud-num">1024</div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="student-statistic">
                            <div class="stud-list-panel">
                                <div class="row">
                                    <div class="col-md-3 student-id">1234567</div>
                                    <div class="col-md-3 stud-study-num">5</div>
                                    <div class="col-md-3 stud-end-num">16</div>
                                    <div class="col-md-3 stud-drop-num">8</div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="finance">
                            <div class="finance-panel">
                                <div class="row">
                                    <div class="col-md-3 date-time">2016-01</div>
                                    <div class="col-md-3 income">32000</div>
                                    <div class="col-md-3 expend">19100</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
