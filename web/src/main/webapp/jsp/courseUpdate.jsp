<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: marry
  Date: 7/7/15
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

  <title></title>
  <script src=".././lib/js/jquery-1.11.1.min.js"></script>
  <link href=".././lib/css/bootstrap.css" rel="stylesheet"/>
  <script src=".././lib/js/bootstrap.js"></script>
  <script src=".././lib/js/bootstrap-table.js"></script>
  <link href=".././calendar/styles/glDatePicker.default.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href=".././lib/css/bootstrap-table.css">
  <script src=".././lib/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="/jsp/head.jsp"/>


<form action="updateCourse" method="post">
  <table data-toggle="table" data-url="data.json" data-striped="true">
    <tr>
      <td width="50px" align="center">课程名称</td>
      <td width="90px" align="center">课程简介</td>
      <td width="50px" align="center"></td>
    </tr>

    <tr>

      <td width="50px" align="center" hidden><input name="courseId" type="text" value="<c:out value="${course.courseId}"/>"/></td>
      <td width="50px" align="center"><input name="courseName" type="text" value="<c:out value="${course.name}"/>"/></td>
      <td width="50px" align="center"><input name="introduction" type="text" value="<c:out value="${course.introduction}"/>"/></td>
      <td><input type="submit" value="Submit" /></td>
    </tr>
  </table>
</form>
</body>
</html>
