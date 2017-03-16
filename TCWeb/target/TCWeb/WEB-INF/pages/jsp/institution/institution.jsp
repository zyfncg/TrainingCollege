<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="${contextPath}/css/jquery-ui.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/css/style.css">
</head>
<body>
<nav class="navbar navbar-default navbar-static-top" role="navigation">
    <h3>TRAINING COLLEGE</h3>
</nav>
<div class="body-page row">
    <div class="user-nav col-md-3">
        <div class="institution-info">
            <h3>${institutionid}</h3>
            <h3>${institutionName}</h3>
        </div>
        <div class="console">
            <ul class="nav nav-tabs nav-stacked">
                <li class="active"><a href="#course" data-toggle="tab">班级管理</a></li>
                <li ><a href="#student-record" data-toggle="tab">课程登记</a></li>
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
                            <table class="table table-responsive table-condensed table-bordered">
                                <thead>
                                <tr>
                                    <th>课程名</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <th>教师</th>
                                    <th>价格</th>
                                    <th>审核状态</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="course" items="${courseList}">
                                    <tr>
                                        <td>${course.courseName}</td>
                                        <td>${course.startTime}</td>
                                        <td>${course.endTime}</td>
                                        <td>${course.teacher}</td>
                                        <td>${course.price}</td>
                                        <td><span class="course-state">${course.approveState}</span></td>
                                        <td><a class="modify-course " href="${contextPath}/institution/modifyCoursePage?courseid=${course.courseID}">修改</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                    <div class="tab-pane fade" id="new-course">
                        <div class="course-page" style="margin: 40px auto;max-width: 500px;">
                            <form class="form-horizontal" role="form" method="post">
                                <div class="form-group row">
                                    <label for="coursename" class="col-md-2 control-label">课程名</label>
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
                                        <input class="submit-btn btn btn-lg btn-primary btn-block" name='submit-btn' value='申请开课'>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <div class="tab-pane fade" id="student-record">
                <div class="course-list-panel">
                    <table class="table table-responsive table-condensed">
                        <thead>
                        <tr>
                            <th>课程名</th>
                            <th>开始时间</th>
                            <th>结束时间</th>
                            <th>教师</th>
                            <th>选择</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="course" items="${courseList}">
                            <tr>
                                <td>${course.courseName}</td>
                                <td>${course.startTime}</td>
                                <td>${course.endTime}</td>
                                <td>${course.teacher}</td>
                                <td><a href="${contextPath}/institution/recordgrade?courseid=${course.courseID}">登记</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
            <div class="tab-pane fade" id="course-statistic">
                <div class="balacne">
                    <h3>账户金额：<span>${balance}</span> 元</h3>
                </div>
                <div class="statistics-page">
                    <div class="course-list-panel">
                        <table class="table table-responsive table-condensed table-bordered">
                            <thead>
                            <tr>
                                <th>课程编号</th>
                                <th>课程名</th>
                                <th>开始时间</th>
                                <th>结束时间</th>
                                <th>教师</th>
                                <th>价格</th>
                                <th>预定人数</th>
                                <th>退定人数</th>
                                <th>退课人数</th>
                                <th>收入</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="course" items="${courseList}">
                                <tr>
                                    <td>${course.courseID}</td>
                                    <td>${course.courseName}</td>
                                    <td>${course.startTime}</td>
                                    <td>${course.endTime}</td>
                                    <td>${course.teacher}</td>
                                    <td>${course.price}</td>
                                    <td>${course.reserveNum}</td>
                                    <td>${course.dropReserveNum}</td>
                                    <td>${course.dropNum}</td>
                                    <td>${course.income}</td>
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
<script src="${contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
<script src="${contextPath}/js/jquery-ui.min.js"></script>
<script>
    $(document).ready(
        function () {
            $("#starttime").datepicker({"dateFormat":"yy-mm-dd"});
            $("#endtime").datepicker({"dateFormat":"yy-mm-dd"});

            $("tbody").find(".course-state").each(function () {
                var state = $(this).text();
                if(state == "1" || state == "2" ){
                    $(this).parent().next().children().remove();
                }
            });

        }

    );

    $(".submit-btn").click(function () {
        $.ajax({
            type: "POST",
            dataType: 'json',
            url:"/institution/createcourse",
            data:$(".form-horizontal").serializeArray(),
            success:function(data){
                alert(data.msg);
            }
        });

    });


</script>
</body>
</html>
