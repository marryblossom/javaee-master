<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src=".././lib/js/jquery-1.11.1.min.js"></script>
<link href=".././lib/css/bootstrap.css" rel="stylesheet"/>
<script src=".././lib/js/bootstrap.min.js"></script>
<head>
  <title></title>
</head>
<body>
<jsp:include page="/jsp/head.jsp"/>
<div>
<form action="addSchema" method="post">
  <table>
    <tr>
      <td width="50px" align="center">课程</td>
      <td width="50px" align="center">教练</td>
      <td width="90px" align="center">时间</td>
      <td width="50px" align="center"></td>
    </tr>
    <tr>
      <td align="center">
        <select name="courseId">
          <c:forEach items="${courses}" var="course" varStatus="status">
          <option value ="<c:out value="${course.courseId}"/>"><c:out value="${course.name}"/></option>
          </c:forEach>
        </select>
      </td>
      <td align="center">
        <select name="coachId">
          <c:forEach items="${employees}" var="employee" varStatus="status">
          <option value ="<c:out value="${employee.emloyeeId}"/>"><c:out value="${employee.employeeName}"/></option>
          </c:forEach>
          </select>
      </td>
      <td align="center">
        <input type="text" name="date"/>
      </td>
      <td align="center">
        <input type="submit" value="Submit" />
      </td>
    </tr>

  </table>
</form>
  </div>
<div>
  <table>
    <tr>
      <td align="center">课程名称：</td>
      <td align="center">负责教练：</td>
      <td align="center">课程时间安排：</td>
      <td align="center">课程状态：</td>
      <td></td>
      <td></td>
    </tr>
    <c:forEach items="${schemaTables}" var="item" varStatus="status">
      <tr>
        <td width="50px" align="center"><c:out value="${item.course.name}"/></td>
        <td width="30px" align="center"><c:out value="${item.employee.employeeName}"/></td>
        <td width="30px" align="center"><c:out value="${item.date}"/></td>
        <td width="30px" align="center"><c:out value="${item.state}"/></td>
        <td width="50px" align="center"><a type="button" href="/web/schemaOperate/deleteSchema?schemasId=<c:out value="${item.schemasId}"/>">delete</a></td>
          <td width="50px" align="center"><a type="button" href="/web/schemaOperate/goToSchemaUpdate?schemasId=<c:out value="${item.schemasId}"/>">update</a></td>
      </tr>
    </c:forEach>
  </table>
</div>

</body>
</html>
