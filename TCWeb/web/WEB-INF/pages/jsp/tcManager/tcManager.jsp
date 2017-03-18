<%--
  Created by IntelliJ IDEA.
  User: ZhangYF
  Date: 2017/2/17
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="authorUser-nav col-md-3">
        <div class="manager-info" style="margin-bottom: 30px;text-align: center">
            <h4>编号：${managerid}</h4>
            <br>
            <h4>姓名：${managerName}</h4>
        </div>
        <div class="console">
            <ul class="nav nav-tabs nav-stacked">
                <li class="active"><a href="#approve-course" data-toggle="tab"><h4>审批课程</h4></a></li>
                <li ><a href="#balance" data-toggle="tab"><h4>结算</h4></a></li>
                <li ><a href="#statistics" data-toggle="tab"><h4>统计</h4></a></li>
            </ul>
        </div>
        <div class="logout" style="text-align: center;margin-top: 20px">
            <h4><a href="${contextPath}/TCManager/logout">退出登录</a></h4>
        </div>
    </div>
    <div class="show-page col-md-9">
        <div class="tab-content">
            <div class="tab-pane fade in active" id="approve-course">
                <div class="approve-page">
                    <div class="course-list-panel">
                        <table class="table table-responsive table-condensed">
                            <thead>
                            <tr>
                                <th>机构</th>
                                <th>课程名</th>
                                <th>开始时间</th>
                                <th>结束时间</th>
                                <th>教师</th>
                                <th>价格</th>
                                <th>审批</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="course" items="${approveCourses}">
                                <tr>
                                    <td>${course.institution.name}</td>
                                    <td>${course.courseName}</td>
                                    <td>${course.startTime}</td>
                                    <td>${course.endTime}</td>
                                    <td>${course.teacher}</td>
                                    <td>${course.price}</td>
                                    <td><a class="course-pass" id="${course.courseID}" onclick="passCourse(this)">YES</a>
                                        <span>/</span>
                                        <a class="course-deny" id="${course.courseID}" onclick="denyCourse(this)">NO</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
            <div class="tab-pane fade" id="balance">
                <div class="balance-page">
                    <br>
                    <div class="course-list-panel">
                        <table class="table table-responsive table-condensed">
                            <thead>
                            <tr>
                                <th>机构</th>
                                <th>课程编号</th>
                                <th>课程名</th>
                                <th>结课时间</th>
                                <th>教师</th>
                                <th>收入</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="course" items="${settleCourses}">
                                <tr>
                                    <td>${course.institution.name}</td>
                                    <td>${course.courseID}</td>
                                    <td>${course.courseName}</td>
                                    <td>${course.endTime}</td>
                                    <td>${course.teacher}</td>
                                    <td>${course.unIncome}</td>
                                    <td><button id="${course.courseID}" class="choose-btn btn" onclick="settleCourse(this)">结算</button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>

                </div>
            </div>
            <div class="tab-pane fade" id="statistics">
                <div class="">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#institution-statistic"  data-toggle='tab'>机构统计</a></li>
                        <li><a href="#student-statistic"  data-toggle='tab'>学员统计</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="institution-statistic">
                            <div class="institution-list-panel" style="max-width: 1000px; margin: 10px 20px">
                                <table class="table table-responsive table-condensed table-bordered">
                                    <thead>
                                    <tr>
                                        <th>机构编号</th>
                                        <th>机构名称</th>
                                        <th>开课数</th>
                                        <th>学生人数</th>
                                        <th>退课人数</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="institution" items="${institutionStats}">
                                        <tr>
                                            <td>${institution.institutionid}</td>
                                            <td>${institution.institutionName}</td>
                                            <td>${institution.courseNum}</td>
                                            <td>${institution.studentNum}</td>
                                            <td>${institution.dropNum}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="student-statistic">
                            <div class="stud-list-panel" style="max-width: 1000px; margin: 10px 20px">
                                <table class="table table-responsive table-condensed table-bordered">
                                    <thead>
                                    <tr>
                                        <th>学生编号</th>
                                        <th>姓名</th>
                                        <th>完成课程数</th>
                                        <th>预定课程数</th>
                                        <th>在学课程数</th>
                                        <th>退课课程数</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="student" items="${studentStats}">
                                        <tr>
                                            <td>${student.studentid}</td>
                                            <td>${student.studentName}</td>
                                            <td>${student.finishNum}</td>
                                            <td>${student.reserveNum}</td>
                                            <td>${student.studyNum}</td>
                                            <td>${student.dropNum}</td>
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
<script src="https://code.jquery.com/jquery.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
<script>
    $(document).ready(

    );

    function passCourse(obj) {
        var ele = $(obj);
        var courseid = ele.attr("id");
        $.ajax({
            type: "POST",
            dataType: 'json',
            url:"/TCManager/approveCourse",
            data: {
                "courseid": courseid,
                "result":"1"
            },
            success:function(data){
                ele.parent().parent().remove();
                alert(data.msg);
            }
        });
    }

    function denyCourse(obj) {
        var ele = $(obj);
        var courseid = ele.attr("id");
        $.ajax({
            type: "POST",
            dataType: 'json',
            url:"/TCManager/approveCourse",
            data: {
                "courseid": courseid,
                "result":"0"
            },
            success:function(data){
                ele.parent().parent().remove();
                alert(data.msg);
            }
        });
    }

    function settleCourse(obj) {
        var ele = $(obj);
        var courseid = ele.attr("id");
        $.ajax({
            type: "POST",
            dataType: 'json',
            url:"/TCManager/settleCourse",
            data: {
                "courseid": courseid,
            },
            success:function(data){
                ele.parent().parent().remove();
                alert(data.msg);
            }
        });

    }
</script>
</body>
</html>
