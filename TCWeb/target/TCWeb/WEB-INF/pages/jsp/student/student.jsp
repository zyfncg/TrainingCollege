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
    <link href="${contextPath}/css/jquery-ui.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/css/style.css">
    <script>
        function chooesCourse(obj) {
            var ele = $(obj);
            var courseid = ele.attr("id");
            $( "#choose-course-confirm" ).dialog({
                resizable: false,
                height:240,
                modal: true,
                buttons: {
                    "确认": function() {
                        $(ele).text("已选");
                        $(ele).attr("onclick","");
                        $( this ).dialog( "close" );
                        $.ajax({
                            type: "POST",
                            dataType: 'json',
                            url:"/student/reserveCourse",
                            data:{
                                "courseid":courseid
                            },
                            success:function(data){
                                alert(data.msg);
                                window.location.reload();
                            }
                        });
                    },
                    "取消": function() {
                        $( this ).dialog( "close" );
                    }
                }
            });
        }
        function dropReserveCourse(obj) {
            var ele = $(obj);
            var courseid = ele.attr("id");
            $( "#dropReserve-course-confirm" ).dialog({
                resizable: false,
                height:240,
                modal: true,
                buttons: {
                    "确认": function() {
                        $(ele).text("已退");
                        $(ele).attr("onclick","");
                        $( this ).dialog( "close" );
                        $.ajax({
                            type: "POST",
                            dataType: 'json',
                            url:"/student/dropReserveCourse",
                            data:{
                                "courseid":courseid
                            },
                            success:function(data){
                                alert(data.msg);
                                window.location.reload();
                            }
                        });
                    },
                    "取消": function() {
                        $( this ).dialog( "close" );
                    }
                }
            });
        }
        function dropCourse(obj) {
            var ele = $(obj);
            var courseid = ele.attr("id");
            $( "#drop-course-confirm" ).dialog({
                resizable: false,
                height:240,
                modal: true,
                buttons: {
                    "确认": function() {
                        $(ele).text("已退");
                        $(ele).attr("onclick","");
                        $( this ).dialog( "close" );
                        $.ajax({
                            type: "POST",
                            dataType: 'json',
                            url:"/student/dropCourse",
                            data:{
                                "courseid":courseid
                            },
                            success:function(data){
                                alert(data.msg);
                                window.location.reload();
                            }
                        });
                    },
                    "取消": function() {
                        $( this ).dialog( "close" );
                    }
                }
            });
        }
    </script>
</head>
<body>
    <nav class="navbar navbar-default navbar-static-top" role="navigation">
        <h3>TRAINING COLLEGE</h3>
    </nav>
    <div class="body-page row">
        <div class="user-nav col-md-3">
            <div class="userinfo">
                <h3>${studentid}</h3>
                <h3>${studentName}</h3>
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
                                <table class="table table-responsive table-condensed">
                                    <thead>
                                    <tr>
                                        <th>课程名</th>
                                        <th>开始时间</th>
                                        <th>结束时间</th>
                                        <th>教师</th>
                                        <th>价格</th>
                                        <th>选择</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="course" items="${unchoooseCourses}">
                                        <tr>
                                            <td>${course.courseName}</td>
                                            <td>${course.startTime}</td>
                                            <td>${course.endTime}</td>
                                            <td>${course.teacher}</td>
                                            <td>${course.price}</td>
                                            <td><button id="${course.courseID}" class="choose-btn btn" onclick="chooesCourse(this)">参加</button></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                        <div class="tab-pane fade" id="reserve-course">
                            <div class="course-list-panel">
                                <table class="table table-responsive table-condensed">
                                    <thead>
                                    <tr>
                                        <th>课程名</th>
                                        <th>开始时间</th>
                                        <th>结束时间</th>
                                        <th>教师</th>
                                        <th>价格</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="course" items="${resserveCourses}">
                                        <tr>
                                            <td>${course.course.courseName}</td>
                                            <td>${course.course.startTime}</td>
                                            <td>${course.course.endTime}</td>
                                            <td>${course.course.teacher}</td>
                                            <td>${course.course.price}</td>
                                            <td><button id="${course.course.courseID}" class="drop-reserve-btn btn" onclick="dropReserveCourse(this)">退订</button></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="studying-course">
                            <div class="course-list-panel">
                                <table class="table table-responsive table-condensed">
                                    <thead>
                                    <tr>
                                        <th>课程名</th>
                                        <th>开始时间</th>
                                        <th>结束时间</th>
                                        <th>教师</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="course" items="${studyCourses}">
                                        <tr>
                                            <td>${course.course.courseName}</td>
                                            <td>${course.course.startTime}</td>
                                            <td>${course.course.endTime}</td>
                                            <td>${course.course.teacher}</td>
                                            <td><button id="${course.course.courseID}" class="drop-btn btn" onclick="dropCourse(this)">退课</button></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="account">
                    <div class="account-page">
                        <div class="account-banance">
                            <h4>余额：<span>${balance}</span> 元</h4>
                            <br>
                        </div>
                        <div class="bankcard">

                            <div class="form-horizontal" role="form">
                                <div class="row">
                                    <label class="col-md-2" for="bankcard">银行卡号:</label>
                                </div>
                                <div class="row" style="padding-left: 15px">

                                    <input type="text" id="bankcard" name="bankcard" class="bankcard col-md-6" value="${bankcardid}">
                                    <input type="submit" class="bind-btn btn btn-primary col-md-1" name='submit-bind' value='绑定'>
                                </div>
                                <br>
                                <div class="row">
                                    <label class="col-md-2" for="recharge">充值金额：</label>
                                </div>
                                <div class="row" style="padding-left: 15px">

                                    <input type="text" id="recharge" name="recharge" class="col-md-2">
                                    <input type="submit" class="recharge-btn btn btn-primary col-md-1" name='submit-recharge' value='充值'>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="vip">
                    <div class="vip-rank">
                        <p>会员等级：<span class="vip">${vip}</span> 级  <span class="vipState">${vipState}</span></p>
                    </div>
                    <div class="points">
                        <p> 积分： <span>${points}</span></p>
                    </div>
                    <div class="vip-manage">
                        <button class="stop-vip-btn btn btn-primary">停止会员</button>
                        <button class="exchange-point-btn btn btn-primary">兑换积分</button>
                    </div>

                </div>
                <div class="tab-pane fade" id="statistics">
                    <div class="statistics-page">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#end-course"  data-toggle='tab'>学习记录</a></li>
                            <li><a href="#consumption" data-toggle='tab'>消费记录</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="end-course">
                                <div class="course-list-panel">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>课程名</th>
                                                <th>开始时间</th>
                                                <th>结束时间</th>
                                                <th>教师</th>
                                                <th>成绩</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="course" items="${studyCourses}">
                                            <tr>
                                                <td>${course.course.courseName}</td>
                                                <td>${course.course.startTime}</td>
                                                <td>${course.course.endTime}</td>
                                                <td>${course.course.teacher}</td>
                                                <td>${course.grade}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                </div>
                            </div>

                            <div class="tab-pane fade" id="consumption">
                                <div class="course-list-panel">
                                    <table class="table table-striped">
                                        <thead>
                                        <tr>
                                            <th>时间</th>
                                            <th>课程名</th>
                                            <th>消费金额</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="course" items="${studyCourses}">
                                            <tr>
                                                <td>${course.scTime}</td>
                                                <td>${course.course.courseName}</td>
                                                <td>${course.course.price}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="window-dialog" style="display: none;">
        <div id="choose-course-confirm" title="提示">
            <p>您确认购买该课程吗？</p>
        </div>
        <div id="dropReserve-course-confirm" title="提示">
            <p>您确认退订该课程吗？</p>
        </div>
        <div id="drop-course-confirm" title="提示">
            <p>退课后不返还学费，您确认退课吗？</p>
        </div>
    </div>

    <script src="${contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${contextPath}/js/bootstrap.min.js"></script>
    <script src="${contextPath}/js/jquery-ui.min.js"></script>

    <script>
        $(document).ready(
            function () {
                var vip = $(".vip-rank .vip").text();
                vip = Number(vip);
                if (vip <= 0) {
                    $(".stop-vip-btn").attr("disabled", true);
                }
            }

        );

        $(".stop-vip-btn").click(function () {
            var vip = $(".vip-rank .vipState").text();
            if(vip != "未激活"){
                $.ajax({
                    type:"POST",
                    dataType: 'json',
                    url:"/student/cancelvip",
                    error:function(data){
                        alert("出错了！！:"+data.msg);
                    },
                    success:function(data){
                        alert(data.msg);
                        window.location.reload();
                    }
                });
            }
        });
        $(".exchange-point-btn").click(function () {
            var point = $(".points span").text();
            if(point > 0){
                $.ajax({
                    type:"POST",
                    dataType: 'json',
                    url:"/student/exchangepoint",
                    error:function(data){
                        alert("出错了！！");
                    },
                    success:function(data){
                        alert(data.msg);
                        window.location.reload();
                    }
                });
            }else{
                alert("积分不足,无法兑换");
            }
        });
        $(".bind-btn").click(function () {
            var bankcard = $("#bankcard").val();
            if(bankcard != null){
                $.ajax({
                    data:{
                        "bankcard":bankcard
                    },
                    type:"POST",
                    dataType: 'json',
                    url:"/student/bindbankcard",
                    error:function(data){
                        alert("出错了！！:"+data.msg);
                    },
                    success:function(data){
                        alert(data.msg);
                        window.location.reload();
                    }

                });
            }else{
                alert("银行卡号不能为空");
            }

        });
        $(".recharge-btn").click(function () {
            var money = $("#recharge").val();
            $.ajax({
                data:{
                    "money":money
                },
                type:"POST",
                dataType: 'json',
                url:"/student/recharge",
                error:function(data){
                    alert("出错了！！:");
                },
                success:function(data){
                    alert(data.msg);
                    $(".account-banance span").text(data.balance);
                    window.location.reload();
                }
            });

        });



    </script>
</body>
</html>
