<%--
  Created by IntelliJ IDEA.
  User: ZhangYF
  Date: 2017/2/16
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student</title>
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
            <div class="userinfo">
                <h3>1234567</h3>
                <h3>司马懿</h3>
            </div>
            <div class="console">
                <ul class="nav nav-tabs nav-stacked">
                    <li class="active"><a href="#course" data-toggle="tab">课程管理</a></li>
                    <li ><a href="#account" data-toggle="tab">账户管理</a></li>
                    <li ><a href="#vip" data-toggle="tab">会员管理</a></li>
                    <li ><a href="#statistics" data-toggle="tab">统计分析</a></li>
                </ul>
            </div>
            <div class="logout">
                <h3><a href="${contextPath}/logout/student">退出登录</a></h3>
            </div>
        </div>
        <div class="show-page col-md-9">
            <div class="tab-content">
                <div class="tab-pane fade in active" id="course">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#choose-course"  data-toggle='tab'>选择课程</a></li>
                        <li><a href="#reserve-course"  data-toggle='tab'>我的预定</a></li>
                        <li><a href="#studying-course" data-toggle='tab'>我的学习</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="choose-course">
                            <div class="course-list-panel">
                                <ul class="courses-list">
                                    <c:forEach var="course" items="${coursesAll}">
                                        <li>
                                            <div class="course-item row">
                                                <div class="col-md-3 course-name">${course.courseName}</div>
                                                <div class="col-md-3 course-time">${course.startTime}</div>
                                                <div class="col-md-2 course-teacher">${course.teacher}</div>
                                                <div class="col-md-2 course-price">${course.price}</div>
                                                <div class="col-md-2"><a class="choose-btn" href="">参加</a></div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                    <li>
                                        <div class="course-item row">
                                            <div class="col-md-3 course-name">J2EE与中间件</div>
                                            <div class="col-md-3 course-time">2017-01-26</div>
                                            <div class="col-md-2 course-teacher">拉拉</div>
                                            <div class="col-md-2 course-price">26.9</div>
                                            <div class="col-md-2"><a class="choose-btn" href="">参加</a></div>
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
                            <h3>J2EE与中间件1</h3>
                            <h3>J2EE与中间件2</h3>
                        </div>
                        <div class="tab-pane fade" id="reserve-course">
                            <h3>J2EE与中间件3</h3>
                            <h3>J2EE与中间件4</h3>
                        </div>
                        <div class="tab-pane fade" id="studying-course">
                            <h3>J2EE与中间件5</h3>
                            <h3>J2EE与中间件6</h3>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="account">
                    <div class="account-page">
                        <div class="account-banance">
                            <p>余额： 333 元</p>
                            <label for="recharge">充值金额：</label>
                            <input type="text" id="recharge" name="recharge">
                            <input type="submit" class="submit-btn btn btn-lg btn-primary btn-block" name='submit-recharge' value='充值'>
                        </div>
                        <div class="bankcard">

                            <form class="form-horizontal" role="form" method='POST' action='${contextPath}'>
                                <label for="bankcard">银行卡号:</label>
                                <input type="text" id="bankcard" name="bankcard" class="bankcard form-control" value="1234567890">
                                <input type="submit" class="submit-btn btn btn-lg btn-primary btn-block" name='submit-bind' value='绑定'>
                            </form>

                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="vip">
                    <div class="vip-rank">
                        <p>会员等级： 0 级</p>
                    </div>
                    <div class="points">
                        <p> 积分： 300 可用</p>
                    </div>
                    <div class="vip-manage">
                        <button class="stop-vip-btn">停止会员</button>
                        <button class="exchange-point-btn">兑换积分</button>
                    </div>

                </div>
                <div class="tab-pane fade" id="statistics">
                    <div class="statistics-page">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#end-course"  data-toggle='tab'>学习记录</a></li>
                            <li><a href="#drop-course"  data-toggle='tab'>退课记录</a></li>
                            <li><a href="#consumption" data-toggle='tab'>消费记录</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="end-course">
                                <div class="course-list-panel">
                                    <ul class="courses-list">
                                        <li>
                                            <div class="course-item row">
                                                <div class="col-md-6 course-name">J2EE与中间件</div>
                                                <div class="col-md-6 course-time">2017-01-26</div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="course-item row">
                                                <div class="col-md-6 course-name">J2EE与中间件1</div>
                                                <div class="col-md-6 course-time">2017-01-22</div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="drop-course">
                                <div class="course-list-panel">
                                    <ul class="courses-list">
                                        <li>
                                            <div class="course-item row">
                                                <div class="col-md-6 course-name">软件工程</div>
                                                <div class="col-md-6 course-time">2017-01-26</div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="course-item row">
                                                <div class="col-md-6 course-name">嵌入式</div>
                                                <div class="col-md-6 course-time">2017-01-22</div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="consumption">
                                <div class="course-list-panel">
                                    <ul class="courses-list">
                                        <li>
                                            <div class="course-item row">
                                                <div class="col-md-5 course-time">2017-01-26</div>
                                                <div class="col-md-5 course-name">J2EE与中间件</div>
                                                <div class="col-md-2 course-price">26.9</div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="course-item row">
                                                <div class="col-md-5 course-time">2017-01-26</div>
                                                <div class="col-md-5 course-name">J2EE与中间件1</div>
                                                <div class="col-md-2 course-price">24.2</div>
                                            </div>
                                        </li>
                                    </ul>
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
