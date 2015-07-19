<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<jsp:include page="/jsp/head.jsp"/>
<form action="addCourse" method="post">
  <table>
    <tr>
      <td align="center">课程名称：</td>
      <td align="center">课程简介：</td>
      <td></td>
    </tr>
    <tr>
      <td><input type="text" name="courseName"/></td>
      <td><input type="text" name="introduction"/></td>
      <td><input type="submit" value="Submit" /></td>
    </tr>
  </table>


</form>
<table>
  <tr>
    <td align="center">课程名称：</td>
    <td align="center">课程简介：</td>
    <td align="center">课程状态：</td>
    <td align="center"></td>
    <td align="center"></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <c:forEach items="${courses}" var="item" varStatus="status">
    <tr>
      <td width="50px" align="center"><c:out value="${item.name}"/></td>
      <td width="30px" align="center"><c:out value="${item.introduction}"/></td>
      <td width="30px" align="center"><c:out value="${item.state}"/></td>
      <td width="30px" align="center"><a type="button" href="">unlock </a></td>
      <td width="30px" align="center"><a type="button" href="/web/courseOperate/arrangement?courseId=<c:out value="${item.courseId}"/>">arrangement</a></td>
      <td width="30px" align="center"><a type="button" href="/web/courseOperate/deleteCourse?courseId=<c:out value="${item.courseId}"/>">delete</a></td>
      <td width="30px" align="center"><a type="button" href="/web/courseOperate/goToCourseUpdate?courseId=<c:out value="${item.courseId}"/>">update</a></td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
