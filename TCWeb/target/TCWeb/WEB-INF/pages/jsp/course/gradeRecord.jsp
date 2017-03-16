<%--
  Created by IntelliJ IDEA.
  User: ZhangYF
  Date: 2017/3/12
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Grade</title>
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
    <div class="class-info">
        <h3>${course.courseID}</h3>
        <h3>${course.courseName}</h3>
        <h3>${course.teacher}</h3>
    </div>
    <br>
    <div class="record-grade">
        <table id="grade-table" class="table table-responsive table-condensed">
            <thead>
            <tr>
                <th>学生账号</th>
                <th>学生姓名</th>
                <th>成绩</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="studCourse" items="${studCourseList}">
                <tr>
                    <td>${studCourse.student.studentid}</td>
                    <td>${studCourse.student.name}</td>
                    <td><input type="text" class="grade" name="${studCourse.student.studentid}" id="${studCourse.student.studentid}" value="${studCourse.grade}" style="height: 22px;width: 100px;margin: 3px 0px"></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="save" style="max-width: 100px;margin: 20px auto">
            <button class="btn btn-primary save-btn">保存</button>
        </div>
    </div>
</div>
</body>
<script src="${contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
<script src="${contextPath}/js/jquery-ui.min.js"></script>
<script>
    $(".save-btn").click(function () {
        var json = [];
        var item;
        var id,grade;
        var courseid = $(".class-info h3:first-child").text();
        $("#grade-table tbody").find("tr").each(function () {
            var tdArr = $(this).children();
            id = tdArr.eq(0).text();
            id = String(id);
            grade = tdArr.eq(2).find("input").val();
            grade = Number(grade);
            item={};
            item['courseid'] = courseid;
            item["studentid"] = id;
            item["grade"] = grade;
            json.push(item);
        });
        $.ajax({
            type: "POST",
            dataType: 'json',
            contentType:"application/json",
            url:"/institution/savegrade",
            data:JSON.stringify(json),
            success:function(data){
                alert(data.msg);
                window.location.href = "/institution/institution";
            }
        });
    });
</script>
</html>
