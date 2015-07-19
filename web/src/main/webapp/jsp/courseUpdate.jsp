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

</head>
<body>
<jsp:include page="/jsp/head.jsp"/>


<form action="updateCourse" method="post">
  <table>
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
