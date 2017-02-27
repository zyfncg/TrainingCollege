<%--
  Created by IntelliJ IDEA.
  User: ZhangYF
  Date: 2017/2/17
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Institution</title>
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
        <div class="institution-info">
            <h3>9000001</h3>
            <h3>南京大学软件学院</h3>
        </div>
        <div class="console">
            <ul class="nav nav-tabs nav-stacked">
                <li class="active"><a href="#course" data-toggle="tab">班级管理</a></li>
                <li ><a href="#account" data-toggle="tab">账户管理</a></li>
                <li ><a href="#student-record" data-toggle="tab">学员登记</a></li>
                <li ><a href="#course-statistic" data-toggle="tab">课程统计</a></li>
            </ul>
        </div>
        <div class="logout">
            <h3><a href="${contextPath}/logout/institution">退出登录</a></h3>
        </div>
    </div>
    <div class="show-page col-md-9">
        <div class="tab-content">
            <div class="tab-pane fade in active" id="course">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#have-course"  data-toggle='tab'>已开课程</a></li>
                    <li><a href="#new-course"  data-toggle='tab'>申请开课</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane fade in active" id="have-course">
                        <div class="course-list-panel">
                            <ul class="courses-list">
                                <li>
                                    <div class="course-item row">
                                        <div class="col-md-3 course-name">J2EE与中间件</div>
                                        <div class="col-md-3 course-time">2017-01-26</div>
                                        <div class="col-md-2 course-teacher">拉拉</div>
                                        <div class="col-md-2 course-price">26.9</div>
                                        <div class="col-md-2"><a class="choose-btn" href="">修改</a></div>
                                    </div>
                                </li>
                                <li>
                                    <div class="course-item row">
                                        <div class="col-md-3 course-name">J2EE与中间件1</div>
                                        <div class="col-md-3 course-time">2017-01-22</div>
                                        <div class="col-md-2 course-teacher">拉拉1</div>
                                        <div class="col-md-2 course-price">35.9</div>
                                        <div class="col-md-2"><a class="choose-btn" href="">参加</a></div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="new-course">
                        <div class="course-page">
                            <form class="form-horizontal" role="form" method='POST' action='#'>
                                <div class="form-group row">
                                    <label for="coursename" class="col-md-4 control-label">课程名</label>
                                    <div class="col-md-8">
                                        <input type='text' id="coursename" class="form-control" name='coursename' required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="starttime" class="col-md-2 control-label">开课时间</label>
                                    <div class="col-md-8">
                                        <input type='text' id="starttime" class="form-control" name='starttime' required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="endtime" class="col-md-2 control-label">结课时间</label>
                                    <div class="col-md-8">
                                        <input type='text' id="endtime" class="form-control" name='endtime' required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="teacher" class="col-md-2 control-label">教师</label>
                                    <div class="col-md-8">
                                        <input type='text' id="teacher" class="form-control" name='teacher' required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="price" class="col-md-2 control-label">价格</label>
                                    <div class="col-md-8">
                                        <input type='text' id="price" class="form-control" name='price' required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-md-offset-3 col-md-6">
                                        <input type='submit' class="submit-btn btn btn-lg btn-primary btn-block" name='submit' value='申请开课'>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="account">
                <div class="account-page">
                    <div class="bankcard">
                        <form class="form-horizontal" role="form" method='POST' action='${contextPath}'>
                            <label for="bankcard">银行卡号:</label>
                            <input type="text" id="bankcard" name="bankcard" class="bankcard form-control" value="1234567890">
                            <input type="submit" class="submit-btn btn btn-lg btn-primary btn-block" name='submit-bind' value='绑定'>
                        </form>

                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="student-record">
                <div class="">
                    <div class="course-info">
                        <h3>J2EE与中间件</h3>
                        <div class="student-record">
                            <div class="row">
                                <div class="col-md-3 course-name"><p>J2EE与中间件</p></div>
                                <div class="col-md-3 student-id"><p>1234567</p></div>
                                <div class="col-md-3 grade">
                                    <input type="text" class="grade">
                                </div>
                            </div>
                            <div class="save">
                                <button class="col-md-3 col-md-offset-3 save-btn" name="save">保存</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="course-statistic">
                <div class="statistics-page">
                    <div class="row">
                        <div class="col-md-3 course-name"><p>J2EE与中间件</p></div>
                        <div class="col-md-2 course-reserve-num"><p>55</p></div>
                        <div class="col-md-2 course-dreserve-num"><p>9</p></div>
                        <div class="col-md-2 course-drop-num"><p>11</p></div>
                        <div class="col-md-2 course-income"><p>3200</p></div>
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
