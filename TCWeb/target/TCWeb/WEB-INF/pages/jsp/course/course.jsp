<%--
  Created by IntelliJ IDEA.
  User: ZhangYF
  Date: 2017/3/12
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course</title>
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
<div class="center-page">
    <div class="course-page">
        <form class="form-horizontal" role="form" method="post">
            <div class="form-group row">
                <label for="courseid" class="col-md-2 control-label">课程编号</label>
                <div class="col-md-8">
                    <input type='text' id="courseid" class="form-control" name='courseid' value="${course.courseID}" readonly>
                </div>
            </div>
            <div class="form-group row">
                <label for="coursename" class="col-md-2 control-label">课程名</label>
                <div class="col-md-8">
                    <input type='text' id="coursename" class="form-control" name='coursename' value="${course.courseName}" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="starttime" class="col-md-2 control-label">开课时间</label>
                <div class="col-md-8">
                    <input type='text' id="starttime" class="form-control" name='starttime' value="${course.startTime}" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="endtime" class="col-md-2 control-label">结课时间</label>
                <div class="col-md-8">
                    <input type='text' id="endtime" class="form-control" name='endtime' value="${course.endTime}" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="teacher" class="col-md-2 control-label">教师</label>
                <div class="col-md-8">
                    <input type='text' id="teacher" class="form-control" name='teacher' value="${course.teacher}" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="price" class="col-md-2 control-label">价格</label>
                <div class="col-md-8">
                    <input type='text' id="price" class="form-control" name='price'value="${course.price}" required>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-md-offset-3 col-md-6">
                    <input class="submit-btn btn btn-lg btn-primary btn-block" name='submit-btn' value='提交'>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
<script src="${contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
<script src="${contextPath}/js/jquery-ui.min.js"></script>
<script>
    $(document).ready(
        function () {
            $("#starttime").datepicker({"dateFormat":"yy-mm-dd"});
            $("#endtime").datepicker({"dateFormat":"yy-mm-dd"});
        }

    );
    $(".submit-btn").click(function () {
        $.ajax({
            type: "POST",
            dataType: 'json',
            url:"/institution/modifyCourse",
            data:$(".form-horizontal").serializeArray(),
            success:function(data){
                alert(data.msg);
                window.location.href = "/institution/institution";
            }
        });

    });
</script>
</html>
